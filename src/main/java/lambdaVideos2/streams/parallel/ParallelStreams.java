package lambdaVideos2.streams.parallel;

import lambdaVideos2.domain.Trade;
import lambdaVideos2.util.TradeUtil;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Stream;

/**
 * @author yongot
 * @created 2020-09-28 : 10:45 PM
 */
public class ParallelStreams {
    List<Trade> trades = TradeUtil.createTrades();

    private void serialStream() {
        Optional<Integer> sumOfTrades = trades
                .stream()
                .filter(t -> {
                    System.out.printf("Id: %d Filter Thread: %s:\n", t.getId(),
                            Thread.currentThread().getName());
                    return t.isBigTrade();
                })
                .map(t -> {
                    System.out.printf("Id: %d Map Thread: %s:\n", t.getId(),
                            Thread.currentThread().getName());
                    return t.getQuantity();
                }).reduce(Integer::sum);

        System.out.println(sumOfTrades.get());

    }

    private void parallelStream() {
        Optional<Integer> sumOfTrades = trades
                .stream()
                .parallel()
                .filter(Trade::isBigTrade)
                .peek(t -> System.out.printf(
                        "Trade Id=%d (Filter Thread Name=%s)\n", t.getId(),
                        Thread.currentThread().getName()))
                .map(t -> t.getQuantity())
                .peek(t -> System.out.printf("(Mapper Thread Name=%s)\n",
                        Thread.currentThread().getName()))
                .reduce(Integer::sum);

        System.out.println(sumOfTrades.get());
    }

    private void collectionParallelStream() {

        Stream<Trade> parallelStreams = trades.parallelStream();

    }

    public static void main(String[] args) {
        int threads = new ForkJoinPool().getParallelism();
        System.out.println("Number of threads: " + threads);
        //new ParallelStreams().serialStream();
        new ParallelStreams().parallelStream();
    }

}
