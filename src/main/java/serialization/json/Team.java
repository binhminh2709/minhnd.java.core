package serialization.json;

import java.util.List;

public class Team {
  
  public Team() {
  }
  
  private String name;
  private String dateFounded;
  private List<Player> players;
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getDateFounded() {
    return dateFounded;
  }
  
  public void setDateFounded(String dateFounded) {
    this.dateFounded = dateFounded;
  }
  
  public List<Player> getPlayers() {
    return players;
  }
  
  public void setPlayers(List<Player> players) {
    this.players = players;
  }
  
  public class Player {
    
    private String name;
    private String position;
    
    public String getName() {
      return name;
    }
    
    public void setName(String name) {
      this.name = name;
    }
    
    public String getPosition() {
      return position;
    }
    
    public void setPosition(String position) {
      this.position = position;
    }
  }
  
}
