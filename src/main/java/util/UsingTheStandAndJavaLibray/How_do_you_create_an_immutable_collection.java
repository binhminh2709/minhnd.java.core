package util.UsingTheStandAndJavaLibray;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import com.google.common.collect.ImmutableSet;

public class How_do_you_create_an_immutable_collection {
  
  /**
   * The Collections utility class in the Java Collections API provides some utility methods
   * for creating unmodifiable collections
   * immutable: bất biến
   * unmodifiable: không chỉnh đổi
   * */
  //listing 18-8: Creating an unmodifiable collection
  @Test
  public void unmodifiableCollection() {
    
    final List<Integer> numbers = new ArrayList<>();
    
    numbers.add(1);
    numbers.add(2);
    numbers.add(3);
    
    final List<Integer> unmodifiableNumbers = Collections.unmodifiableList(numbers);
    
    try {
      unmodifiableNumbers.remove(0);
    } catch (UnsupportedOperationException e) {
      return; // test passed
    }
    unmodifiableNumbers.add(4);
    assertEquals(4, unmodifiableNumbers.size());
    fail();
  }
  
  /**
   * This can be useful because any reference to unmodifiableNumbers simply cannot mutate the underlying list.
   * If references to the original list still exist, the collection referenced in the unmodifiable collection can change,
   * */
  //listing 18-9: Changing the underlying values of an unmodifiable collection
  @Test
  public void breakUnmodifiableCollection() {
    final List<Integer> numbers = new ArrayList<>();
    numbers.add(1);
    numbers.add(2);
    numbers.add(3);
    
    final List<Integer> unmodifiableNumbers = Collections.unmodifiableList(numbers);
    assertEquals(Integer.valueOf(1), unmodifiableNumbers.get(0));
    numbers.remove(0);
    assertEquals(Integer.valueOf(2), unmodifiableNumbers.get(0));
    numbers.remove(0);
    assertEquals(Integer.valueOf(3), unmodifiableNumbers.get(0));
    numbers.remove(0);
    assertEquals(0, unmodifiableNumbers.size());
  }
  
  //Guava focuses on providing utilities to create unmodifable(bất biến) collections that are also immutable. 
  //Listing 18-10 Creating immutable collections
  @Test
  public void immutableCollection() {
    
    final Set<Integer> numberSet = new HashSet<>();
    
    numberSet.add(10);
    numberSet.add(20);
    numberSet.add(30);
    
    final Set<Integer> immutableSet = ImmutableSet.copyOf(numberSet);
    
    numberSet.remove(10);
    
    //check contains = true
    assertTrue(immutableSet.contains(10));
    try {
      immutableSet.remove(10);
    } catch (Exception e) {
      return; // test passed, Exception
    }
    fail();
  }
  
  /**
   * Of course, this is very different from the unmodifiable (bat bien) approach,
   * because this will make a full copy of the collection, so if you intend to use this approach,
   * you should be aware (biet, doan truoc) of any memory constraints that could become a concern (lo lang)
   * 
   * The unmodifiable approach from the Java Collections API simply delegates to the underlying collection,
   * but intercepts calls to any mutating methods and throws an exception instead.
   * This means that any optimizations (to^? chuc) that are made for thread safety on
   * the underlying collection are still part of the unmodifiable approach,
   * even though an unmodifiable collection cannot be mutated, and is therefore thread-safe.
   * 
   * Because using Guava’s copyOfreturns a copied collection, it is optimized for immutability;
   * it does not need to ensure thread safety when accessing the elements. They simply cannot change.
   * */
  
}
