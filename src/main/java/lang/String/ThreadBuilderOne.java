package lang.String;

public class ThreadBuilderOne implements Runnable {
  
  private StringBuilderDemo demo;
  
  public ThreadBuilderOne(StringBuilder builder) {
    if (demo == null) {
      demo = new StringBuilderDemo();
    }
    this.demo.setResources(builder);
  }
  
  @Override
  public void run() {
    System.out.println("ThreadOne");
    for (int i = 1; i < 20; i++) {
      demo.getResources().append("1-" + i + "\n");
    }
    System.out.println(demo.getResources().toString());
  }
  
}
