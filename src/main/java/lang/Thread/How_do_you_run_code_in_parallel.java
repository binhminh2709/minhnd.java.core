package lang.Thread;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class How_do_you_run_code_in_parallel {
  
  public static String hold;
  
  /**
   * Listing 11-1:  Running two blocks of code simultaneously
   * */
  @Test
  public void testThread() throws InterruptedException {
    final Thread separateThread = new Thread(new ThreadPrinter());
    separateThread.start();
    for (int i = 0; i < 5; i++) {
      System.out.println("From the main thread: " + Thread.currentThread().getName());
      Thread.sleep(1000);
    }
  }
  
  public class ThreadPrinter implements Runnable {
    
    @Override
    public void run() {
      for (int i = 0; i < 5; i++) {
        System.out.println("From the new thread: " + Thread.currentThread().getName());
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }
  
  //@Test
  public void testStudent() throws ParseException {
    Date date = new Date();
    Calendar c = Calendar.getInstance();
    c.setTime(date);
    System.out.println(c.get(Calendar.MINUTE));
    System.out.println(c.get(Calendar.HOUR_OF_DAY));
    System.out.println(date);
    Student s = new Student();
    System.out.println(s.getName());
    
    SimpleDateFormat formatData = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    Date issueDate = new Date();
    String formattedDate = formatData.format(issueDate);
    Date dateWithTime = formatData.parse(formattedDate);
    System.out.println(dateWithTime);
  }
  
  //    @Test
  public void testStatic() {
    System.out.println(hold);
    StringBuilder sb = new StringBuilder();
    System.out.println(sb.toString().length());
    String sql = "123123";
    sql = sql + "bbb";
    System.out.println(sql);
    
    String minhnd = null;
    System.out.println(minhnd.length());
  }
  
  private class Student {
    
    private int id;
    private String name;
    
    public Student() {
    }
    
    public int getId() {
      return id;
    }
    
    public void setId(int id) {
      this.id = id;
    }
    
    public String getName() {
      return name;
    }
    
    public void setName(String name) {
      this.name = name;
    }
    
  }
}
