package lambdaVideos2.streams.commonops;

import lambdaVideos2.domain.Trade;
import lambdaVideos2.util.TradeUtil;

import java.util.List;
import java.util.Optional;

/**
 * @author yongot
 * @created 2020-09-28 : 9:06 PM
 */
public class Finders {

    List<Trade> trades = TradeUtil.createTrades();

    private void testFindFirst() {
        Optional<Trade> firstTrade = trades.stream()
                .filter(Trade::isBigTrade)
                .findFirst();

        System.out.println("First trade: " + firstTrade.get());
    }

    private void testFindAny() {
        // differ in parallelism
        Optional<Trade> trade = trades.parallelStream()
                .filter(Trade::isBigTrade)
                .findAny();

        System.out.println("Any trade: " + trade.get());
    }

    private void testAnyMatch() {
        boolean rottenTrade = trades.stream().anyMatch(t -> t.getStatus().equals("ROTTEN"));
        System.out.println("Any match Rotten trade?: " + rottenTrade);

    }

    private void testAllMatch() {
        boolean ibmTrade = trades.stream().allMatch(t -> t.getInstrument().equals("IBM"));
        System.out.println("All IBM trade?: " + ibmTrade);
    }

    private void testNoneMatch() {
        boolean cancelledTrade = trades.stream().noneMatch(t -> t.getStatus().equals("UNKNOWN"));
        System.out.println("None Match?: " + cancelledTrade);
    }

    public static void main(String ... args) {
        new Finders().testFindAny();
        new Finders().testFindFirst();
        new Finders().testAnyMatch();
        new Finders().testAllMatch();
        new Finders().testNoneMatch();
    }
}
