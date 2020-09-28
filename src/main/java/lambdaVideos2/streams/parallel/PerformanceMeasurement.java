package lambdaVideos2.streams.parallel;

import lambdaVideos2.domain.Trade;
import lambdaVideos2.util.TradeUtil;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

/**
 * @author yongot
 * @created 2020-09-28 : 11:01 PM
 */
public class PerformanceMeasurement {

    private static final int MAX_TRADE_SIZE = 1000000;

    public void sumTradesInSerial(){
        System.out.println("\n=====sumTradesInSerial=====");
        List<Trade> trades = TradeUtil.createTrades(MAX_TRADE_SIZE);
        Instant start = Instant.now();
        // Sequential mode
        trades.stream()
                .map(Trade::getQuantity)
                .reduce(Integer::sum);

        Instant end = Instant.now();
        Duration d = Duration.between(start, end);
        System.out.printf("%s %d %s" , "Aggregating trades took ", d.toMillis()," ms in Seqential mode");
    }

    public void sumTradesInParallell(){
        System.out.println("\n=====sumTradesInParallell=====");
        List<Trade> trades = TradeUtil.createTrades(MAX_TRADE_SIZE);
        Instant start = Instant.now();
        // Parallel code
        // Sequential mode
        trades.stream()
                .parallel()
                .map(Trade::getQuantity)
                .reduce(Integer::sum);

        Instant end = Instant.now();
        Duration d = Duration.between(start, end);
        System.out.printf("%s %d %s" , "Aggregating trades took ", d.toMillis()," ms in Parallel mode");
    }



    /**
     * @param args
     */
    public static void main(String[] args) {
        new PerformanceMeasurement().sumTradesInSerial();
        new PerformanceMeasurement().sumTradesInParallell();
    }

}
