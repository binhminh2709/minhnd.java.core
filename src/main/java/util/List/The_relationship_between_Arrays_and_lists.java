package util.List;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

public class The_relationship_between_Arrays_and_lists {
  
  /**
   * Before investigating how different implementations of lists work,
   * it is worth making sure you understand exactly how arrays work in Java.
   * An array is defined as a type suffixed(hậu tố) with square brackets (ô vuông dấu ngoặc).
   * shows some array types and their definitions.
   * listing 5-1: Defining arrays
   * */
  @Test
  public void arrayDefinitions() {
    final int[] integers = new int[3];
    final boolean[] bools = { false, true, true, false };
    final String[] strings = new String[] { "one", "two" };
    final Random r = new Random();
    final String[] randomArrayLength = new String[r.nextInt(100)];
  }
  
  /**
   * When defining an array, you must provide its size, either explicitly as a count,
   * such as the int array in Listing 5-1, or implied, such as the boolean array.
   * The compiler can calculate the length of that array for you.
   * 
   * You can use a computed value, such as the second Stringarray. The JVM must know the size of the array when it is constructed.
   * 
   * You can access the element of an array directly by its index value. This is known as random access
   * 
   * If you fill an array, and want to continue adding elements, you need to make the array larger.
   * In effect, you need to create a new, larger array, copy all of the current elements into that array,
   * and reassign the new array to the original reference.
   * The JVM provides help with this operation, enabling you to copy the elements in bulk.
   * The static arrayCopy method on the System object enables you to copy all or part of the array to a new array.
   * Listing 5-2 shows how to use this method to extend the length of an array by one.
   * */
  @Test
  public void arrayCopy() {
    int[] integers = { 0, 1, 2, 3, 4 };
    int[] newIntegersArray = new int[integers.length + 1];
    System.arraycopy(integers, 0, newIntegersArray, 0, integers.length);
    integers = newIntegersArray;
    integers[5] = 5;
    assertEquals(5, integers[5]);
  }
  
  /**
   * You cannot use the final modifier on the integers array, because you need to reassign the value.
   * 
   * One alternative to using arrays is to use the List interface.
   * The ArrayList class is an implementation of the List interface that uses an array internally to store the data as a list representation.
   * 
   * Considering the interface is backed by an array, the class behaves similarly to an array.
   * Directly accessing a specific element by its index is quick, because the array access is direct to a memory location
   * */
  
  private static final char[] SPECIAL_CHARACTERS = { 42, 92, 63, 58, 147, 148 };
  
  @Test
  public void checkSpecialCharacter() {
    String input = "<,>,|,~,!,@,#,$,%,^,&,*oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo";
    char[] results = input.toCharArray();
    for (char c : results) {
      if (c == SPECIAL_CHARACTERS[0] | c == SPECIAL_CHARACTERS[1] | c == SPECIAL_CHARACTERS[1] | c == SPECIAL_CHARACTERS[1]) {
        break;
      }
    }
  }
  
  @Test
  public void testCollectionList() {
    List<String> lstString = new ArrayList<>();
    lstString.add("a");
    lstString.add("b");
    lstString.add("c");
    lstString.add("d");
    
    boolean containsa = lstString.contains(new String("a"));
    boolean containsb = lstString.contains("b");
    System.out.print(containsa);
    System.out.print(containsb);
  }
  
}
