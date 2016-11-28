package inheritance;

import java.lang.reflect.Field;

import javax.swing.JTextArea;

public class Reflection {
  
  private int i = 1212;
  private JTextArea txtArea;
  
  public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
    Class cl = Reflection.class;
    Reflection reflection = new Reflection();
    Field[] fields = cl.getDeclaredFields();
    Field field = fields[1];
    field.setAccessible(true);
    Object i = field.get(reflection);
    System.out.println(field.getType().getClass().getInterfaces());
  }
  
}
