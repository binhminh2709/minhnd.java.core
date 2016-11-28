package commons;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class ColloectionUtils {
  
  public static <A, B> List<B> map(List<A> source, Mapper<A, B> mapper) {
    List<B> resource = new LinkedList<>();
    for (A a : source) {
      resource.addAll(mapper.apply(a));
    }
    return resource;
  }
  
  public static <A, B> List<B> oneToManyMap(List<A> source, Mapper<A, List<B>> mapper) {
    List<B> resource = new LinkedList<>();
    for (A a : source) {
      resource.addAll((Collection<? extends B>) mapper.apply(a));
    }
    return resource;
  }
  
  public static <A, V> V reduce(List<A> source, Operator<A, V> o) {
    for (A a : source) {
      o.partialCompute(a);
    }
    return o.result();
  }
  
  public static <A> List<A> filter(List<A> src, Predicate<A> p) {
    List<A> res = new LinkedList<>();
    for (A a : src) {
      if (p.check(a)) {
        res.add(a);
      }
    }
    return res;
  }
}
