/**
 * 
 */

package inheritance;

/**
 * @author BinhMinh
 *
 */

public class Cat extends Animal implements ICat {
  
  public Cat() {
    setAnimalName("Im a cat!");
  }
  
  @Override
  public String getCatName() {
    return getName();
  }
  
}
