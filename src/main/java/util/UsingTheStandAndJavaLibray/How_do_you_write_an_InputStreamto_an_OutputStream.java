package util.UsingTheStandAndJavaLibray;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.junit.Test;

public class How_do_you_write_an_InputStreamto_an_OutputStream {
  
  /**
   * The Apache Commons IO library has several operations for streams that significantly reduce
   * the amount of boilerplate code you need to write
   * 
   * One common pattern is the need to connect an InputStreamto an OutputStream.
   * For example, you may want to write the contents of an incoming HTTP request straight to disk for
   * a file upload form or something similar
   * */
  
  //listing 18-2: Connecting an InputStream to an OutputStream
  @Test
  public void connectStreams() throws IOException {
    
    final String exampleText = "Text to be streamed";
    
    final InputStream inputStream = new ByteArrayInputStream(exampleText.getBytes());
    
    final OutputStream outputStream = new ByteArrayOutputStream();
    
    IOUtils.copy(inputStream, outputStream);
    
    final String streamContents = outputStream.toString();
    
    //so sánh giá trị
    assertEquals(exampleText, streamContents);
    
    //so sánh hai đối tượng
    assertNotSame(exampleText, streamContents);
  }
  
  //IOUtilsprovides a way to consume an InputStream to convert it to a String
  //listing 18-3: From an InputStream to a String
  @Test
  public void outputStreamToString() throws IOException {
    
    String exampleText = "An example String";
    final InputStream inputStream = new ByteArrayInputStream(exampleText.getBytes());
    final String consumedString = IOUtils.toString(inputStream);
    assertEquals(exampleText, consumedString);
    assertNotSame(exampleText, consumedString);
  }
  
  //Again, the toStringmethod is heavily overloaded, and can convert Readers, too.
}
