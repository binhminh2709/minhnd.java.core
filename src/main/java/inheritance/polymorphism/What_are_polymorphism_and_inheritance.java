package inheritance.polymorphism;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class What_are_polymorphism_and_inheritance {
  
  /**
   * Polymorphismand inheritanceare two of the core idioms of object-oriented development.
   * Polymorphism allows you to make a definition for a certain type of behavior, and have many different classes implement that behavior.
   * Inheritance allows you to derive the behavior and definition of 
   * a class from a superclass.
   * When defining a new class, it is possible to inherit definitions and state from a previously defined 
   * class, and then add new specific behavior, or override behavior for the new type
   * */
  
  /**
   * Considering the is-arelationship defined previously,
   * polymorphism can be thought of as using a subclass when a superclass has been asked for.
   * The behavior of the subclass will remain, but the user of the polymorphic type is none the wiser.
   * Listing 8-10 explores the use of the Squareand Rectangle classes with polymorphism.
   * As far as the ArrayListis concerned, it is only dealing with Rectangles; it does not understand, nor does it need to understand,
   * the difference between a Rectangle and a Square. Considering a Square is-a Rectangle, the code works fine.
   * Had any specific methods been defined on the Square class, these would not have been available to any users of the rectangles list,
   * because that method is not available on the Rectangle class.
   * */
  @Test
  public void polymorphicList() {
    List<Rectangle> rectangles = new ArrayList<>(3);
    rectangles.add(new Rectangle(5, 1));
    rectangles.add(new Rectangle(2, 10));
    rectangles.add(new Square(9));
    assertEquals(rectangles.get(0).area(), 5);
    assertEquals(rectangles.get(1).area(), 20);
    assertEquals(rectangles.get(2).area(), 81);
  }
}
