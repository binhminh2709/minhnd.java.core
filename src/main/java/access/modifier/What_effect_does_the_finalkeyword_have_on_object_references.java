package access.modifier;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class What_effect_does_the_finalkeyword_have_on_object_references {
  
  /**
   * The final keyword works in exactly the same way for objects as it does for primitive types.
   * The value is set on variable definition, and after that, the value stored in that memory location   cannot change.
   * As previously discussed, variable definition and memory allocation are quite different between primitives and objects.
   * Although the object reference cannot change, the values held within that object can change, unless they themselves are final.
   * Listing 8-6 explores the final keyword.
   * */
  
  @Test
  public void finalReferenceChanges() {
    final int i = 42;
    // i = 43; <- uncommenting this line would result in a compiler error
    final List<String> list = new ArrayList<>(20);
    // list = new ArrayList(50); <- uncommenting this line will result in an error
    assertEquals(0, list.size());
    
    list.add("adding a new value into my list");
    assertEquals(1, list.size());
    
    list.clear();
    assertEquals(0, list.size());
  }
}
