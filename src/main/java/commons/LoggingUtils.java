package commons;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class LoggingUtils {
  
  /**
  http://o7planning.org/web/fe/default/vi/document/10119/huong-dan-su-dung-commons-logging
  sử dụng một trong 3 thư viện Logger sau:
  Log4J Logger
  Jdk14 Logger
  Simple Logger

  Commons Logging là một thư viện cho phép bạn làm việc với một trong 3 bộ thư viện trên
  một cách dễ dàng hơn. Như vậy để viết một chương trình Log, một mình nó không thể là một
  Logger. Một cách tương tự bạn làm việc với java.io để sử lý vào ra dữ liệu, Commons IO
  là bộ thư viện viết dựa trên java.io giúp bạn sử lý IO dễ dàng hơn, Common IO không
  thể thay thế java.io.
   * */
  
  private static final Log log = LogFactory.getLog(LoggingUtils.class);
  
  @Test
  public void testSimpleLog() {
    //public static void main(String[] args) {
    log.debug("Example debug message ..");
    log.info("Example info message ..");
    log.warn("Example warn message ..");
    log.error("Example error message ..");
    log.fatal("Example fatal message ..");
    
    try {
      raiseException();
    } catch (Exception e) {
      log.fatal("<Some Object>", e);
    }
  }
  
  private void raiseException() throws Exception {
    throw new Exception("Test Exception");
  }
}
