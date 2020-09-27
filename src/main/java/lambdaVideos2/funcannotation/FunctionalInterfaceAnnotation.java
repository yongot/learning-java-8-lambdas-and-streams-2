package lambdaVideos2.funcannotation;

/**
 * @author yongot
 * @created 2020-09-27 : 5:09 PM
 */
// @FunctionalInterface annotation
public class FunctionalInterfaceAnnotation {

    // help IDE to report issue if it is broken
    @FunctionalInterface
    interface Cruncher {
        int crunch(int i, int j);
    }

    public int cruncherService(int i, int j, Cruncher cruncher) {
        return cruncher.crunch(i, j);
    }

    public static void main(String ... args) {
        FunctionalInterfaceAnnotation client = new FunctionalInterfaceAnnotation();

        // client 1
        int ans = client.cruncherService(3,4, (p,q) -> p*q);
        System.out.println("Answer: " + ans);

        // client 2
        int ans2 = client.cruncherService(3,4, (p,q) -> p+q);
        System.out.println("Answer: " + ans2);

        // client 3
        int ans3 = client.cruncherService(3,4, (p,q) -> p-q);
        System.out.println("Answer: " + ans3);

        // client 4
        int ans4 = client.cruncherService(3,4, (p,q) -> p/q);
        System.out.println("Answer: " + ans4);

    }
}
