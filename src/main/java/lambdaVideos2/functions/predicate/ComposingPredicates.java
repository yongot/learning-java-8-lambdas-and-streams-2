package lambdaVideos2.functions.predicate;

import lambdaVideos2.domain.Trade;
import lambdaVideos2.util.TradeUtil;

import java.util.List;
import java.util.function.Predicate;

/**
 * @author yongot
 * @created 2020-09-27 : 8:04 PM
 */
public class ComposingPredicates {

    private void testPredicates(Trade trade) {
        // LOGICAL AND
        Predicate<Trade> bigTrade = t -> t.isBigTrade();
        Predicate<Trade> cancelledTrade = t -> t.isCancelledTrade();

        Predicate<Trade> bigAndCancelledTrade = t -> t.isBigTrade() && t.isCancelledTrade();
        Predicate<Trade> bigAndCancelledTrade2 = bigTrade.and(cancelledTrade);

        Predicate<Trade> issuerTrade = t -> t.getInstrument().equals("GOOG");
        Predicate<Trade> bigAndCancelledTradeForGoogleIssuer = bigAndCancelledTrade2.and(issuerTrade);

        // LOGICAL OR
        Predicate<Trade> newTrade = t -> t.getStatus().equals("NEW");
        Predicate<Trade> newOrCancelledTrade = newTrade.or(cancelledTrade);

        Predicate<Trade> newOrCancelledButBigTrade = newTrade.or(cancelledTrade).and(bigTrade);

        // NEGATE
        Predicate<Trade> notANewTrade = newTrade.negate();

        // EQUALS
        List<Trade> trades = TradeUtil.createTrades();
        Trade t1 = new Trade("GOOG", 200000, "CANCEL");

        Predicate<Trade> p1 = Predicate.isEqual(t1);

        for (Trade t  : trades) {
            if (p1.test(t)) {
                System.out.println("Matching trade: " + t);
            }
        }

    }

    public static void main (String ... args) {
        ComposingPredicates client = new ComposingPredicates();
        client.testPredicates(null);
    }
}
