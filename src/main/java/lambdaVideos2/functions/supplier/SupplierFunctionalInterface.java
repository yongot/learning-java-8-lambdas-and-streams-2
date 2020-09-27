package lambdaVideos2.functions.supplier;

import lambdaVideos2.domain.Trade;
import lambdaVideos2.util.TradeUtil;

import java.util.List;
import java.util.function.Supplier;

/**
 * @author yongot
 * @created 2020-09-27 : 8:23 PM
 */
public class SupplierFunctionalInterface {

    Supplier<String[]> fruitSupplier = () -> new String[]{"Apple", "Orange"};
    Supplier<List<Trade>> tradeSupplier = () -> TradeUtil.createTrades();

    private void testSupplier() {
        String[] fruits = fruitSupplier.get();
        for (String fruit : fruits) {
            System.out.println("Fruit is: " + fruit);
        }

        List<Trade> trades = tradeSupplier.get();
        for (Trade trade : trades) {
            System.out.println(trade);
        }
    }

    public static void main(String ... args) {
        new SupplierFunctionalInterface().testSupplier();
    }
}
