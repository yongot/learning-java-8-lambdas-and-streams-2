package lambdaVideos2.basics.examplelambdas;

import lambdaVideos2.domain.Trade;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author yongot
 * @created 2020-09-27 : 1:19 PM
 */
public class ExampleLambdaExpressions_Callables {

    private void testCallable(Callable<Trade> callable) throws Exception {
        ExecutorService es = Executors.newSingleThreadExecutor();
        Future<Trade> tradeFuture = es.submit(callable);
        Trade t = tradeFuture.get();
        System.out.println("Executed using Callable: " + t);
    }

    public static void main(String ... args) throws Exception {
        ExampleLambdaExpressions_Callables client = new ExampleLambdaExpressions_Callables();

        // Using callable
        Callable<Trade> c = () -> {
            Trade t = new Trade("GOOGLE", 2000, "OPEN");
            System.out.println("Persisting trade ...");
            // encrypt(t);
            // persist(t);
            // notify();
            return t;
        };

        client.testCallable(c);

        // Callable<Trade> callable = () -> new Trade("GOOGLE", 2000, "OPEN");

        Trade trade1 = new Trade( "GOOGLE", 2000, "OPEN");
        Trade trade2 = new Trade("GOOGLE", 8000, "OPEN");

        client.testCallable(() -> {
            Trade mergedTrade = new Trade();
            mergedTrade.setInstrument(trade1.getInstrument());
            mergedTrade.setStatus(trade1.getStatus());
            mergedTrade.setQuantity(trade1.getQuantity()+trade2.getQuantity());
            return mergedTrade;
        });

    }
}
