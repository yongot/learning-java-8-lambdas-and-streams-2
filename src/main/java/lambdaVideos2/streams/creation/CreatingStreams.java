package lambdaVideos2.streams.creation;

import lambdaVideos2.domain.Movie;
import lambdaVideos2.util.MovieUtil;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author yongot
 * @created 2020-09-28 : 1:21 AM
 */
public class CreatingStreams {

    //
    private void testCollectionStreams() {
        List<Movie> movies = MovieUtil.createMovies();

        movies.stream().forEach(System.out::println);
    }

    private void testEmptyStreams() {
        Stream<Movie> movies = Stream.empty();
        System.out.println("Empty stream:" + movies.count());
    }

    private void testStreamsFromValues() {
        Stream<String> movieNames = Stream.of("Gods Must Be Crazy", "Fiddler On The Roof");
        System.out.println("testStreamsFromValues: " + movieNames.count());

        String[] movieNames2 = {"Gods Must Be Crazy", "Fiddler On The Roof"};
        Stream<String> mNames = Stream.of(movieNames2);

    }

    private void testFileStream() {
        try {
            URL url = getClass().getClassLoader().getResource("tmp.txt");
            URI uri = url.toURI();
            System.out.printf("URL: %s, URI: %s", url, uri);
            Stream<String> fileLines = Files.lines(Paths.get(uri));
            fileLines.forEach(System.out::println);
        } catch(IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    private void testGenerateIterateStreams() {
        // infinite stream
        Stream<Double> randomStream = Stream.generate(Math::random);
//        randomStream.forEach(System.out::println);

        // iterate
        Stream<Integer> wholeNumbers = Stream.iterate(1, i -> i+1);
        // wholeNumbers.forEach(System.out::println);
    }

    public static void main(String[] args) {
        new CreatingStreams().testEmptyStreams();
        new CreatingStreams().testStreamsFromValues();
        new CreatingStreams().testCollectionStreams();
        new CreatingStreams().testFileStream();
        new CreatingStreams().testGenerateIterateStreams();
    }
}
