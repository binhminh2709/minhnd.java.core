package util.jvm;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class What_is_the_difference_between_the_stack_and_the_heap {
  
  /**
   * Listing 10-1: Using stack for loops
   * */
  @Test
  public void listReversals() {
    final List<Integer> givenList = Arrays.asList(1, 2, 3, 4, 5);
    final List<Integer> expectedList = Arrays.asList(5, 4, 3, 2, 1);
    assertEquals(expectedList.size(), reverseRecursive(givenList).size());
    assertEquals(expectedList.size(), reverseIterative(givenList).size());
  }
  
  private List<Integer> reverseRecursive(List<Integer> list) {
    if (list.size() <= 1) {
      return list;
    } else {
      List<Integer> reversed = new ArrayList<>();
      reversed.add(list.get(list.size() - 1));
      reversed.addAll(reverseRecursive(list.subList(0, list.size() - 1)));
      return reversed;
    }
  }
  
  private List<Integer> reverseIterative(final List<Integer> list) {
    for (int i = 0; i < list.size() / 2; i++) {
      final int tmp = list.get(i);
      list.set(i, list.get(list.size() - i - 1));
      list.set(list.size() - i - 1, tmp);
    }
    return list;
  }
  
  /**
   * Compare the two algorithms for reversing an array. How much space does each algorithm need?
   * For the recursive defiition, each time the method is recursively called, a new list is created.
   * These lists from each method call must be held in memory until the list has been completely reversed.
   * Although the actual lists will be held on the heap (because that is where objects are stored),
   * each method call needs stack space.

   * For the iterative version, the only space needed is a variable to hold one value while it is being
   * swapped with its counterpart at the other end of the list. There are no recursive calls,
   * so the stack will not grow very deep. No new objects are allocated, so no extra space is taken on the heap.

   * Experiment with the number of elements in the list. Can you make the recursive method throw a StackOverflow Error?
   * */
}
