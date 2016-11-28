package inheritance;

public class Animal implements IAnimal {
  
  private String name;
  
  @Override
  public void setAnimalName(String name) {
    this.name = name;
  }
  
  public String getName() {
    return name;
  }
  
}
