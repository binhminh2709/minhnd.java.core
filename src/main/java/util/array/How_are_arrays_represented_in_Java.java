package util.array;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class How_are_arrays_represented_in_Java {
  
  /**
   * The most important thing to remember about arrays in Java is that they are objects.
   * They can be treated (xu? ly) as objects. It is possible(co the?) (though not very useful) to call toString() on arrays,
   * or use them in a polymorphic sense, such as holding arrays in a container of Objects
   * */
  
  @Test
  public void arraysAsObjects() {
    Map<String, Object> mapping = new HashMap<>();
    System.out.println(mapping.size());
    mapping.put("key", new int[] { 0, 1, 2, 3, 4, 5 });
    assertTrue(mapping.get("key") instanceof int[]);
  }
  
  /**
   * Because arrays are objects, this means arrays are passed by reference,
   * so anything holding a reference to that array can mutate (thay doi?) it in some way
   * */
  
  @Test
  public void arrayReferences() {
    final int[] myArray = new int[] { 0, 1, 2, 3, 4, 5 };
    int[] arrayReference2 = myArray;
    arrayReference2[5] = 99;
    
    System.out.println(myArray[5] + " " + arrayReference2[5]);
    assertFalse(myArray[5] == 5);
  }
}
