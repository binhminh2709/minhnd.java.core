package util.UsingTheStandAndJavaLibray;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.Set;

import org.junit.Test;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;

public class Are_any_types_of_collections_missing_Java_is_standard_library {
  
  /**
   * Guava is a set of libraries originally developed by Google for use in its own Java projects.
   * It concentrates on collections, I/O, and math, as well as some crossover with the Apache Commons libraries. 
   * It can be seen as an extension to the data structures included as part of the Java Collections API, 
   * which was covered in Chapter 5
   * 
   * Guava adds a collection called a Multiset. It enables you to have a set that allows multiple, equal elements.
   * Additional methods on the Multiset class enable you to count the number of a particular element,
   * and to turn it into a regular set.
   * Similar to the Collections library, several Multiset(interface) implementations exist,
   * such as a HashMultiset, a TreeMultiset, and a ConcurrentHashMultiset.
   * */
  
  //listing 18-5: Using a Multiset
  @Test
  public void multiset() {
    
    final Multiset<String> strings = HashMultiset.create();
    
    strings.add("one");
    strings.add("two");
    strings.add("two");
    strings.add("three");
    strings.add("three");
    strings.add("three");
    
    assertEquals(6, strings.size());
    assertEquals(2, strings.count("two"));
    
    final Set<String> stringSet = strings.elementSet();
    
    /*for (String string : stringSet) {
    	System.out.print(string + " ");
    }*/
    
    assertEquals(3, stringSet.size());
    /**
     * This keeps a running total of the count of each element.
     * It can be helpful to think of a Multiset as a Map between that element(x) and an integer(x) to keep the count.
     * 
     * Though it is definitely possible to implement the notion of a MultiSetthis way,
     * the Guava implementation is more powerful because the size method returns the element count,
     * whereas the Map implementation returns the number of unique elements.
     * Additionally, an Iterator over the Map returns each element only once, regardless of how many are in the collection.
     * */
  }
  
  //listing 18-6: A Multimap address book
  @Test
  public void multimap() {
    
    final Multimap<String, String> mapping = HashMultimap.create();
    
    mapping.put("17 High Street", "Alice Smith");
    mapping.put("17 High Street", "Bob Smith");
    mapping.put("3 Hill Lane", "Simon Anderson");
    mapping.put("4 Ronaldo", "Simon Anderson");
    
    final Collection<String> smiths = mapping.get("17 High Street");
    
    assertEquals(2, smiths.size());
    assertTrue(smiths.contains("Alice Smith"));
    assertTrue(smiths.contains("Bob Smith"));
    assertEquals(1, mapping.get("3 Hill Lane").size());
    
    final Collection<String> collection = mapping.get("17 minhnd");
    
    assertNotNull(collection); // (1)
    assertEquals(4, mapping.size()); // (2)
    
  }
  
  /**
   * The get method does not return an instance of the value type of the map; it returns a Collection of that type
   * 
   * The Multimap differs from Java’s Map interface in several ways.
   * (1) The get method never returns null—when getting a nonexistent key, an empty collection will be returned.
   * (2) Another difference is that the size-method returns the number of entries, not the number of keys.
   * */
  
  /**
   * Similar to the Multiset, you can convert your Multimap into a Java Map using the asMapmethod.
   * This returns Map<Key, Collection<Value>>
   * */
  
  /**
   * Another type of map provided by Guava is the BiMap interface.
   * This provides a two-way lookup:
   *  -  Keys can look up values.
   *  -  values can look up keys.
   *  
   * Implementing this using Java’s Map is particularly tricky; you need to keep two maps,
   * one for each direction, and ensure that a particular value is never duplicated,
   * regardless of which key it is associated with
   * */
  //listing 18-7: Using a BiMap
  @Test
  public void bimap() {
    
    final BiMap<String, String> stockToCompany = HashBiMap.create();
    final BiMap<String, String> companyToStock = stockToCompany.inverse();
    
    stockToCompany.put("GOOG", "Google");
    stockToCompany.put("AAPL", "Apple");
    
    companyToStock.put("Facebook", "FB");
    
    System.out.println("stockToCompany size: " + stockToCompany.size());
    for (String s : stockToCompany.keySet()) {
      System.out.println(s + " " + stockToCompany.get(s));
    }
    
    System.out.println("==============================");
    System.out.println("companyToStock size:" + companyToStock.size());
    for (String s : companyToStock.keySet()) {
      System.out.println(s + " " + companyToStock.get(s));
    }
    
    assertEquals("Google", stockToCompany.get("GOOG"));
    assertEquals("AAPL", companyToStock.get("Apple"));
    
    assertEquals("Facebook", stockToCompany.get("FB"));
    /**
     * The inverse method is a reference to the original(nguyên) BiMap,
     * so any additions in the originally created map are reflected(đối chiếu) in the inverted map, and vice versa
     * */
  }
}
