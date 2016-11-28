package beans.property;

import java.beans.Expression;
import java.beans.Statement;

import org.junit.Test;

public class GetSetPropertyBean {
  
  @Test
  public void testGetSetPropertyBean() {
    
    Object object = new MyBean();
    try {
      // Get the value of id
      Expression expr = new Expression(object, "getId", new Object[0]);
      expr.execute();
      System.out.println("getId: " + (Integer) expr.getValue());
      
      // Set the value of id
      Statement stmt = new Statement(object, "setId", new Object[] { 1 });
      stmt.execute();
      expr = new Expression(object, "getId", new Object[0]);
      expr.execute();
      System.out.println("getId: " + (Integer) expr.getValue());
      
      // Get the value of name
      expr = new Expression(object, "getName", new Object[0]);
      expr.execute();
      System.out.println("getName: " + ((Integer) expr.getValue()).intValue());
      
      // Set the value of name
      stmt = new Statement(object, "setName", new Object[] { new Integer(123) });
      stmt.execute();
      
      // Get the value of mobile
      expr = new Expression(object, "getMobile", new Object[] { new byte[] { 0x12, 0x23 } });
      expr.execute();
      byte[] bytes = (byte[]) expr.getValue();
      System.out.println("getMobile: " + bytes.length);
      
      // Set the value of mobile
      stmt = new Statement(object, "setMobile", new Object[] { new byte[] { 0x12, 0x23 } });
      stmt.execute();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  public class MyBean {
    
    // Property id
    int id;
    
    // Property name
    String name;
    
    // Property mobile
    byte[] mobile;
    
    //@formatter:off
		public MyBean() { }
	  
	  public int getId() { return id; }
	  public void setId(int id) { this.id = id; }
	  
	  public String getName() { return name; }
	  public void setName(String name) { this.name = name; }
	  
	  public byte[] getMobile() { return mobile; }
	  public void setMobile(byte[] mobile) { this.mobile = mobile; }
	    //@formatter:on
  }
}
