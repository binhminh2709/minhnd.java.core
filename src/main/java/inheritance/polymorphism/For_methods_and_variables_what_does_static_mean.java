package inheritance.polymorphism;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class For_methods_and_variables_what_does_static_mean {
  
  public static int EXAMPLE_VALUE = 6;
  
  @Test
  public void staticVariableAccess() {
    assertEquals(For_methods_and_variables_what_does_static_mean.EXAMPLE_VALUE, 6);
    
    For_methods_and_variables_what_does_static_mean c1 = new For_methods_and_variables_what_does_static_mean();
    For_methods_and_variables_what_does_static_mean c2 = new For_methods_and_variables_what_does_static_mean();
    
    c1.EXAMPLE_VALUE = 22; //permitted (dc cho phep), but not recommended
    For_methods_and_variables_what_does_static_mean.EXAMPLE_VALUE = 22; //recommended
    assertEquals(For_methods_and_variables_what_does_static_mean.EXAMPLE_VALUE, 22);
    
    assertEquals(c2.EXAMPLE_VALUE, 22);
  }
}
