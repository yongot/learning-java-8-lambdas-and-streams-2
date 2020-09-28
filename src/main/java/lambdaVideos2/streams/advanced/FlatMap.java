package lambdaVideos2.streams.advanced;

import lambdaVideos2.domain.Actor;
import lambdaVideos2.domain.Movie;
import lambdaVideos2.util.MovieUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author yongot
 * @created 2020-09-28 : 10:38 PM
 */
public class FlatMap {
    List<Movie> movies = MovieUtil.createMoviesAndActors();
    String[] fruits = new String[]{"apples","oranges"};
    String[] veggies = new String[]{"beans","peas"};

    private void flatMapMovies(){
        System.out.println("=====flatMapMovies=====");
        Stream<Actor> actorsStream =
                movies.stream().flatMap(m -> m.getActors().stream());

        actorsStream.forEach(System.out::println);
    }

    private void flatMapVeggies() {
        System.out.println("=====flatMapVeggies=====");
        Stream<List<String>> fruitsAndVeggies =
                Stream.of(Arrays.asList(fruits), Arrays.asList(veggies));
        fruitsAndVeggies.flatMap(s -> s.stream())
                .forEach(System.out::println);

    }

    public static void main(String[] args) {
        new FlatMap().flatMapVeggies();
        new FlatMap().flatMapMovies();

    }

}
