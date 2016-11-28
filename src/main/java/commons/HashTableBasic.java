/**
 * 
 */

package commons;

import java.util.Hashtable;

/**
 * @author BinhMinh
 *
 */
public class HashTableBasic {
  
  private static Hashtable<Integer, String> hash;
  
  /**
   * @param args
   */
  public static void main(String[] args) {
    Hashtable<Integer, String> hashtable = new Hashtable<>();
    hashtable.put(1, "khangpn");
    hashtable.put(2, "longnt");
    hashtable.put(3, "bachlx");
    //biến location
    int value = 9;
    
    calculateHash(hashtable, value);
    String name = hashtable.get(4);
    System.out.println(name + "--" + value);
  }
  
  //hàm means that the method is not attached to a specific instance
  private static void calculateHash(Hashtable<Integer, String> hashtable, int value) {
    hash = hashtable;
    hash.put(2, "minhnd");
    hash.put(4, "OK");
    value = 10;
    System.out.println("value-" + value);
  }
}
