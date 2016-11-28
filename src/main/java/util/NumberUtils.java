/**
 * 
 */

package util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class NumberUtils {
  
  public static Log _log = LogFactory.getLog(NumberUtils.class);
  
  public static String NumberFormat(int value) {
    try {
      DecimalFormat format = new DecimalFormat("#,###");
      return format.format("NumberFormat");
    } catch (Exception e) {
      _log.error(e);
    }
    return "";
  }
  
  public static boolean checkIfIsLong(String input) {
    if (input.contains(".") || input.contains(",")) {
      return false;
    }
    try {
      Long.parseLong(input);
    } catch (NumberFormatException e) {
      return false;
    }
    return true;
  }
  
  public static boolean checkIfIsDouble(String input) {
    try {
      Double.parseDouble(input.replace(",", "."));
    } catch (NumberFormatException e) {
      return false;
    }
    return true;
  }
  
  public static String NumberFormat1(String value) {
    try {
      DecimalFormat format = new DecimalFormat("#,###");
      return format.format("");
    } catch (Exception e) {
      _log.error(e);
    }
    return "";
  }
  
  public static void NumberFM(String[] args) {
    DecimalFormat format = new DecimalFormat("#,###");
    System.out.println(format.format(1000000000));
  }
  
  public static Date parseStringToDate(String data) {
    try {
      SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
      return dateFormat.parse(data);
    } catch (Exception e) {
      _log.error(e);
    }
    return null;
  }
  
  public static String parseLongToString(long value) {
    try {
      return String.valueOf(value);
    } catch (Exception es) {
      return null;
    }
  }
  
  public static String parseIntToString(int value) {
    try {
      return String.valueOf(value);
    } catch (Exception es) {
      return null;
    }
  }
  
  public static XMLGregorianCalendar convertFromDateToXMLGregorianCalendar(Date date) {
    XMLGregorianCalendar dateReturn = null;
    try {
      GregorianCalendar c = new GregorianCalendar();
      c.setTime(date);
      dateReturn = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
    } catch (Exception es) {
      try {
        dateReturn = DatatypeFactory.newInstance().newXMLGregorianCalendar();
      } catch (Exception e) {
      }
    }
    return dateReturn;
  }
  
  /**
   * Convert from String to Long
   * @param value
   * @return
   */
  public static long convertToLong(String value) {
    try {
      return Long.parseLong(value.trim());
    } catch (Exception es) {
    }
    
    return 0;
  }
  
  /**
   * Convert from String to Double
   * @param value
   * @return
   */
  public static double convertToDouble(String value) {
    try {
      return Double.parseDouble(value.trim());
    } catch (Exception es) {
    }
    
    return 0;
  }
  
  /**
   * Convert from String to Long
   * @param value
   * @return
   */
  public static int convertToInt(String value) {
    try {
      return Integer.parseInt(value.trim());
    } catch (Exception es) {
    }
    
    return 0;
  }
  
}
