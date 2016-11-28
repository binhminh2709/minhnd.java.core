package util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.commons.collections.ListUtils;
import org.junit.Test;

public class CollectionsUtils {
  
  @Test
  public void testJoinLists() {
    List<String> listA = new ArrayList<String>();
    listA.add("A");
    
    List<String> listB = new ArrayList<String>();
    listB.add("B");
    
    List<String> listFinal = ListUtils.union(listA, listB);
    
    Collections.copy(listA, listB);
    
    System.out.println("listA : " + listA);
    System.out.println("listB : " + listB);
    System.out.println("listFinal : " + listFinal);
  }
  
  public void testCountDuplicatedList() {
    List<String> list = new ArrayList<String>();
    list.add("a");
    list.add("b");
    list.add("c");
    list.add("d");
    list.add("b");
    list.add("c");
    list.add("a");
    list.add("a");
    list.add("a");
    
    System.out.println("\nExample 1 - Count 'a' with frequency");
    System.out.println("a : " + Collections.frequency(list, "a"));
    
    System.out.println("\nExample 2 - Count all with frequency");
    Set<String> uniqueSet = new HashSet<String>(list);
    for (String temp : uniqueSet) {
      System.out.println(temp + ": " + Collections.frequency(list, temp));
    }
    
    System.out.println("\nExample 3 - Count all with Map");
    Map<String, Object> map = new HashMap<String, Object>();
    
    for (String temp : list) {
      Integer count = (Integer) map.get(temp);
      map.put(temp, (count == null) ? 1 : count + 1);
    }
    printMapString(map);
    
    System.out.println("\nSorted Map");
    Map<String, Object> treeMap = new TreeMap<String, Object>(map);
    printMapString(treeMap);
  }
  
  public void testSortMapOnKeyString() {
    Map<String, Object> unsortMap = new HashMap<String, Object>();
    unsortMap.put("Z", "z");
    unsortMap.put("B", "b");
    unsortMap.put("A", "a");
    unsortMap.put("C", "c");
    unsortMap.put("D", "d");
    unsortMap.put("E", "e");
    unsortMap.put("Y", "y");
    unsortMap.put("N", "n");
    unsortMap.put("J", "j");
    unsortMap.put("M", "m");
    unsortMap.put("F", "f");
    
    System.out.println("Unsort Map......");
    printMapString(unsortMap);
    
    System.out.println("\nSorted Map......");
    Map<String, Object> treeMap = new TreeMap<String, Object>(unsortMap);
    printMapString(treeMap);
  }
  
  public void testSortMapOnKeyInteger() {
    Map<Integer, Object> unsortMap = new HashMap<Integer, Object>();
    unsortMap.put(10, "z");
    unsortMap.put(5, "b");
    unsortMap.put(6, "a");
    unsortMap.put(20, "c");
    unsortMap.put(1, "d");
    unsortMap.put(7, "e");
    unsortMap.put(8, "y");
    unsortMap.put(99, "n");
    unsortMap.put(50, "j");
    unsortMap.put(2, "m");
    unsortMap.put(9, "f");
    
    System.out.println("Unsort Map......");
    printMapInteger(unsortMap);
    
    System.out.println("\nSorted Map......");
    Map<Integer, Object> treeMap = new TreeMap<Integer, Object>(new Comparator<Integer>() {
      
      @Override
      public int compare(Integer o1, Integer o2) {
        return o2.compareTo(o1);
      }
      
    });
    treeMap.putAll(unsortMap);
    
    printMapInteger(treeMap);
  }
  
  public void testSortMapOnValueInteger() {
    Map<String, Object> unsortMap = new HashMap<String, Object>();
    unsortMap.put("z", 10);
    unsortMap.put("b", 5);
    unsortMap.put("a", 6);
    unsortMap.put("c", 20);
    unsortMap.put("d", 1);
    unsortMap.put("e", 7);
    unsortMap.put("y", 8);
    unsortMap.put("n", 99);
    unsortMap.put("j", 50);
    unsortMap.put("m", 2);
    unsortMap.put("f", 9);
    
    System.out.println("Unsort Map......");
    printMapString(unsortMap);
    
    System.out.println("\nSorted Map......");
    Map<String, Object> sortedMap = sortByComparator(unsortMap);
    printMapString(sortedMap);
  }
  
  private Map<String, Object> sortByComparator(Map<String, Object> unsortMap) {
    // Convert Map to List
    List<Map.Entry<String, Object>> list = new LinkedList<Map.Entry<String, Object>>(unsortMap.entrySet());
    
    // Sort list with comparator, to compare the Map values
    Collections.sort(list, new Comparator<Map.Entry<String, Object>>() {
      
      public int compare(Map.Entry<String, Object> o1, Map.Entry<String, Object> o2) {
        return ((String) o1.getValue()).compareTo((String) o2.getValue());
      }
    });
    
    // Convert sorted map back to a Map
    Map<String, Object> sortedMap = new LinkedHashMap<String, Object>();
    for (Iterator<Map.Entry<String, Object>> it = list.iterator(); it.hasNext();) {
      Map.Entry<String, Object> entry = it.next();
      sortedMap.put(entry.getKey(), entry.getValue());
    }
    return sortedMap;
  }
  
  public static void printMapInteger(Map<Integer, Object> map) {
    for (Map.Entry<Integer, Object> entry : map.entrySet()) {
      System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
    }
  }
  
  public static void printMapString(Map<String, Object> map) {
    
    for (Map.Entry<String, Object> entry : map.entrySet()) {
      System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
    }
    
  }
  
  /**
   * TreeMap is unable to sort the Map values, instead, we should use Comparator.
   * The overall idea is, converts the Map into a List, sorts the List by Comparator and
   * put the sorted list back to a Map.
   * 
   * Map ---> List ---> Sort --> SortedList ---> Map
   * */
  
  public static List<?> reverse(List<?> list) {
    return rev(list);
  }
  
  private static <T> List<T> rev(List<T> list) {
    List<T> tmp = new ArrayList<T>(list);
    for (int i = 0; i < list.size(); i++) {
      list.set(i, tmp.get(list.size() - i - 1));
    }
    return list;
  }
}
