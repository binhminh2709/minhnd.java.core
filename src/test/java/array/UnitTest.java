/**
 * 
 */

package array;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import util.json.JsonSerializerUtils;

/**
 * @author minhnd
 *
 */
public class UnitTest {
  
  //@Test
  public void testFirst() {
    assertEquals(1, 1);
    assertTrue(true);
    assertFalse(false);
    assertNotNull(new String());
    Assert.assertArrayEquals(new String[] {}, new String[] {});
    
    List<String> listTest = null;
    if (listTest.size() > 0) {
      System.out.println(true);
    } else {
      System.out.println(false);
    }
  }
  
  @Test
  public void testString() {
    //String sName = "";
    //assertEquals(0, sName.trim());
    JsonSerializerUtils json = new JsonSerializerUtils();
    List<String> sTring = new ArrayList<String>();
    sTring.add("1");
    sTring.add("2");
    sTring.add("3");
    String sJson = json.toString(sTring);
    System.out.println(sJson);
  }
  
  @Test
  public void testJson() throws IOException {
    JsonSerializerUtils json = new JsonSerializerUtils();
    String rs = "";
    Class type = null;
    json.fromString(rs, type);
  }
  
  class Company {
    private String companyC;
    private String month;
    private String companyA;
    
  }
  
}
