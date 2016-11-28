package lang.number;

import org.junit.Test;

public class NumberInteger {
  
  //@Test
  public void testMaxMinInteger() {
    System.out.println(Integer.MAX_VALUE);
    System.out.println(new Integer(2147483647));
    System.out.println(Integer.MAX_VALUE + 1 == Integer.MIN_VALUE);
    if (Integer.MAX_VALUE + 1 == Integer.MIN_VALUE) {
      System.out.println("true");
    } else {
      System.out.println("false");
    }
    
    if (Integer.MIN_VALUE + 1 == Integer.MAX_VALUE) {
      System.out.println("true");
    } else {
      System.out.println("false");
    }
    
    final int mostNegative = Integer.MIN_VALUE;
    final int negated = Math.abs(mostNegative);
    if (negated > 0) {
      System.out.println("No positive equivalent of Integer.MIN_VALUE");
    } else {
      System.out.println(mostNegative);
      System.out.println(negated);
    }
    
  }
  
  @Test
  public void testConvert() {
    String number = "";
    try {
      int i = Integer.parseInt(number);
      System.out.println(i);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
