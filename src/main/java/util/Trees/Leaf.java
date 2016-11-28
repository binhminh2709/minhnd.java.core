package util.Trees;

public class Leaf<E extends Comparable> implements Tree<E> {
  
  private final Node<E> parent;
  
  public Leaf(Node<E> parent) {
    this.parent = parent;
  }
  
  @Override
  public boolean search(E toFind) {
    return false;
  }
  
  @Override
  public void insert(E toInsert) {
    if (toInsert.compareTo(parent.getValue()) < 0) {
      parent.setLeft(new Node<>(toInsert, new Leaf<>(parent), new Leaf<>(parent)));
    } else {
      parent.setRight(new Node<>(toInsert, new Leaf<>(parent), new Leaf<>(parent)));
    }
  }
  
  /**
  * If a search traverses to the bottom of the tree, a Leaf object will return false:
  * This object represents the absence of a value in the tree. You can write the insert method in a similar way.
  * You traverse down the tree until you hit a Leaf, and then replace that leaf with a new Node of that value,
  * itself having two leaves as children
  * */
  
  /**
   * The insert method is similar to search, with each Node checking
   * if the value to be inserted is less than or greater than the current node, and recursively traversing in the appropriate direction.
   * The Leaf then sets its parent to have a new Node instance with that new value
   * */
}
