package resource;

/**
 * Created by binhminh on 11/28/2016.
 */
public class TryWithCustomResource {

    public static void main(String[] args) {
        try (CustomResource cr = new CustomResource()) {
            cr.accessResource();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
