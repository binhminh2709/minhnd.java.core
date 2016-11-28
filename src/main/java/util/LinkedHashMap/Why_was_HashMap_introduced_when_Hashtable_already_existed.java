package util.LinkedHashMap;

public class Why_was_HashMap_introduced_when_Hashtable_already_existed {
  
  /**
   * The Collections framework and the collections interfaces (Collection, Map, List, and so on) first appeared in the 1.2 release,
   * but the Hashtable class, and the list-equivalent Vector, has been part of Java since its initial release.
   * These classes were not written with a framework in mind.
   * When the Collections framework was included, Hashtable was retrofitted to match the Collection interface.
   * */
  
  /**
   * The Hashtable class is synchronized, which, though effective for parallel work,
   * provides a significant performance hit due to this overhead for any single-threaded work.
   * 
   * HashMap is not synchronized, so the developer has the power to tailor the use of this class to any particular concurrent needs.
   * It is advisable, for any serious use of a Map interface in a parallel environment,
   * to make use of ConcurrentHashMap(introduced in Java 5). See Chapter 11 for more details.
   * */
  
}
