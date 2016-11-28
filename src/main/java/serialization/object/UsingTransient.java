package serialization.object;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Assert;
import org.junit.Test;

public class UsingTransient {
  
  /**
  If you have a Serializable object, but have fields that you do not want to be serialized when writ-ing
  the data to a stream, you can apply the transient modifier to the field declaration. When a
  transient field is deserialized, that field will be null
  * */
  
  @Test
  public void transientField() throws IOException, ClassNotFoundException {
    
    final User user = new User("Noel", "secret321");
    final FileOutputStream fos = new FileOutputStream("/tmp/user");
    final ObjectOutputStream oos = new ObjectOutputStream(fos);
    
    oos.writeObject(user);
    oos.flush();
    oos.close();
    fos.close();
    
    final FileInputStream fis = new FileInputStream("/tmp/user");
    final ObjectInputStream ois = new ObjectInputStream(fis);
    
    final User deserialized = (User) ois.readObject();
    
    assertEquals("Noel", deserialized.getUsername());
    assertNotSame("secret321", deserialized.getPassword());
    assertNull(deserialized.getPassword());
    
    ois.close();
    fis.close();
  }
  
  /**
   * The main use cases for creating transient fields are when you are holding a private field as a cache,
  so you can simply regenerate the cache after deserializing, or when data can be reconstructed after it
  has been deserialized, such as a field created from other fields:
  private String firstName = "Bruce";
  private String lastName = "Springsteen";
  private String fullName = String.format("%s %s", firstName, lastName);
  As Listing 15-3 shows, you can hold secure or sensitive data in a transient field, and be confident
  that it will not be written to an ObjectOutputStream
   * */
}
