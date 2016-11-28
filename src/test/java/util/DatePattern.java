package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

import com.google.common.base.Function;

import entity.Session;
import entity.WSStudent;

public class DatePattern {
  
  /**
  \\d is a digit
  {4} is the amount of digits (the regexp part right in front of it)
  / is just a slash
  : is just a colon
  \\s is any whitespace
  + is one or more of whitespace (the regexp part right in front of it)
   * */
  @Test
  public void testPattern() {
    String regex = "^(?ni:(?=\\d)"
        + "((?'year'((1[6-9])|([2-9]\\d))\\d\\d)"
        + "(?'sep'[/.-])"
        + "(?'month'0?[1-9]|1[012])"
        + "\\2(?'day'((?<!(\\2((0?[2469])|11)\\2))31)|(?<!\\2(0?2)\\2)(29|30)|((?<=((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|(16|[2468][048]|[3579][26])00)\\2\\3\\2)29)|((0?[1-9])|(1\\d)|(2[0-8])))"
        + "(?:(?=\\x20\\d)\\x20|$))?((?<time>((0?[1-9]|1[012])(:[0-5]\\d){0,2}(\\x20[AP]M))|([01]\\d|2[0-3])(:[0-5]\\d){1,2}))?)$";
    Pattern p = Pattern.compile(regex);
    // get a matcher object
    Matcher m = p.matcher("input");
    boolean matches = m.matches();
    System.out.println(matches);
    Function<Session, WSStudent> f = new Function<Session, WSStudent>() {
      
      @Override
      public WSStudent apply(Session arg0) {
        
        return null;
      }
    };
  }
}
