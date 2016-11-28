package util.Calendar;

import java.util.Calendar;
import java.util.Date;

/**
 * @author BinhMinh
 *
 */
public class CalendarBasic {
  
  /**
   * @param args
   */
  public static void main(String[] args) {
    System.out.println("minhnd");
    Calendar calendar = Calendar.getInstance();
    calendar.set(2012, 11, 31);
    System.out.println(calendar.get(Calendar.WEEK_OF_YEAR));
    
    Date dateStart = new Date();
    Calendar cal = Calendar.getInstance();
    cal.setTime(dateStart);
    int month = cal.get(Calendar.MONTH);
    int year = cal.get(Calendar.YEAR);
    
    System.out.println("================ " + month + "/" + year + " ================== " + cal.getTime());
    
  }
  
}
