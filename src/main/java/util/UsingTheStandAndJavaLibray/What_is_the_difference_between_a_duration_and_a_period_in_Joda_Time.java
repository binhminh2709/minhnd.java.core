package util.UsingTheStandAndJavaLibray;

import static org.junit.Assert.assertEquals;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.Period;
import org.junit.Test;

public class What_is_the_difference_between_a_duration_and_a_period_in_Joda_Time {
  
  /**
   * The representation of amounts of time is a feature that is not part of Java’s Date and Calendar classes,
   * and it is the simplicity of working with these in Joda Time that makes the library so popular
   * 
   * A DateTime instance represents an instant; that is, a measurement of time exact to the millisecond.
   * Joda Time also provides APIs for working with an amount of time between two instants.
   * 
   * A duration is an amount of time in milliseconds.
   * If you add a duration to a DateTime, you will get a new DateTime instance.
   * */
  
  //listing 18-16: Using a duration
  @Test
  public void duration() {
    final DateTime dateTime1 = new DateTime(2010, 1, 1, 0, 0, 0, 0);
    
    final DateTime dateTime2 = new DateTime(2010, 2, 1, 0, 0, 0, 0);
    System.out.println("getMillis:" + dateTime2.getMillis() + " getDayOfMonth:" + dateTime2.getDayOfMonth() + " getMonthOfYear:"
        + dateTime2.getMonthOfYear());
    
    //duration-Thoi gian, thoi' han
    final Duration duration = new Duration(dateTime1, dateTime2);
    System.out.println(duration);
    StringBuilder builder = new StringBuilder();
    builder.append("toStandardDays:");
    builder.append(duration.toStandardDays());
    builder.append(" toStandardHours:");
    builder.append(duration.toStandardHours());
    builder.append(" toStandardMinutes:");
    builder.append(duration.toStandardMinutes());
    builder.append(" toStandardSeconds:");
    builder.append(duration.toStandardSeconds());
    System.out.println(builder.toString());
    
    StringBuilder stringBuilder = new StringBuilder();
    System.out.println("milliseconds in 31 days: " + 31 * 24 * 60 * 60 * 1000);
    stringBuilder.append("getMillis:");
    stringBuilder.append(duration.getMillis());
    stringBuilder.append(" getStandardDays:");
    stringBuilder.append(duration.getStandardDays());
    stringBuilder.append(" getStandardHours:");
    stringBuilder.append(duration.getStandardHours());
    stringBuilder.append(" getStandardMinutes:");
    stringBuilder.append(duration.getStandardMinutes());
    stringBuilder.append(" getStandardSeconds:");
    stringBuilder.append(duration.getStandardSeconds());
    System.out.println((stringBuilder.toString()));
    
    final DateTime dateTime3 = new DateTime(2010, 9, 1, 0, 0, 0, 0);
    
    final DateTime dateTime4 = dateTime3.withDurationAdded(duration, 1);
    
    assertEquals(2, dateTime4.getDayOfMonth());
    assertEquals(10, dateTime4.getMonthOfYear());
  }
  
  /**
   * The Duration instance is calculated as the difference between two DateTime instances;
   * in this case midnight January 1, 2010, and midnight February 1, 2010.
   * Internally(no^i bo^.), this is represented as a number of milliseconds,
   * and in this case it will be equal to the number of milliseconds in 31 days.
   * 
   * This duration is then added, once (mo^t la^n), to another DateTime,
   * representing midnight on September 1, 2010, and a new DateTime is returned.
   * 
   * Because September has 30 days, the DateTime returned represents October 2, 2010
   * 
   * With the irregularity(ba^t thu'o'ng) of calendars—differing lengths of months
   * and even years—you may still want to perform operations such as “the same day of the month, in two months’ time,”
   * or “the same date next year.” You cannot simply add 60 or so days for two months and get the same date next year.
   * You need to check if there is a February 29 between now and then, and add one if so.
   * 
   * The Period class removes all of these headaches for you. A period is a quantity of time;
   * it is relative to the starting date, and can only be resolved(kie^u?) once the start date is known.
   * */
  //listing 18-17: Using a period
  @Test
  public void period() {
    
    final DateTime dateTime1 = new DateTime(2011, 2, 1, 0, 0, 0, 0);
    final DateTime dateTime2 = new DateTime(2011, 3, 1, 0, 0, 0, 0);
    
    final Period period = new Period(dateTime1, dateTime2);
    
    final DateTime dateTime3 = new DateTime(2012, 2, 1, 0, 0, 0, 0);
    final DateTime dateTime4 = dateTime3.withPeriodAdded(period, 1);
    
    assertEquals(1, dateTime4.getDayOfMonth());
    assertEquals(3, dateTime4.getMonthOfYear());
  }
  /**
   * The Period in Listing 18-17 was calculated as the interval between February 1, 2011 and March 1, 2011.
   * The Period was then applied to February 1, 2012, giving a new DateTime for March 1, 2012.
   * A Period inspects the difference in each field between two DateTime instances,
   * that is, the difference in months, days, hours, and so on.
   * Although the number of days between the first two dates was 28 days, it was represented as a period of “one month.”
   * When this period is applied to a leap year, that extra day is still part of that “one month,” 
   * so March 1, 2012 was returned. Had this interval been a Duration rather than a Period ,
   * the DateTime instance returned would have been the last day of February.
   * */
}
