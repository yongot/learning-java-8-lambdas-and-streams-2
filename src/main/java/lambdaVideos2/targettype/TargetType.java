package lambdaVideos2.targettype;

/**
 * @author yongot
 * @created 2020-09-27 : 4:09 PM
 */
public class TargetType {
    // i -> i*i
    public interface Email {
        String constructEmail(String name);
    }

    // refer to object type and deduce its target type
    Email email = (String name) -> name + "@xxx.com";

    public String getEmail(String name, Email email) {
        return null;
    }

    public static void main(String ... args) {

        new TargetType().getEmail("name", (String name) -> name+"xxx@.com");
    }
}
