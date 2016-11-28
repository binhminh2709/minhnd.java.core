package beans.property;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

import util.BeanInspector;
import util.DateUtils;

/** Some utilities to populate beans, usually based on
 *  incoming request parameters. Requires three packages
 *  from the Apache Commons library: beanutils, collections,
 *  and logging. To obtain these packages, see
 *  http://jakarta.apache.org/commons/. Also, the book's
 *  source code archive (see http://www.coreservlets.com/)
 *  contains links to all URLs mentioned in the book, including
 *  to the specific sections of the Jakarta Commons package.
 *  <P>
 *  Note that this class is in the coreservlets.beans package,
 *  so must be installed in .../coreservlets/beans/.
 *  <P>
 *  Taken from Core Servlets and JavaServer Pages 2nd Edition
 *  from Prentice Hall and Sun Microsystems Press,
 *  http://www.coreservlets.com/.
 *  &copy; 2003 Marty Hall; may be freely used or adapted.
 */

public class BeanUtilities {
  
  /** Examines all of the request parameters to see if
   *  any match a bean property (i.e., a setXxx method)
   *  in the object. If so, the request parameter value
   *  is passed to that method. If the method expects
   *  an int, Integer, double, Double, or any of the other
   *  primitive or wrapper types, parsing and conversion
   *  is done automatically. If the request parameter value
   *  is malformed (cannot be converted into the expected
   *  type), numeric properties are assigned zero and boolean
   *  properties are assigned false: no exception is thrown.
   */
  
  public static void populateBean(Object formBean, HttpServletRequest request) {
    populateBean(formBean, request.getParameterMap());
  }
  
  /** Populates a bean based on a Map: Map keys are the
   *  bean property names; Map values are the bean property
   *  values. Type conversion is performed automatically as
   *  described above.
   */
  
  @SuppressWarnings("unchecked")
  public static void populateBean(Object bean, Map<? extends Object, ? extends Object> propertyMap) {
    try {
      BeanUtils.populate(bean, (Map<String, ? extends Object>) propertyMap);
    } catch (Exception e) {
      // Empty catch. The two possible exceptions are
      // java.lang.IllegalAccessException and
      // java.lang.reflect.InvocationTargetException.
      // In both cases, just skip the bean operation.
    }
  }
  
  public static <K, V> V copyBean(K resource, List<Object> lst, V destination) {
    BeanInspector<K> beanRes = BeanInspector.get(resource.getClass());
    BeanInspector<V> beanDes = BeanInspector.get(destination.getClass());
    
    Set<String> proRes = beanRes.getPropertyNames();
    Set<String> proDes = beanDes.getPropertyNames();
    
    for (String s : proRes) {
      
      Class type = beanRes.getPropertyType(s.toString());
      
      if (type == Integer.class || type == int.class || type == Long.class || type == long.class || type == Short.class
          || type == short.class || type == Float.class || type == Double.class || type == float.class || type == double.class) {
        Object value = beanRes.getValue(resource, s.toString());
        if (value != null) {
          beanDes.setValue(destination, s.toString(), value);
        }
        ;
      }
      
      if (type == String.class) {
        if (DateUtils.isDate((String) beanRes.getValue(resource, s.toString()), "yyyy-MM-dd HH:mm:ss") == true) {
          Date toDate = DateUtils.stringToDate((String) beanRes.getValue(resource, s.toString()), "yyyy-MM-dd HH:mm:ss");
          beanDes.setValue(destination, s.toString(), toDate);
        } else {
          beanDes.setValue(destination, s.toString(), (String) beanRes.getValue(resource, s.toString()));
        }
      }
      
      if (lst != null) {
        for (int i = 0; i < lst.size(); i++) {
          if (lst.get(i) != null) {
            if (lst.get(i).getClass() == type) {
              System.out.println("==lst==type==" + type);
              BeanInspector beanObj = BeanInspector.get(lst.get(i).getClass());
              Set<String> propertyNames = beanObj.getPropertyNames();
              for (String sSub : propertyNames) {
                System.out.println(sSub + "=" + lst.get(i));
                System.out.println(beanObj.getValue(lst.get(i), sSub));
                
                Class typeSub = beanObj.getPropertyType(sSub);
                
                if (typeSub == Integer.class || typeSub == int.class || typeSub == Long.class || typeSub == long.class
                    || typeSub == Short.class || typeSub == short.class || typeSub == Float.class || typeSub == Double.class
                    || typeSub == float.class || typeSub == double.class) {
                  Object value = beanObj.getValue(lst.get(i), sSub);
                  if (value != null) {
                    beanDes.setValue(destination, sSub, value);
                  }
                  ;
                  
                }
                
                if (typeSub == String.class) {
                  if (DateUtils.isDate((String) beanObj.getValue(lst.get(i), sSub), "yyyy-MM-dd HH:mm:ss") == true) {
                    Date toDate = DateUtils.stringToDate((String) beanObj.getValue(lst.get(i), sSub), "yyyy-MM-dd HH:mm:ss");
                    beanDes.setValue(destination, sSub, toDate);
                  } else {
                    beanDes.setValue(destination, sSub, beanObj.getValue(lst.get(i), sSub));
                  }
                }
              }
              break;
            }
          }
        }
      }
    }
    return destination;
  }
}
