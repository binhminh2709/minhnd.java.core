package commons;

import java.util.LinkedList;
import java.util.List;

public class Mapper<A, B> {
  
  public List<B> apply(A a) {
    List<B> resource = null;
    if (resource == null) {
      resource = new LinkedList<>();
    }
    return resource;
  }
}
