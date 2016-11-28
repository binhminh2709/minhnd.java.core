package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
  
  final static public int SECONDS_PER_DAY = 86400;
  
  final static public SimpleDateFormat COMPACT_DATE = new SimpleDateFormat("dd/MM/yyyy");
  final static public SimpleDateFormat COMPACT_DATE_TIME = new SimpleDateFormat("dd/MM/yyyy@HH:mm:ss");
  final static public SimpleDateFormat COMPACT_DATE_ID = new SimpleDateFormat("yyyyMMdd");
  final static public SimpleDateFormat COMPACT_DATE_TIME_ID = new SimpleDateFormat("yyyyMMddHHmmss");
  
  static public String asCompactDate(long time) {
    return COMPACT_DATE.format(new Date(time));
  }
  
  static public String asCompactDate(Date time) {
    return COMPACT_DATE.format(time);
  }
  
  static public String asCompactDateId(Date time) {
    return COMPACT_DATE_ID.format(time);
  }
  
  static public String asCompactDate(Calendar cal) {
    return COMPACT_DATE.format(cal.getTime());
  }
  
  static public String asCompactDateTime(long time) {
    return COMPACT_DATE_TIME.format(new Date(time));
  }
  
  static public String asCompactDateTIME(Date time) {
    return COMPACT_DATE_TIME.format(time);
  }
  
  static public Date parseCompactDate(String exp) throws ParseException {
    return COMPACT_DATE.parse(exp);
  }
  
  static public Date parseCompactDateTime(String exp) throws ParseException {
    return COMPACT_DATE_TIME.parse(exp);
  }
  
  static public Date parseCompactDateTimeId(String exp) throws ParseException {
    return COMPACT_DATE_TIME_ID.parse(exp);
  }
  
  static public String asCompactDateTimeId(long time) {
    return COMPACT_DATE_TIME_ID.format(new Date(time));
  }
  
  static public String asCompactDateTimeId(Date date) {
    return COMPACT_DATE_TIME_ID.format(date);
  }
  
  static public String currentTimePath(String basePath) {
    String backupTime = basePath + "/" + COMPACT_DATE_TIME_ID.format(new Date());
    return backupTime;
  }
  
  static public String currentDatePath(String basePath) {
    String backupTime = basePath + "/" + COMPACT_DATE_ID.format(new Date());
    return backupTime;
  }
  
  public static String dateToString(String format, Date date) { // lay ra ngay, thang, nam, gio, phu, giay hien tai
    String stringResult = "";
    SimpleDateFormat sdf = null;
    try {
      sdf = new SimpleDateFormat(format);
      stringResult = sdf.format(date);
    } catch (Exception e) {
      stringResult = "";
    }
    return stringResult;
  }
  
  public static Date stringToDate(String sDate, String format) {
    Date result = null;
    SimpleDateFormat sdf = null;
    try {
      sdf = new SimpleDateFormat(format);
      result = sdf.parse(sDate);
    } catch (Exception e) {
    }
    return result;
  }
  
  public static boolean isDate(String sDate, String format) {
    SimpleDateFormat sdf = null;
    try {
      sdf = new SimpleDateFormat(format);
      sdf.parse(sDate);
      return true;
    } catch (Exception e) {
      return false;
    }
  }
}
