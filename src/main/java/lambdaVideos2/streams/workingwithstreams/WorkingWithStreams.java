package lambdaVideos2.streams.workingwithstreams;

import lambdaVideos2.domain.Movie;
import lambdaVideos2.util.MovieUtil;

import java.util.List;

/**
 * @author yongot
 * @created 2020-09-27 : 9:57 PM
 */
public class WorkingWithStreams {

    List<Movie> movies = MovieUtil.createMovies();

    private void findMoviesByDirector(String director) {
        movies.stream()
                //.filter(m -> m.getDirector().equals(director))
                .map(Movie::getName)
                .distinct()
               // .limit(3)
                .forEach(System.out::println);
    }

    public static void main(String ... args) {
        new WorkingWithStreams().findMoviesByDirector("Steven Spielberg");
    }
}
