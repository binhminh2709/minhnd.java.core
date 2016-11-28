package lang.String;

public class ThreadBuilderTwo implements Runnable {
  
  private StringBuilderDemo demo;
  
  public ThreadBuilderTwo(StringBuilder builder) {
    if (demo == null) {
      demo = new StringBuilderDemo();
    }
    this.demo.setResources(builder);
  }
  
  @Override
  public void run() {
    System.out.println("ThreadTwo");
    for (int i = 1; i < 20; i++) {
      demo.getResources().append("2-" + i + "\n");
    }
    System.out.println(demo.getResources().toString());
  }
}
