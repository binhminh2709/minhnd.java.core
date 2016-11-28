package util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

public class MapSimpleUnitTest {
  
  /**
   * The Map interface is part of the Java Collections API, but, unlike List, it does not implement the Collection interface.
   * Similar to the List interface, the Map interface specifies most common operations for map implementations,
   * such as the data structure size and the ability to read, insert, and delete key-value pairs. 
   * */
  
  /**
   * Listing 5-11: Overwriting keys in map
   * */
  @Test
  public void overwriteKey() {
    final Map<String, String> preferences = new HashMap<>();
    preferences.put("like", "jacuzzi");
    preferences.put("dislike", "steam room");
    assertEquals("jacuzzi", preferences.get("like"));
    preferences.put("like", "sauna");
    assertEquals("sauna", preferences.get("like"));
  }
  
  /**
   * preserve order+ giữ được trật tự
   * 
   * Listing 5-12: Order-preserving iteration with a TreeMap
   * */
  @Test
  public void treeMapTraversal() {
    final Map<Integer, String> counts = new TreeMap<>();
    counts.put(4, "four");
    counts.put(1, "one");
    counts.put(3, "three");
    counts.put(2, "two");
    //        final Iterator<Integer> keys = counts.keySet().iterator();
    //        while (keys.hasNext()) {
    //            System.out.print(keys.next() + " ");
    //        }
    for (Map.Entry<Integer, String> entry : counts.entrySet()) {
      System.out.print(entry.getKey() + " ");
    }
    //        assertEquals(Integer.valueOf(1), keys.next());
    //        assertEquals(Integer.valueOf(2), keys.next());
    //        assertEquals(Integer.valueOf(3), keys.next());
    //        assertEquals(Integer.valueOf(4), keys.next());
    //        assertFalse(keys.hasNext());
    System.out.println("");
  }
  
  /**
   * An alternative Map implementation is the TreeMap,
   * which uses a binary tree data structure to conform to the Map interface.
   * Each node in the tree is a key-value pair. Chapter 4 covered sorting,
   * and explained the Comparable and Comparator interfaces. Those interfaces are used with a TreeMap. 
   * Keys can either be naturally ordered, in which case they must conform to the Comparable interface,
   * or you can specify your own ordering with the Comparator interface.
   * 
   * Because the TreeMap stores the keys based on their natural ordering, the hashCode method is not used at all.
   * Each element put into the TreeMap rebalances the tree, so that searching, deletion,
   * and further insertion can always be performed as efficiently as possible: O(log n).
   * */
  
  @Test
  public void hashMapTraversal() {
    final Map<Integer, Student> counts = new HashMap<>();
    counts.put(4, new Student(0, "a"));
    counts.put(1, new Student(1, "1"));
    counts.put(3, new Student(2, "2"));
    counts.put(2, new Student(3, "3"));
    counts.put(3, new Student(4, "b"));
    for (Map.Entry<Integer, Student> entry : counts.entrySet()) {
      System.out.print(entry.getKey() + " ");
    }
  }
  
  /**
   * One main difference between a TreeMap and a HashMap is that,
   * with a TreeMap the order of the keys is preserved when iterating over the whole collection,
   * because the collection is stored in order.
   * This isn’t possible with a HashMap, because the keys are stored dependent on the object’s hashCode. 
   */
  
  //@formatter:off
    private class Student {
        
        private int id;
        private String name;
        
        public Student(int id, String name) {
            super();
            this.id = id;
            this.name = name;
        }
        public int getId() { return id; }
        public void setId(int id) { this.id = id; }
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
    }
    //@formatter:on
  
  /**
   * A specialized Map implementation is the LinkedHashMap.
   * This implementation works in the same way as a HashMap, so element retrieval will be O(1),
   * but it has the added property that iterating over the keys will be in the same order as insertion,
   * 
   * Listing 5-13 A LinkedHashMap.
   * */
  @Test
  public void linkedHashMapTraversal() {
    final Map<Integer, String> counts = new LinkedHashMap<>();
    counts.put(4, "four");
    counts.put(1, "one");
    counts.put(3, "three");
    counts.put(2, "two");
    final Iterator<Integer> keys = counts.keySet().iterator();
    assertEquals(Integer.valueOf(4), keys.next());
    assertEquals(Integer.valueOf(1), keys.next());
    assertEquals(Integer.valueOf(3), keys.next());
    assertEquals(Integer.valueOf(2), keys.next());
    assertFalse(keys.hasNext());
  }
  /**
   * One final implementation to consider is the ConcurrentHashMap.
   * You should use this implementation if you ever want to share the map instance with many threads.
   * It is thread safe, and has been specifically designed to be able to return read values
   * while the values are being written to the map.
   * Only the specified row of the table is locked during a write, leaving the rest of the map available for reading.
   * 
   * The contract for ConcurrentHashMaphas been slightly tweaked from the original Map:
   * The size method returns an estimation of the map size,
   * because it does not account for any writes currently being applied.
   * */
}
