package serialization.json;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import util.json.JsonSerializerUtils;

public class JsonMarshalling {
  
  @Test
  public void readJson() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    String json = "/serialization.json/team.json";
    Team team = mapper.readValue(getClass().getResourceAsStream(json), Team.class);
    System.out.println(team.getPlayers().get(0).getName());
    assertEquals(2, team.getPlayers().size());
  }
  
  @Test
  public void writeJson() throws IOException {
    
    /*Player p1 = new Player();
    p1.setNamePlayer("Louise Mills");
    p1.setPosition("Coach");
    
    Player p2 = new Player();
    p2.setName("Liam Turner");
    p2.setPosition("Attack");
    
    Team team = new Team();
    team.setPlayers(Arrays.asList(p1, p2));*/
    
    final serialization.xml.jaxb.Team team = new serialization.xml.jaxb.Team();
    team.setName("Superstars");
    
    final serialization.xml.jaxb.Team.Players players = new serialization.xml.jaxb.Team.Players();
    
    final serialization.xml.jaxb.Team.Players.Player p1 = new serialization.xml.jaxb.Team.Players.Player();
    p1.setName("Lucy Jones");
    p1.setPosition("Striker");
    
    final serialization.xml.jaxb.Team.Players.Player p2 = new serialization.xml.jaxb.Team.Players.Player();
    p2.setName("Becky Simpson");
    p2.setPosition("Midfield");
    players.getPlayer().add(p1);
    players.getPlayer().add(p2);
    
    team.setPlayers(players);
    
    //ObjectMapper mapper = new ObjectMapper();
    //mapper.writeValue(new File("/tmp/newteam"), team);
    JsonSerializerUtils jsonSerializer = new JsonSerializerUtils();
    String jsonTeam = jsonSerializer.toString(team);
    System.out.println(jsonTeam);
    
  }
}
