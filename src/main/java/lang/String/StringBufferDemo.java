package lang.String;

import org.junit.Test;

public class StringBufferDemo {
  
  private StringBuffer resources;
  
  public void setResources(StringBuffer buffer) {
    this.resources = buffer;
    
  }
  
  public StringBuffer getResources() {
    return resources;
  }
  
  @Test
  public void testThreadSafe() {
    resources = new StringBuffer();
    Runnable one = new ThreadBufferOne(resources);
    Thread tOne = new Thread(one);
    
    Runnable two = new ThreadBufferTwo(resources);
    Thread tTwo = new Thread(two);
    
    tOne.start();
    tTwo.start();
    while (true) {
    }
  }
}
