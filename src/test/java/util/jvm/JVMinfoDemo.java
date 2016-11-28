package util.jvm;

import java.util.ArrayList;

import org.junit.Test;

public class JVMinfoDemo {
  
  @Test
  public void testMemory() {
    JVMInfo infor = new JVMInfo();
    ArrayList<GarbageCollectorInfo> garbageCollectorInfo = infor.getGarbageCollectorInfo();
    for (GarbageCollectorInfo g : garbageCollectorInfo) {
      System.out.println(g.getName());
    }
  }
}
