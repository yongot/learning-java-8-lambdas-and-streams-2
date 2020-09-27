package lambdaVideos2.functional;

/**
 * @author yongot
 * @created 2020-09-27 : 5:05 PM
 */
public class FunctionalInterfaces {

    // Functional interface
    @FunctionalInterface
    interface Multiplier {
        // one single abstract method
        int multiply(int i, int j);
//        int square(int j);
    }
    // Lambda expression
    // not target interface anymore if more than 1 abstract method is defined
    Multiplier multiplierLambda = (p, q) -> p*q;

    public static void main(String ... args) {
        FunctionalInterfaces client = new FunctionalInterfaces();
    }
}
