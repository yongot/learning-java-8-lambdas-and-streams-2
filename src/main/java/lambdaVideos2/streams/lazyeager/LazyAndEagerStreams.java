package lambdaVideos2.streams.lazyeager;

import lambdaVideos2.domain.Movie;
import lambdaVideos2.util.MovieUtil;

import java.util.List;
import java.util.stream.Stream;

/**
 * @author yongot
 * @created 2020-09-28 : 1:44 AM
 */
public class LazyAndEagerStreams {

    List<Movie> movies = MovieUtil.createMovies();

    private void testLazy() {
        movies.stream().filter(m -> {
            System.out.println("Inside lazy operation");
            return m.isClassic() ? true : false;
        }).count();
    }

    private void testEager() {
        Stream<Movie> moviesStream =
                movies.stream()
                        .filter(m -> {
                            System.out.println("Fitering");
                            return m.isClassic() ? true : false;
                        }).map(s -> {
                    System.out.println("Mapping");
                    return s;
                });

        System.out.println("" + moviesStream.count());
    }

    public static void main(String[] args) {
        new LazyAndEagerStreams().testLazy();
        new LazyAndEagerStreams().testEager();
    }

}
