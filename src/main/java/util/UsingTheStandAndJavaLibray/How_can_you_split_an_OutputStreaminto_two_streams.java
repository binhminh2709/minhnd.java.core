package util.UsingTheStandAndJavaLibray;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.commons.io.output.TeeOutputStream;
import org.junit.Test;

public class How_can_you_split_an_OutputStreaminto_two_streams {
  
  /**
   * Similar to the tee command in UNIX, Apache Commons provides a TeeOutputStream;
   * its constructor takes two OutputStream instances, and writes to both.
   * This can be useful for auditing output from an application, such as logging responses
   * */
  
  //listing 18-4: Splitting an OutputStream
  @Test
  public void outputStreamSplit() throws IOException {
    
    final String data = "A string to be streamed";
    final InputStream is = IOUtils.toInputStream(data);
    
    final File tempFile = File.createTempFile("example", "txt");
    
    tempFile.deleteOnExit();//delete khi exit,(java virtual machine)
    System.out.println("exists ? " + tempFile.exists());
    
    //write
    final OutputStream os1 = new FileOutputStream(tempFile);
    final OutputStream os2 = new ByteArrayOutputStream();
    
    final OutputStream tee = new TeeOutputStream(os1, os2);
    
    //copy data from is to tee
    IOUtils.copy(is, tee);
    
    final FileInputStream fis = new FileInputStream(tempFile);
    
    final String osContents_1 = IOUtils.toString(fis);
    final String osContents_2 = os2.toString();
    
    System.out.println(data);
    System.out.println(osContents_1);
    System.out.println(osContents_2);
    
    assertEquals(data, osContents_1);
    assertEquals(data, osContents_2);
  }
  /**
   * writes to only one location, but the TeeOutputStream takes care of writing the data to both streams.
   * 
   * This code uses the Apache Commons IO extensively.
   * As well as the TeeOutputStream class under test,
   * the test text is turned(quay, lộn lại) into an InputStream using IOUtils.toInputStream;
   * the data is copied between streams using the previously seen copy method;
   * and the FileInputStream is consumed with IOUtils.toString.
   * A useful exercise would be to rewrite this test using only the standard Java libraries,
   * and see just how much extra code you need to write
   * */
  
}
