package lambdaVideos2.streams.primitivestreams;

import lambdaVideos2.domain.Trade;
import lambdaVideos2.functions.primitives.PrimitiveFunctions;
import lambdaVideos2.util.TradeUtil;

import java.util.List;
import java.util.Optional;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

/**
 * @author yongot
 * @created 2020-09-28 : 1:57 AM
 */
public class PrimitiveStreams {
    List<Trade> trades = TradeUtil.createTrades();

    private void tradeQuantity() {
        Optional<Integer> quantity = trades.stream().map(Trade::getQuantity).reduce(Integer::sum);
        System.out.println("Trade quantity: " + quantity);
    }

    private void intStream() {
        int[] ints = new int[] {2,4,6,8,10};

        IntStream intStream = IntStream.of(ints);
        intStream.forEach(System.out::println);

        IntStream intStream2 = IntStream.of(2,4,6,8,10);
        intStream2.forEach(System.out::println);
    }

    private void doubleStream() {
        double[] doubles = new double[] {2.4,4.2,6.3,8.5,10.1};

        DoubleStream doubleStream = DoubleStream.of(doubles);
        doubleStream.forEach(System.out::println);

        DoubleStream doubleStream2 = DoubleStream.of(2.4,4.2,6.3,8.5,10.1);
        doubleStream2.forEach(System.out::println);
    }

    private void convertStreams() {
        int sumQuantity = trades.stream().mapToInt(Trade::getQuantity).sum();
    }

    public static void main(String ... args) {
        new PrimitiveStreams().tradeQuantity();
        new PrimitiveStreams().intStream();
        new PrimitiveStreams().doubleStream();
    }
}
