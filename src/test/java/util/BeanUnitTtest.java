package util;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import beans.property.BeanUtilities;
import entity.Session;
import entity.Student;
import entity.WSStudent;

public class BeanUnitTtest {
  
  private String format = "YYYY-MM-DD HH:mm:ss";
  
  @Test
  public void testBean() throws IllegalAccessException, InvocationTargetException {
    //WSStudent wsStu = new WSStudent(1, 25, 170D, new Date(), "minhnd");
    WSStudent wsStu = new WSStudent();
    
    //Student stu = new Student();
    //BeanUtils.copyProperties(wsStu, stu);
    //BeanUtils.copyProperty(wsStu, name, value);
    System.out.println();
    
    Session session = new Session("java");
    Student student = new Student(1, 25, 170d, "2015-04-05 13:30:30", "minhnd", session);
    BeanInspector<Student> beanInspector = BeanInspector.get(student.getClass());
    Set<String> propertyNames = beanInspector.getPropertyNames();
    for (String s : propertyNames) {
      System.out.println(s.toString() + " dataTYpe=" + beanInspector.getPropertyType(s.toString()) + "=Value="
          + beanInspector.getValue(student, s.toString()));
      Class type = beanInspector.getPropertyType(s.toString());
      
      if (type == Session.class) {
        System.out.println("\n============");
        int deep = 0;
        BeanInspector<Session> beanDeep = BeanInspector.get(student.getSession().getClass());
        Set<String> proProperty = beanDeep.getPropertyNames();
        for (String p : proProperty) {
          System.out.println(p.toString() + " deepType=" + beanDeep.getPropertyType(p.toString()) + "=Value="
              + beanDeep.getValue(student.getSession(), p.toString()));
        }
      }
    }
    
  }
  
  @Test
  public void testCopyBean() {
    Session sesstion = new Session("java");
    Student s = new Student(1, 25, 170d, "2015-05-24 13:30:00", "minhnd", sesstion);
    List<Object> lst = new ArrayList<Object>();
    lst.add(sesstion);
    WSStudent wsStudent = BeanUtilities.copyBean(s, lst, new WSStudent());
    BeanInspector<WSStudent> bean = BeanInspector.get(wsStudent.getClass());
    Set<String> names = bean.getPropertyNames();
    System.out.println("===");
    for (String st : names) {
      System.out.println(st + "=" + bean.getValue(wsStudent, st.toString()));
    }
  }
  
}
