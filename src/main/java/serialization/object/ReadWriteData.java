package serialization.object;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import org.junit.Test;

public class ReadWriteData {
  
  /**
  The standard Java libraries provide a pair of classes for writing and reading Java objects:
  ObjectOutputStream and ObjectInputStream . These are part of the InputStream and OutputStream family of classes.

  For writing objects, ObjectOutputStream s are constructed using the Decorator Pattern,
  and require another OutputStream to physically write the serialized data.

  The ObjectOutputStream class has methods for all the primitive types, as well as a method for reference types,
  for writing these values to the stream. Shows the use of the ObjectOutputStream .
   * */
  
  @Test
  public void writeData() throws IOException {
    
    //abstract class
    OutputStream os = new OutputStream() {
      
      @Override
      public void write(int b) throws IOException {
      }
    };
    
    //path file in Linux OS
    final FileOutputStream fos = new FileOutputStream("/tmp/file");
    final ObjectOutputStream oos = new ObjectOutputStream(fos);
    
    oos.writeInt(101);
    oos.writeBoolean(false);
    oos.writeUTF("Writing a string");
    
    final Pair pair = new Pair(42, "Forty two");
    oos.writeObject(pair);
    
    oos.flush();
    oos.close();
    fos.close();
  }
  
  @Test
  public void readData() throws IOException, ClassNotFoundException {
    
    final FileInputStream fis = new FileInputStream("/tmp/file");
    final ObjectInputStream ois = new ObjectInputStream(fis);
    final int number = ois.readInt();
    final boolean bool = ois.readBoolean();
    final String string = ois.readUTF();
    
    final Pair pair = (Pair) ois.readObject();
    assertEquals(101, number);
    assertFalse(bool);
    assertEquals("Writing a string", string);
    assertEquals(42, pair.getNumber());
    assertEquals("Forty two", pair.getName());
    
    ois.close();
    fis.close();
  }
  
  /**
  It is important to read the data in the same order in which you wrote it! If you, for instance,
  try to call readObject when the next type in the stream is an int , you will get an exception.

  There are two important things of note for the small Pair class created for this example.
  Notice that the readData test can possibly throw a ClassNotFoundException .
  If you are reading this file in a different JVM than the one in which it was written,
  and the Pair class is not on the classpath, the JVM will not be able to construct the object.

  Also, the Pair class must implement the Serializable interface. This is a marker interface, which
  signals to the JVM that this class can be serialized.
  * */
}
