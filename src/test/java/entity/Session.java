package entity;

import java.io.Serializable;

public class Session implements Serializable {
  
  private String nameSession;
  
  public Session(String nameSession) {
    this.nameSession = nameSession;
  }
  
  public String getNameSession() {
    return nameSession;
  }
  
  public void setNameSession(String nameSession) {
    this.nameSession = nameSession;
  }
  
}
