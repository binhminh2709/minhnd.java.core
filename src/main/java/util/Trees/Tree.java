package util.Trees;

/**
 * Using object orientation, it is possible to simplify the methods using the Null Object Pattern,
 * while also removing all of the null checks. This models the tree as having two different types of nodes: 
 * ones that have values (nodes) and ones that represent the bottom of the tree (leaves).
 * 
 * Listing 5-9: shows how you can set this up, and how you would write the search method
 * */
public interface Tree<E extends Comparable> {
  
  boolean search(E toFind);
  
  void insert(E toInsert);
}
