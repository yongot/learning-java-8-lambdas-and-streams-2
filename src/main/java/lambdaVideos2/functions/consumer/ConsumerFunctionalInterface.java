package lambdaVideos2.functions.consumer;

import lambdaVideos2.domain.Movie;

import java.util.function.Consumer;

/**
 * @author yongot
 * @created 2020-09-27 : 8:15 PM
 */
public class ConsumerFunctionalInterface {
    // Consumer for a movie print info
    Consumer<Movie> printInfo = m -> System.out.println("Printing out movie info: " + m);
    Consumer<Movie> persistMovie = m -> persist(m);

    // Consumer for movie notification
    Consumer<Movie> notifyMovie = m -> notify(m);

    private void testConsumer(Movie movie) {
        printInfo.accept(movie);
        persistMovie.accept(movie);
    }

    private void testAndThen(Movie movie) {
        Consumer<Movie> printAndPersistMovie = persistMovie.andThen(printInfo);
        printAndPersistMovie.accept(movie);

        System.out.println("Test Chained Consumer: Notify -> Persist -> Print");
        Consumer<Movie> chainedConsumer = notifyMovie.andThen(persistMovie).andThen(printInfo);
        chainedConsumer.accept(movie);
    }

    private void persist(Movie m) {
        System.out.println("Persisting movie"+m);
    }

    private void notify(Movie m) {
        System.out.println("Notifying about movie"+m);
    }

    public static void main(String ... args) {
        Movie movie = new Movie("Gods Must Be Crazy");
        new ConsumerFunctionalInterface().testConsumer(movie);

        System.out.println("andThen ....");
        new ConsumerFunctionalInterface().testAndThen(movie);
    }
}
