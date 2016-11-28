package util.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InitializeAnArrayListInOneLine {
  
  public void testInitialize() {
    //normal way
    List<String> list = new ArrayList<String>();
    list.add("String A");
    list.add("String B");
    list.add("String C");
    
    System.out.println("List 1......");
    printList(list);
    
    //Anonymous inner class
    List<String> list2 = new ArrayList<String>() {
      
      {
        add("String A");
        add("String B");
        add("String C");
      }
    };
    
    System.out.println("List 2......");
    printList(list2);
    
    //one line
    List<String> list3 = new ArrayList<String>(Arrays.asList("String A", "String B", "String C"));
    System.out.println("List 3......");
    printList(list3);
  }
  
  private void printList(List<String> list) {
    for (String temp : list) {
      System.out.println(temp);
    }
  }
}
