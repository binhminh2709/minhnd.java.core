package util.List;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class What_is_a_Queue_and_Deque {
  
  /**
   * hàng đợi và rời hàng
   * */
  
  /**
   * A Queue is a Java interface that represents a “first in, first out” data structure.
   * The interface has the methods add, to add a new element, remove to remove the oldest element, and peek (hé nhìn),
   * which returns the oldest element, but does not remove it from the data structure.
   * Listing 5-4 shows an example. The LinkedList class implements the Queue interface.
   * */
  @Test
  public void queueInsertion() {
    final Queue<String> queue = new LinkedList<>();
    queue.add("first");
    queue.add("second");
    queue.add("third");
    assertEquals("first", queue.remove());
    assertEquals("second", queue.remove());
    assertEquals("third", queue.peek());
    assertEquals("third", queue.remove());
  }
}
