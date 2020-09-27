package lambdaVideos2.basics.examplelambdas;

import lambdaVideos2.domain.Trade;

import java.util.concurrent.Callable;

/**
 * Example Lambdas
 *
 * @author yongot
 * @created 2020 - 09 - 27 : 12:55 PM
 */
public class Runnables {

    public void methodAcceptingRunnable(Runnable r) {

    }

    public void methodAcceptingCallable(Callable c) {

    }

    public static void main(String ... args) {
        Runnable runnable = () -> System.out.println("Hello, Lambda");

        new Runnables().methodAcceptingRunnable(runnable);

        new Runnables().methodAcceptingRunnable(() -> {
            System.out.println("Complex Lambda");
            persist();
            email();
        });

        // return value
        Callable callable = () -> "Hello, Callable";

        new Runnables().methodAcceptingCallable(() -> {
            return "Hello!";
        });
    }

    private static void persist() {
    }

    private static void email() {

    }

    interface Tradable<Trade> {
        boolean check(Trade t);
    }

    Tradable<Trade> bigTradeLambda = (trade) -> trade.isBigTrade();
    Tradable<Trade> ibmTradeLambda = (trade) -> trade.getInstrument().equals("IBM");
}
