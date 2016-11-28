package lang.String;

public class ThreadBufferOne implements Runnable {
  
  private StringBufferDemo demo;
  
  public ThreadBufferOne(StringBuffer builder) {
    if (demo == null) {
      demo = new StringBufferDemo();
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
