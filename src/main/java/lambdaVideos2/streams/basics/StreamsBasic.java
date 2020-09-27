package lambdaVideos2.streams.basics;

import lambdaVideos2.domain.Trade;
import lambdaVideos2.util.TradeUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yongot
 * @created 2020-09-27 : 9:47 PM
 */
public class StreamsBasic {

    private List<Trade> findLargeTradesUsingPreJava8(List<Trade> trades) {
        List<Trade> largeTrades = new ArrayList<>();
        // logic for collecting the large trades
        for(Trade trade : trades) {
            if (trade.getQuantity() > 10000) {
                largeTrades.add(trade);
            }
        }

        return largeTrades;
    }

    private void findLargeTradesUsingStreams(List<Trade> trades) {
        List<Trade> largeTrades = trades.parallelStream().filter(trade -> trade.getQuantity() > 10000)
                .collect(Collectors.toList());
        System.out.println("Large trades: " + largeTrades);
    }

    public static void main(String ... args) {
        StreamsBasic basics = new StreamsBasic();
        List<Trade> trades = TradeUtil.createTrades();
        basics.findLargeTradesUsingPreJava8(trades);
        basics.findLargeTradesUsingStreams(trades);
    }
}
