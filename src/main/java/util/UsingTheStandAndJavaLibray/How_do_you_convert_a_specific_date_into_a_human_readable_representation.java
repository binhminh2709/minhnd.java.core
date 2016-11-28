package util.UsingTheStandAndJavaLibray;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;
import org.junit.Test;

public class How_do_you_convert_a_specific_date_into_a_human_readable_representation {
  
  /**
   * As part of the Java API, the SimpleDateFormatclass is commonly used to construct custom, human-readable dates.
   * You provide a template for the date, and when given a Date instance,
   * it returns a String representation of that date
   * */
  //listing 18-18: Using SimpleDateFormat
  @Test
  public void simpleDateFormat() {
    final Calendar cal = Calendar.getInstance();
    cal.set(Calendar.MONTH, Calendar.JULY);
    cal.set(Calendar.DAY_OF_MONTH, 17);
    
    final SimpleDateFormat formatter = new SimpleDateFormat("'The date is 'dd MMMM");
    assertEquals("The date is 17 July", formatter.format(cal.getTime()));
  }
  
  /**
   * The format string is hard to use, and can often lead to confusion:
   * 	- Lowercase m represents milliseconds.
   *  - uppercase M represents months, for instance.
   * Plaintext must be surrounded(bao quanh) by single quotes.
   * Any nontrivial case for using the SimpleDateFormat class is often accompanied
   * by some time with the Java API documentation and some fiddling to get the format exactly right.
   * Also, the SimpleDateFormat class is not thread-safe as the format String can change after the object has been created.
   * DateTimeFormatter is immutable, which implies thread safety, as once it has been created it can never be changed
  	 * */
  
  /**
   * The DateTimeFormattercan parse similar Strings that you would give to the SimpleDateFormat class,
   * but Joda Time also provides a builder class, giving clearer meaning to each element of the string you are building.
   * Listing 18-19 shows how to construct the same String as that in Example 
   * */
  //Listing 18-19:  Formatting dates with Joda Time
  @Test
  public void jodaFormat() {
    final DateTime dateTime = new DateTime().withMonthOfYear(11).withDayOfMonth(12);
    final DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendLiteral("The date is ").appendDayOfMonth(2)
        .appendLiteral(' ').appendMonthOfYearText().toFormatter();
    assertEquals("The date is 12 November", formatter.print(dateTime));
    
    //so 2 la tham so thu 2 cua Object DateTime
    DateTimeFormatter dayOfMonth = new DateTimeFormatterBuilder().appendLiteral("Current Date is ").appendDayOfMonth(2)
        .toFormatter();
    System.out.println(dayOfMonth.print(dateTime));
  }
}
