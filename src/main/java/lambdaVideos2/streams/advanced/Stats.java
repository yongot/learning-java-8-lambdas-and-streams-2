package lambdaVideos2.streams.advanced;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

/**
 * @author yongot
 * @created 2020-09-28 : 10:41 PM
 */
public class Stats {
    IntStream streamOfInts = IntStream.range(1, 100);

    private void range() {
        System.out.println("====range====");
        IntStream ints = IntStream.rangeClosed(10, 20);
        ints.forEach(System.out::println);
    }
    //Min, Max and Average
    private void testMaxAndMin() {
        System.out.println("====testMaxAndMin====");
        IntStream ints = IntStream.rangeClosed(10, 20);
        OptionalInt max = ints.max();
        System.out.println("Max: "+max.getAsInt());

        ints = IntStream.rangeClosed(10, 20);
        OptionalInt min = ints.min();
        System.out.println("Min: "+min.getAsInt());

        ints = IntStream.rangeClosed(10, 20);
        OptionalDouble avg = ints.average();
        System.out.println("Min: "+avg.getAsDouble());


    }

    public static void main(String[] args) {
        new Stats().range();
        new Stats().testMaxAndMin();
    }

}
