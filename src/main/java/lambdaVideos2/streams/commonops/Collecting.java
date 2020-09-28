package lambdaVideos2.streams.commonops;

import com.sun.xml.internal.ws.encoding.policy.MtomPolicyMapConfigurator;
import lambdaVideos2.domain.Movie;
import lambdaVideos2.domain.Trade;
import lambdaVideos2.util.MovieUtil;
import lambdaVideos2.util.TradeUtil;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author yongot
 * @created 2020-09-28 : 8:57 PM
 */
public class Collecting {
    List<Trade> trades = TradeUtil.createTrades();

    private void collectIntoAList() {
        List<Trade> collection = trades.stream().collect(Collectors.toList());
        System.out.println(collection);
    }

    private void collectIntoASet() {
        Set<Trade> collection = trades.stream().collect(Collectors.toSet());
        System.out.println(collection);
    }

    private void collectIntoAMap() {
        List<Movie> movies = MovieUtil.createMovies();

        Map<String, Movie> movieMap = movies.stream().collect(Collectors.toMap(Movie::getName, movie -> movie));
        System.out.println(movieMap);
    }

    public static void main(String ... args) {
        new Collecting().collectIntoAList();
        new Collecting().collectIntoASet();
        new Collecting().collectIntoAMap();
    }
}
