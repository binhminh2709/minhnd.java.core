package util.UsingTheStandAndJavaLibray;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;
import java.util.List;

import org.junit.Test;

public class Mutating_private_fields_with_the_Reflection_API {
  
  /**
   * Unfortunately this is not the case. The fields can still be manipulated using the Reflection API.
   * Reflection has the ability to access and mutate all fields, regardless of their visibility.
   * The final modifier instructs (v, instruction-n) the JVM that no modifications are allowed on that field at all.
   * Though it may seem slightly (mỏng) underhanded (dấu) to allow access
   * to state that has genuinely (thành thật) been marked as in accessible
   * to the outside world, there actually are a few legitimate cases.
   * With Spring’s Inversion of Control container,
   * private fields with an @Autowired annotation have these fields set when the container is initializing at run time.

   * Listing 8-31 shows how you can mutate private fields from outside of a class definition.
   * */
  
  @Test
  public void mutateBookRecordState() throws NoSuchFieldException, IllegalAccessException {
    final BookRecordAPI record = new BookRecordAPI("Suzanne Collins", "The Hunger Games");
    final Field author = record.getClass().getDeclaredField("author");
    author.setAccessible(true);
    author.set(record, "Catching Fire");
    assertEquals("Catching Fire", record.getAuthor());
    
  }
  
  /**
   * Unless you are writing your own framework, very few reasons exist to change the value of a private field,
   * especially in classes you own or that are under your control
   * */
  
  @Test
  public void testFirst() {
    assertEquals(1, 1);
    assertTrue(true);
    assertFalse(false);
    assertNotNull(new String());
    
    List<String> listTest = null;
    
    if (listTest != null) {
      if (listTest.size() > 0) {
        System.out.println(true);
      } else {
        System.out.println(false);
      }
    }
    
    String sTest = null;
    if (sTest != null) {
      sTest.trim();
    }
    
  }
}
