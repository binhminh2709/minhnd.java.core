package util.UsingTheStandAndJavaLibray;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;

public class Can_you_find_the_intersection_of_two_Sets {
  
  /**
   * intersection: su cat treo, su giao nhau
   * 
   * Surprisingly (kinh ngac), many operations you would expect(du doan) to see on the Set interface are not there:
   * There is no clear way when dealing with Sets to perform a union (phep ho'p logic), subtraction,
   * or difference without modifying the provided Set.
   * 
   * The Collection interface provides the addAllmethod to perform a union, removeAllfor difference,
   * and retainAllfor (retain: giu lai) intersection.
   * All of these methods modify the collection on which you called the method
   * 
   * An alternative is to use the Sets class from Guava. This is a class with several static methods for manipulating sets. 
   * */
  //listing 18-12: Set operations with Guava
  @Test
  public void setOperations() {
    final Set<Integer> set1 = new HashSet<>();
    set1.add(1);
    set1.add(2);
    set1.add(3);
    set1.add(4);
    
    final Set<Integer> set2 = new HashSet<>();
    set2.add(4);
    set2.add(5);
    set2.add(6);
    
    final SetView<Integer> unionView = Sets.union(set1, set2);
    assertEquals(6, unionView.immutableCopy().size());
    for (Integer i : unionView) {
      System.out.print(i + " ");
    }
    System.out.println();
    
    final SetView<Integer> differenceView = Sets.difference(set1, set2);
    assertEquals(3, differenceView.immutableCopy().size());
    for (Integer i : differenceView) {
      System.out.print(i + " ");
    }
    System.out.println();
    
    //intersection: ngua~ tu, su cat cheo
    final SetView<Integer> intersectionView = Sets.intersection(set1, set2);
    //set2.add(2);
    for (Integer i : intersectionView) {
      System.out.print(i + " ");
    }
    /**
     * Returns an unmodifiable view of the intersection of two sets.
     * The returned set contains all elements that are contained by both backing sets.
     * The iteration order of the returned set matches that of set1.
     * */
    System.out.println();
    
    final Set<Integer> intersection = intersectionView.immutableCopy();
    //assertTrue(intersection.contains(2));
    //assertTrue(intersection.contains(3));
    for (Integer i : intersection) {
      System.out.print(i + " ");
    }
    System.out.println();
    /***/
    
    /**
     * The union, difference, and intersection methods all return a SetView object,
     * which is reliant on the underlying sets.
     * SetView has a method that can return an immutable set of the elements that meet that SetView’s requirements.
     * SetView is a view over the sets, so if the underlying sets change, the properties of SetView may change, too.
     * This is what happened with the intersection call in Listing 18-12: after that intersection call,
     * another element was added to the set2object, and that value was in set1,
     * so it was to be returned in the intersection of the two sets.
     * */
    
    /**
     * Utility classes for the core Java Collections interfaces include Maps, Sets, and Lists,
     * and utility classes for the Guava interfaces include Multisets and Multimaps
     * */
  }
}
