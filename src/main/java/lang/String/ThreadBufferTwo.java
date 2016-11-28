package lang.String;

public class ThreadBufferTwo implements Runnable {
  
  private StringBufferDemo demo;
  
  public ThreadBufferTwo(StringBuffer builder) {
    if (demo == null) {
      demo = new StringBufferDemo();
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
