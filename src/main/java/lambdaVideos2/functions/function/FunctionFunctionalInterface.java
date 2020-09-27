package lambdaVideos2.functions.function;

import lambdaVideos2.domain.Movie;
import lambdaVideos2.domain.Trade;
import lambdaVideos2.util.TradeUtil;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author yongot
 * @created 2020-09-27 : 8:53 PM
 */
public class FunctionFunctionalInterface {

    List<Trade> trades = TradeUtil.createTrades();

    Supplier<List<Trade>> tradesSupplier = () -> TradeUtil.createTrades();
    Function<String, Movie> createMovieFunction = s -> new Movie(s);
    Function<Integer, Trade> tradeFinder = id -> {
        List<Trade> trades = tradesSupplier.get();
        return trades.stream()
                .filter(t -> t.getId() == id)
                .findFirst().get();
    };
    private void testFunction(String movieName) {
        Movie movie = createMovieFunction.apply(movieName);
        System.out.println("Movie is: " + movie);

        Trade t = tradeFinder.apply(2);
        System.out.println("Trade is: " + t);
    }

    public static void main(String ... args) {
        new FunctionFunctionalInterface().testFunction("Gods Must Be Crazy");
    }
}
