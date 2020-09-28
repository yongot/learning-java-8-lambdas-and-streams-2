package lambdaVideos2.streams.advanced;

import lambdaVideos2.domain.Trade;
import lambdaVideos2.util.TradeUtil;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @author yongot
 * @created 2020-09-28 : 10:29 PM
 */
public class CustomCollectors {
    List<Trade> trades = TradeUtil.createTrades();
    private void collectIntoToCustomCollector() {
        System.out.println("======collectIntoToCustomCollector======");
        Supplier<StringBuilder> supplier = StringBuilder::new;

        BiConsumer<StringBuilder, Trade> accumulator =
                (sb, trade) -> sb.append(trade.getInstrument()).append(",");

        BiConsumer<StringBuilder, StringBuilder> combiner =
                (s1, s2) -> s1.append(s2.toString());

        StringBuilder results = trades.stream().collect(supplier, accumulator, combiner);

        System.out.println(results);

    }

    private void stats() {
        System.out.println("======stats======");
        List<Trade> trades = TradeUtil.createTrades();
        IntSummaryStatistics s = trades.stream().collect(Collectors.summarizingInt(Trade::getQuantity));
        System.out.println(s);
    }

    public static void main(String[] args) {
        new CustomCollectors().collectIntoToCustomCollector();
        new CustomCollectors().stats();
    }

}
