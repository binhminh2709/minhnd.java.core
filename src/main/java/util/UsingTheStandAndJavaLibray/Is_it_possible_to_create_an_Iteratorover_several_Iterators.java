package util.UsingTheStandAndJavaLibray;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.Iterables;

public class Is_it_possible_to_create_an_Iteratorover_several_Iterators {
  
  /**
   * Making your own “iterator of iterators” can be especially difficult to do by hand.
   * You need to keep a reference to your most recent iterator, and when calling hasNextor next you may need to move to
   *  the next iterator, or even beyond that, if the next iterator has no elements at all.
   *  
   *  Being asked to make this implementation can be a common interview question,
   *  but it is also provided out of the box by Guava
   * */
  
  //listing 18-11: Iterating over iterators
  @Test
  public void iterators() {
    final List<Integer> list1 = new ArrayList<>();
    list1.add(0);
    list1.add(1);
    list1.add(2);
    
    final List<Integer> list2 = Arrays.asList(3, 4);
    final List<Integer> list3 = new ArrayList<>();
    final List<Integer> list4 = Arrays.asList(5, 6, 7, 8, 9);
    
    final Iterable<Integer> iterable = Iterables.concat(list1, list2, list3, list4);
    final Iterator<Integer> iterator = iterable.iterator();
    for (int i = 0; i <= 9; i++) {
      assertEquals(Integer.valueOf(i), iterator.next());
    }
    assertFalse(iterator.hasNext());
  }
  
}
