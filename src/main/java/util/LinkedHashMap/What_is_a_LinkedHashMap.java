package util.LinkedHashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

import org.junit.Test;

public class What_is_a_LinkedHashMap {
  
  /**
   * A LinkedHashMap has a confusing name—is it a HashMap? Linked in what way?
   * A LinkedHashMaphas all the properties of a HashMap—that is, quick lookup on a key index—but
   * it also preserves the order of entry into the map. Listing 8-32 demonstrates how to use a LinkedHashMap.
   * */
  
  @Test
  public void showLinkedHashmapProperties() {
    final LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();
    linkedHashMap.put(10, "ten");
    linkedHashMap.put(20, "twenty");
    linkedHashMap.put(30, "thirty");
    linkedHashMap.put(40, "forty");
    linkedHashMap.put(50, "fifty");
    
    // works like a map
    assertEquals("fifty", linkedHashMap.get(50));
    
    // Respects insertion order ,sự chú ý insert theo order
    final Iterator<Integer> keyIterator = linkedHashMap.keySet().iterator();
    assertEquals("ten", linkedHashMap.get(keyIterator.next()));
    assertEquals("twenty", linkedHashMap.get(keyIterator.next()));
    assertEquals("thirty", linkedHashMap.get(keyIterator.next()));
    assertEquals("forty", linkedHashMap.get(keyIterator.next()));
    assertEquals("fifty", linkedHashMap.get(keyIterator.next()));
    
    // The same is not true for HashMap
    final HashMap<Integer, String> regularHashMap = new HashMap<>();
    regularHashMap.put(10, "ten");
    regularHashMap.put(20, "twenty");
    regularHashMap.put(30, "thirty");
    regularHashMap.put(40, "forty");
    regularHashMap.put(50, "fifty");
    final ArrayList<String> hashMapValues = new ArrayList<>(regularHashMap.values());
    final ArrayList<String> linkedHashMapValues = new ArrayList<>(linkedHashMap.values());
    
    for (String s : hashMapValues) {
      System.out.print(s + " ");
    }
    System.out.println();
    for (String s : linkedHashMapValues) {
      System.out.print(s + " ");
    }
    
    // the lists will have the same values, but in a different order
    assertFalse(linkedHashMapValues.equals(hashMapValues));
  }
}
