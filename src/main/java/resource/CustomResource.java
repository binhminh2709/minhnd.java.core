package resource;

/**
 * Created by binhminh on 11/28/2016.
 */
public class CustomResource implements AutoCloseable {

    public void accessResource() {
        System.out.println("Accessing the resource");
    }

    @Override
    public void close() throws Exception {
        System.out.println("CustomResource closed automatically");
    }
}
