package lambdaVideos2.streams.commonops;

import lambdaVideos2.domain.Trade;
import lambdaVideos2.util.TradeUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author yongot
 * @created 2020-09-28 : 9:14 PM
 */
public class Reducing {
    List<Trade> trades = TradeUtil.createTrades();
    List<Integer> ints = Arrays.asList();

    private void tradeInstrumentsList() {
        Optional<String> instList = trades.stream().map(Trade::getInstrument).reduce((a, b) -> a+","+b);
        System.out.println(instList);
    }

    private void schoolStaff() {
        List<Integer> ints = Arrays.asList(11, 13, 12, 15);
        int staff = ints.stream().reduce(10, (i,j) -> i+j);
        System.out.println("Total staff: " + staff);

    }

    private void tradeQuantitySum() {
        Optional<Integer> totalQuantity = trades.stream().map(Trade::getQuantity)
                .reduce((a,b) -> a + b);
        System.out.println("Total quantity: " + totalQuantity.get());
    }

    public static void main(String ... args) {
        new Reducing().schoolStaff();
        new Reducing().tradeQuantitySum();
        new Reducing().tradeInstrumentsList();
    }
}
