package util.jvm;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;

public class How_is_memory_allocated {
  
  private static Log log = LogFactory.getLog(How_is_memory_allocated.class);
  
  public String getStringByCode() {
    try {
      List<String> datas = new ArrayList<>();
      if (datas != null && datas.size() > 0) {
        return datas.get(0);
      }
    } catch (Exception e) {
      log.error(e);
    }
    return null;
  }
  
  @Test
  public void testException() {
    
    Assert.assertNull(getStringByCode());
  }
}
