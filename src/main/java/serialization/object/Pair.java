package serialization.object;

import java.io.Serializable;

public class Pair implements Serializable {
  
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
  private final int number;
  private final String name;
  
  public Pair(int number, String name) {
    this.number = number;
    this.name = name;
  }
  
  public int getNumber() {
    return number;
  }
  
  public String getName() {
    return name;
  }
}
