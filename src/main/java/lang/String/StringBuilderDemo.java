package lang.String;

import org.junit.Test;

public class StringBuilderDemo {
  
  private StringBuilder resources;
  
  public StringBuilder getResources() {
    return resources;
  }
  
  public void setResources(StringBuilder resources) {
    this.resources = resources;
  }
  
  @Test
  public void testThreadSafe() {
    resources = new StringBuilder();
    Runnable one = new ThreadBuilderOne(resources);
    Thread tOne = new Thread(one);
    
    Runnable two = new ThreadBuilderTwo(resources);
    Thread tTwo = new Thread(two);
    
    tOne.start();
    tTwo.start();
    while (true) {
    }
  }
}
