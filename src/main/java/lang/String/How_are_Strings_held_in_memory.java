package lang.String;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class How_are_Strings_held_in_memory {
  
  /**
  		One of the great advantages to working with Java is that all of the library implementations are available to view
  and inspect.

  		Looking at the implementation of String in Java 1.7 in Listing 8-15 is not a great
  surprise (/sə'praiz/ danh tu- su ngac nhien). The value represented by the String is held as an array of chars

  	Listing 8-15: String definition
  	public final class String implements java.io.Serializable, Comparable<String>, CharSequence {
  		private final char[] value;
  	}

  		The String class is so core to the Java language, and is so widely used, that although it is simply a defined class
  in a Java library, the JVM and the compiler treats Strings in special ways under certain circumstances.
  String can almost be treated as a primitive type.

  		When creating a String literal, it is not necessary, or even advisable, to call new. At compile time, String
  literals—that is, any characters between a pair of quotations—will be created as a String.

  		The two Strings created in Listing 8-16 are the same, and can be treated as the same value in any running program.
  Looking at the construction of helloString2 first, when the compiler sees the sequence of characters ",H,e,...,!,", it
  knows that this is to create a String literal of the value enclosed in the quotes

  ==inspect (/in'spekt/ ngoai dong tu - kiem tra, quan sat).

   * Listing 8-16: String creation
   */
  
  @Test
  public void stringCreation() {
    String helloString1 = new String("Hello World!");
    String helloString2 = "Hello World!";
    assertEquals(helloString1, helloString2);
    
    assertTrue("12".equals(String.valueOf(12)));
  }
  
  @Test
  public void testString() {
    String sName = "";
    assertEquals(0, sName.trim().length());
  }
}
