package resource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by binhminh on 11/28/2016.
 */
public class ResourceManagementInJava7 {

    public static void main(String[] args) {
        try (
                BufferedReader br1 = new BufferedReader(new FileReader("C:/temp/test1.txt"));
                BufferedReader br2 = new BufferedReader(new FileReader("C:/temp/test2.txt"));
                BufferedReader br3 = new BufferedReader(new FileReader("C:/temp/test3.txt"))
        ) {
            //Access resources
            br1.read();
            br2.read();
            br3.read();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
