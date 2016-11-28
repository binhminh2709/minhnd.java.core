package util.UsingTheStandAndJavaLibray;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.junit.Test;

public class How_can_you_work_with_Java_is_Dateobject_when_using_Joda_Time {
  
  /**
   * When working with a third-party or legacy API,
   * you may be constricted to using Date objects as method parameters or return types.
   * Joda Time tries to make it as easy as possible to interact with Java’s Date and Calendar objects.
   * The DateTime class can take both Date and Calendar instances as constructor parameters,
   * and it has a toDate method that returns the DateTime representation as a Date.
   * Listing 18-15 shows taking a Calendar instance, converting it to a DateTime, modifying the time,
   * and converting it to a Java Date
   * */
  //listing 18-15: Converting to and from a DateTime object
  @Test
  public void withDateAndCalendar() {
    
    final Calendar nowCal = Calendar.getInstance();
    
    final DateTime nowDateTime = new DateTime(nowCal);
    final DateTime tenSecondsFuture = nowDateTime.plusSeconds(10);
    
    nowCal.add(Calendar.SECOND, 10);
    assertEquals(tenSecondsFuture.toDate(), nowCal.getTime());
  }
  
}
