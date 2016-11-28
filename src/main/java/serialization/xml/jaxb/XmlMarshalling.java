package serialization.xml.jaxb;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.junit.Test;

import serialization.xml.toplevelJaxb.ObjectFactory;
import serialization.xml.toplevelJaxb.Player;
import serialization.xml.toplevelJaxb.Players;
import serialization.xml.toplevelJaxb.Team;

public class XmlMarshalling {
  
  public static String PATH = "vn.com.minhnd.serialization.generated2";
  
  @Test
  public void readXml() throws JAXBException {
    
    JAXBContext context = JAXBContext.newInstance(PATH);
    
    Unmarshaller unmarshaller = context.createUnmarshaller();
    
    //Path = /src/main/resources + /xsd/teamSample.xml
    InputStream iStream = getClass().getResourceAsStream("/xsd/teamSample.xml");
    System.out.println(iStream);
    //		if (iStream != null) {
    Team team = ((Team) unmarshaller.unmarshal(iStream));
    System.out.println(team.getName());
    List<Player> players = team.getPlayers().getPlayer();
    for (Player player : players) {
      System.out.println(player.getName() + " " + player.getPosition());
    }
    assertEquals(2, team.getPlayers().getPlayer().size());
    //		}
  }
  
  @Test
  public void writeXml() throws JAXBException, FileNotFoundException {
    
    ObjectFactory factory = new ObjectFactory();
    
    Team team = factory.createTeam();
    
    Players players = factory.createPlayers();
    Player player = factory.createPlayer();
    
    player.setName("Simon Smith");
    player.setPosition("Substitute");
    players.getPlayer().add(player);
    
    team.setName("Megastars");
    team.setPlayers(players);
    
    JAXBContext context = JAXBContext.newInstance(PATH);
    
    Marshaller marshaller = context.createMarshaller();
    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    
    //Path Lunix OS
    marshaller.marshal(team, new FileOutputStream("/tmp/team.xml"));
  }
  
}
