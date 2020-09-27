package lambdaVideos2.methodrefs;

/**
 * @author yongot
 * @created 2020-09-27 : 4:51 PM
 */
public class ConstructorReferences {

    // ArrayList::new
    class Movie {
        // Constructor 1
        public Movie(int id) {

        }

        // Constructor 2
        public Movie(int id, String name) {

        }
    }

    interface MovieFactory {
        public Movie create(int id);
    }
    MovieFactory m1 = i -> new Movie(i);
    //
    MovieFactory m2 = Movie::new;

    interface MovieFactory2 {
        public Movie create(int id, String s);
    }

    // require functional interface parameters to map to constructor parameters;
    MovieFactory2 m3 = Movie::new;

    public static void main (String ... args) {
        ConstructorReferences client = new ConstructorReferences();
    }
}
