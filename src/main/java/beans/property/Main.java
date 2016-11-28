package beans.property;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

import org.junit.Test;

public class Main {
  
  private class BeanStudent {
    
    //@formatter:off
    private int id;
    private String name;
    private int age;
    
    public BeanStudent() {}
    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    //@formatter:on
  }
  
  @Test
  public void beanStudentTest() {
    //Instantiating a Bean
    //Main bean = (Main) Beans.instantiate(ClassLoader.getSystemClassLoader(), "Main");
    //Listing the property names of a Bean
    try {
      BeanInfo beanInfo = Introspector.getBeanInfo(BeanStudent.class);//Introspector: xem xet nội tâm.
      PropertyDescriptor[] pDes = beanInfo.getPropertyDescriptors();
      
      for (PropertyDescriptor propertyDescriptor : pDes) {
        //get Property name
        String proName = propertyDescriptor.getName();
        System.out.println(proName);
      }
    } catch (IntrospectionException e) {
      e.printStackTrace();
    }
  }
}
