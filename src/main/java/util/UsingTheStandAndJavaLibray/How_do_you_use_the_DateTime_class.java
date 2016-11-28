package util.UsingTheStandAndJavaLibray;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import org.joda.time.DateTime;
import org.junit.Test;

public class How_do_you_use_the_DateTime_class {
  
  /**
   * Joda Time is intended (du' dinh) as a replacement (su thay the) for Java’s Date and Calendar classes.
   * It provides much more functionality, and is generally considered easier to use.
   * Java 8 will provide a new and improved date and time API based on Joda Time
   * 
   * The Calendar class has traditionally been used for working with dates in Java.
   * It has a strange access pattern, and can be slightly uncomfortable for newcomers to use.
   * Listing 18-13 shows a simple operation that subtracts a month from the current date using the Calendar class
   * */
  //listing 18-13: Using Java’s Calendar class
  @Test
  public void javaCalendar() {
    
    final Calendar now = Calendar.getInstance();
    final Calendar lastMonth = Calendar.getInstance();
    
    lastMonth.add(Calendar.MONTH, -1);
    
    assertTrue(lastMonth.before(now));
  }
  
  /**
   * The add method takes two integer parameters, and unless you are familiar with the API,
   * you may not realize that the first parameter is intended to be a constant,
   * one of a many special constant integers on the Calendar class.
   * 
   * This is partially a hangover from before Java 5, before it was possible to have enumerated types.
   * 
   * The DateTimeclass replaces Java’s Calendar class,
   * and provides many clearer methods for retrieving and modifying a representation of time and date.
   * 
   * */
  //Listing 18-14 shows how to use DateTime
  @Test
  public void dateTime() {
    
    final DateTime now = new DateTime();
    
    // current time - 7 day = lastWeek
    final DateTime lastWeek = new DateTime().minusDays(7);
    
    System.out.println("now.getDayOfWeek():" + now.getDayOfWeek());
    System.out.println("lastWeek.getDayOfWeek():" + lastWeek.getDayOfWeek());
    
    assertEquals(now.getDayOfWeek(), lastWeek.getDayOfWeek());
  }
  
  /**
   * The DateTime class has many methods for getting the appropriate information about a date,
   * such as the day of the month, the week of the year, and even to check for a leap year.
   * 
   * DateTime objects are immutable, so any “mutating - do^t bie^n” operation, such as minusDaysin Listing 18-14,
   * actually returns a new DateTime instance.
   * Similar to String, if you do call any (mutating- dot bien) methods remember to assign the result to a variable!
   * */
  
  public void testDatepattern() {
    // © 2013 Basil Bourque. This source code may be used freely forever by anyone taking full responsibility for doing so.
    
    String date_s = "2011-01-18 00:00:00.0";
    
    org.joda.time.format.DateTimeFormatter formatter = org.joda.time.format.DateTimeFormat
        .forPattern("yyyy-MM-dd' 'HH:mm:ss.SSS");
    // By the way, if your date-time string conformed strictly to ISO 8601 including a 'T' rather than a SPACE ' ', you could
    // use a formatter built into Joda-Time rather than specify your own: ISODateTimeFormat.dateHourMinuteSecondFraction().
    // Like this:
    //org.joda.time.DateTime dateTimeInUTC = org.joda.time.format.ISODateTimeFormat.dateHourMinuteSecondFraction().withZoneUTC().parseDateTime( date_s );
    
    // Assuming the date-time string was meant to be in UTC (no time zone offset).
    org.joda.time.DateTime dateTimeInUTC = formatter.withZoneUTC().parseDateTime(date_s);
    System.out.println("dateTimeInUTC: " + dateTimeInUTC);
    System.out.println("dateTimeInUTC (date only): " + org.joda.time.format.ISODateTimeFormat.date().print(dateTimeInUTC));
    System.out.println(""); // blank line.
    
    // Assuming the date-time string was meant to be in Kolkata time zone (formerly known as Calcutta). Offset is +5:30 from UTC (note the half-hour).
    org.joda.time.DateTimeZone kolkataTimeZone = org.joda.time.DateTimeZone.forID("Asia/Kolkata");
    org.joda.time.DateTime dateTimeInKolkata = formatter.withZone(kolkataTimeZone).parseDateTime(date_s);
    System.out.println("dateTimeInKolkata: " + dateTimeInKolkata);
    System.out
        .println("dateTimeInKolkata (date only): " + org.joda.time.format.ISODateTimeFormat.date().print(dateTimeInKolkata));
    // This date-time in Kolkata is a different point in the time line of the Universe than the dateTimeInUTC instance created above. The date is even different.
    System.out.println("dateTimeInKolkata adjusted to UTC: " + dateTimeInKolkata.toDateTime(org.joda.time.DateTimeZone.UTC));
  }
}
