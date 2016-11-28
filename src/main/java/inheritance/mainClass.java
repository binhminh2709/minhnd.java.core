package inheritance;

public class mainClass {
  
  /**
   * @param args
   */
  public static void main(String[] args) {
    IAnimal animal = new Cat();
    if (animal instanceof ICat) {
      ICat cat = (ICat) animal;
      System.out.println(cat.getCatName());
    }
  }
}
