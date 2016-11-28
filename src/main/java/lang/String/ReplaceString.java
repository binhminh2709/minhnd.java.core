/**
 * 
 */

package lang.String;

import org.junit.Test;

/**
 * @author BinhMinh
 *
 */
public class ReplaceString {
  
  /**
   * @param args
   */
  @Test
  public void testReplaceWhitesapce() {
    String s = "20   0 0 0 0";
    if (s.length() != 0) {
      s = s.replaceAll("\\s+", "");
    }
    System.out.println(s);
  }
  
  /**
   * Those two replaceAll calls will always produce the same result, regardless of what x is.
   * However, it is important to note that the two regular expressions are not the same:
   * \\s - matches single whitespace character
   * \\s+ - matches sequence of one or more whitespace characters.
   * In this case, it makes no difference, since you are replacing everything with an empty string 
   * (although it would be better to use \\s+ from an efficiency point of view).
   * If you were replacing with a non-empty string, the two would behave differently.
   * */
  
  @Test
  public void testCompareTo() {
    String id = "id";
    String idCom = "id";
    System.out.println(id.compareTo(idCom));
  }
}
