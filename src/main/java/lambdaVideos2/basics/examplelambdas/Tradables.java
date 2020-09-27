package lambdaVideos2.basics.examplelambdas;

import lambdaVideos2.domain.Trade;

/**
 * @author yongot
 * @created 2020-09-27 : 1:03 PM
 */
interface ITradable<Trade>{
    boolean check(Trade t);
}
public class Tradables {
    public static void main(String ... args) {
        Tradables client = new Tradables();

        ITradable<Trade> bigTrade = ( Trade t ) -> t.getQuantity() > 1000000? true:false;

        ITradable<Trade> openTrade = (trade) -> trade.getStatus().equals("OPEN")? true:false;

    }
}
