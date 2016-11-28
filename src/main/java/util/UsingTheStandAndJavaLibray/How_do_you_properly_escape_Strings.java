package util.UsingTheStandAndJavaLibray;

import static org.junit.Assert.assertEquals;

import org.apache.commons.lang.StringEscapeUtils;
import org.junit.Test;

public class How_do_you_properly_escape_Strings {
  
  /**
   * Làm thế nào để chốn thoát đúng Strings
   * 
   * The Commons Lang library complements the functionality found in the java.langpackage, 
   * including several libraries for manipulating Strings.
   * 
   * Many systems work over many platforms and interfaces. It is common to see a Java server that serves HTML pages
   * and receives input from HTML forms, or you can use a Java application to read
   * and write a comma-separated values file.
   * The StringEscapeUtilsclass provides the facility to represent a String in that environment
   * */
  
  /**
   * Listing 18-1: Escaping Strings with Apache Commons
   * */
  @Test
  public void escapeStrings() {
    final String exampleText = "Left & Right";
    final String escapedString = StringEscapeUtils.escapeHtml(exampleText);
    
    assertEquals("Left &amp; Right", escapedString);
    final String javaText = StringEscapeUtils.escapeJava("Left &amp; Right");
    System.out.println(javaText);
    
    final String sHtml = "<b>Nguyễn Đình Minh<b>";
    System.out.println(StringEscapeUtils.escapeHtml(sHtml));
    
    /**
     * The class can also escape Strings for JavaScript, XML, and Java itself.
     * This can be useful if you ever need to write Java source code programmatically
     * */
  }
}
