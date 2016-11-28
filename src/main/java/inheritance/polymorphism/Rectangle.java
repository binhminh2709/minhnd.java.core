package inheritance.polymorphism;

public class Rectangle {
  
  //Creating shapes using inheritance
  
  /**
   * From Listing 8-9, the Square class inherits from Rectangle(you can say a square is-arectangle). 
   * For the Square definition, the specific variables storing the length of the sides have been reused, and 
   * the Square type is enforcing that the width and height are the same
   * */
  private final int width;
  private final int height;
  
  public Rectangle(final int width, final int height) {
    this.width = width;
    this.height = height;
  }
  
  public int area() {
    return width * height;
  }
}
