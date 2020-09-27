package lambdaVideos2.streams.iterationstrategy;

import lambdaVideos2.domain.Movie;
import lambdaVideos2.util.MovieUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yongot
 * @created 2020-09-28 : 1:39 AM
 */
public class InternalAndExternalIterationStrategy {

    List<Movie> movies = MovieUtil.createMovies();
    List<Movie> top2Classics = new ArrayList<>(10);

    private void testExternalIteration1() {
        // Logic for finding top 2 classic movies
        for(Movie m: movies){
//			System.out.println("Inside external iteration");
            if(m.isClassic()){
                top2Classics.add(m);
            }
        }
//        System.out.println("Top 2 classics (Ext Iteration): " + top2Classics);
    }
    private void testInternalIteration1() {
        System.out.println("Internal Iteration");
        // no external storage is required
        movies.parallelStream()
                .filter(Movie::isClassic)
                .map(Movie::getName)
                .limit(2)
                .forEach(System.out::println);

    }

    private void testInternalIteration2() {

    }

    private void testInternalIteration3() {
    }

    public static void main(String[] args) {
        new InternalAndExternalIterationStrategy().testInternalIteration1();
        new InternalAndExternalIterationStrategy().testInternalIteration2();
        new InternalAndExternalIterationStrategy().testInternalIteration3();
        new InternalAndExternalIterationStrategy().testExternalIteration1();
    }

}
