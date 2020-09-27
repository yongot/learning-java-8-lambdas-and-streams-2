package lambdaVideos2.basics.examplelambdas;

import lambdaVideos2.domain.Trade;

import java.util.concurrent.Callable;

/**
 * @author yongot
 * @created 2020 - 09 - 27 : 12:56 PM
 */
public class Callables {

    Callable<Trade> callable = () -> new Trade("GOOG", 2000, "OPEN");

    Callable<Trade> blockCallable = () -> {
        Trade t = new Trade("GOOG", 2000, "OPEN");
        System.out.println("Creating a new Trade ...");
        // encrypt(t)
        // notify();
        // persist(t);
        return t;
    };

    public static void main(String ... args) {
        Callables client = new Callables();
    }
}
