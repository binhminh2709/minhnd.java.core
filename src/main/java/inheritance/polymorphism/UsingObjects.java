package inheritance.polymorphism;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class UsingObjects {
  
  @Test(expected = NullPointerException.class)
  public void expectNullPointerExceptionToBeThrown() {
    final String s = null;
    final int stringLength = s.length();
  }
  
  @Test
  public void objectMemoryAssignment() {
    /**
     * Constructs an empty list with the specified initial capacity.
     * Parameters:
     * initialCapacity the initial capacity of the list
     * */
    List<String> list1 = new ArrayList<>(20);
    assertTrue(list1.size() == 0);
    list1.add("entry in list1");
    assertTrue(list1.size() == 1);
    List list2 = list1;
    list2.add("entry in list2");
    assertTrue(list1.size() == 2);
  }
}
