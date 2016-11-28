package util.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayToArrayList {
  
  /**
  Sometimes we need to convert Array to ArrayList in java, here we will learn two different ways
  to achieve this. This situation can come when you are invoking some third party classes returning
  array and then you need to change them to list, or to add some more data to the list.

  - Arrays.asList(T… a): This is the simplest way to convert Array to ArrayList in java but this
  method returns the underlying representation of the array in the form of ArrayList. The returned
  ArrayList is fixed-sized and any attempt to modify that will result in
  UnsupportedOperationException at runtime. Also any change in the array will change the elements
  in ArrayList also.

  - Collections.addAll(ArrayList strList, T[] strArr): This is the best way to convert array to
  ArrayList because the array data is copied to the list and both are independent object. Once the
  array is copied, you can modify both the objects independently.

  * */
  
  /**
   * This class shows different methods to convert Array to ArrayList
   * 
   * @param args
   */
  public static void main(String[] args) {
    String[] strArr = { "1", "2", "3", "4" };
    List<String> strList = new ArrayList<String>();
    //return the list representation of array any change in array elements will change the arrayList elements also
    strList = Arrays.asList(strArr);
    System.out.println("Original ArrayList from Arrays.asList()");
    for (String str : strList) {
      System.out.print(" " + str);
    }
    //change the array element and see the effect is propogated to list also.
    strArr[0] = "5";
    System.out.println("\nChange in array effect on ArrayList");
    for (String str : strList) {
      System.out.print(" " + str);
    }
    //below code will throw java.lang.UnsupportedOperationException because
    //Arrays.asList() returns a fixed-size list backed by the specified array.
    //strList.add("5");
    
    strList = new ArrayList<String>();
    
    Collections.addAll(strList, strArr);
    //change both the array and arraylist and check if they are independent?
    strList.add("5");
    strArr[0] = "1";
    System.out.println("\nArray to ArrayList using Collections.addAll()");
    for (String str : strList) {
      System.out.print(" " + str);
    }
  }
}
