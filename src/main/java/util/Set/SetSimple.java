package util.Set;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class SetSimple {
  
  /**
   * A set is an unordered collection of objects that does not contain any duplicates
   * The Java Collections API contains a Set interface, extending from Collection,
   * which provides many methods for inspecting and modifying a set.
   * 
   * Listing 5-14 shows a small unit test that demonstrates the properties of a set.
   * */
  @Test
  public void setExample() {
    final Set<String> set = new HashSet<>();
    set.add("hello");
    set.add("welcome");
    set.add("goodbye");
    set.add("bye");
    set.add("hello");
    assertEquals(4, set.size());
  }
}
