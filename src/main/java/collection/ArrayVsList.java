package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by binhminh on 11/29/2016.
 */
public class ArrayVsList {

    public static void main(String[] args) {
        long start = System.nanoTime();
        Integer[] spam = new Integer[100000];
        for (int i = 0; i < 100000; i++) {
            spam[i] = i;
        }
        List<Integer> integers = Arrays.asList(spam);
        long end = System.nanoTime();
        System.out.println(end - start);

        long l = System.nanoTime();
        List<Long> list = new ArrayList<>();
        for (long i = 0; i < 100000; i++) {
            list.add(i);
        }
        System.out.println(System.nanoTime() - l);
    }
}
