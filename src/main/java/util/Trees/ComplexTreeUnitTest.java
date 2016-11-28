package util.Trees;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ComplexTreeUnitTest {
  
  @Test
  public void insert() {
    final Node<Integer> root = new Node<>(7, null, null);
    root.setLeft(new Leaf<>(root));
    root.setRight(new Leaf<>(root));
    
    root.insert(3);
    assertTrue(root.search(3));
    assertFalse(root.search(13));
  }
}
