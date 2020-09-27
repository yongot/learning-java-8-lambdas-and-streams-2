package lambdaVideos2.domain;

/**
 * @author yongot
 * @created 2020-09-27 : 1:16 PM
 */
public class Actor {

    private String name = null;

    public Actor(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Actor [name=" + name + "]";
    }

}
