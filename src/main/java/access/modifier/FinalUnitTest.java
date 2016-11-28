package access.modifier;

import org.junit.Test;

public class FinalUnitTest {
  
  @Test
  public void testFinal() {
    final int i = 9;
    Student s = new Student(2);
    System.out.println(s.getId());
  }
  
  private class Student {
    
    private final int id;
    
    public Student(final int id) {
      this.id = id;
    }
    
    public int getId() {
      return id;
    }
    
    //khai báo thuộc tính final, thì thay đổi giá trị của phương thức setId,
    //khởi tạo giá trị thông qua hàm contructor với đối số truyền vào
    public void setId(final int id) {
      //Error: this.id = id;
    }
  }
}
