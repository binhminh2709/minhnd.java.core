package util.Trees;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SimpleTreeUnitTest {
  
  /**
   * Listing 5-8 shows a sample test, illustrating that the data is stored appropriately
   * Ensuring the properties of the binary tree are correct
   * */
  @Test
  public void createTree() {
    final SimpleTree<Integer> root = new SimpleTree<>(7, null, null);
    root.insert(3);
    root.insert(9);
    root.insert(10);
    assertTrue(root.search(10));
    assertEquals(Integer.valueOf(10), root.getRight().getRight().getValue());
  }
  /**
   * This test confirms that the inserted value 10 is in the tree, and that it is stored in the expected position
   * */
  
  /**
   * 
   * */
}
