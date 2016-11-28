package lang.number;

import org.junit.Test;

public class PrimitiveTypes {
  
  double a = 68.86D;
  long b = 68L;
  float c = 68F;
  
  /**
   * When you are defining a variable for ints and longs, the compiler needs to be able to differentiate between the two types.
   * You do this by using the suffix L after long values. The absence of L implies an int.
   * The L can be either in upper- or lower case, but it is recommended to always use upper case. 
   * This way, anyone reading your code can easily tell the difference between the Land the number 1! 
   * This is also used with floats and doubles: floats can be defined with F, and doubles with D.
   * The suffix is optional for doubles; its omission implies a double
   * 
   *     Primitive     size(bits)
   *     boolean       1
   *     short         16
   *     int           32
   *     long          64
   *     float         32
   *     double        64
   *     char          16
   *     
   *     
   * Be aware that char is unsigned. That is, the range of values a char can take is from 0to 65,535,
   * because chars represent Unicode values
   * 
   * If a primitive type is not set to a value when a variable is defined, it takes a default value.
   * For boolean values, this is false. For the others, this is a representation of zero, such as 0 for ints or 0.0f for floats
   * 
   * The compiler can promote values to their appropriate type when necessary, as shown in Listing 8-1
   * */
  
  @Test
  public void primitiveTypeTest() {
    
    //Implicit upcasting to wider types
    int value = Integer.MAX_VALUE;
    long biggerValue = value + 1;
    
    //Explicit downcasting to narrower types
    long veryLargeNumber = Long.MAX_VALUE;
    int fromLargeNumber = (int) veryLargeNumber;
  }
}
