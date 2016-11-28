package access.modifier;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class How_do_the_visibility_modifiers_work_for_objects {
  
  private class Complex {
    
    private final double real;
    private final double imaginary;
    
    public Complex(final double r, final double i) {
      this.real = r;
      this.imaginary = i;
    }
    
    public Complex add(final Complex other) {
      return new Complex(this.real + other.real, this.imaginary + other.imaginary);
    }
    
    // hashCode omitted for brevity
    @Override
    public boolean equals(Object o) {
      if (this == o)
        return true;
      if (o == null || getClass() != o.getClass())
        return false;
      Complex complex = (Complex) o;
      if (Double.compare(complex.imaginary, imaginary) != 0)
        return false;
      if (Double.compare(complex.real, real) != 0)
        return false;
      return true;
    }
  }
  
  @Test
  public void complexNumberAddition() {
    final Complex expected = new Complex(6, 2);
    final Complex a = new Complex(8, 0);
    final Complex b = new Complex(-2, 2);
    assertEquals(a.add(b), expected);
  }
}
