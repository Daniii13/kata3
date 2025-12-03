package software.ulpgc.viewmodel;

import software.ulpgc.model.Movie;

import java.util.List;
import java.util.function.Function;

public class HistogramBuilder {

    private final Function<Movie, Integer> binarize;

    public HistogramBuilder(Function<Movie, Integer> binarize) {
        this.binarize = binarize;
    }

    public Histogram buildWith(List<Movie> movies) {
        Histogram histogram = new Histogram();
        for (Movie movie : movies) {
            histogram.add(binOf(movie));

        }
        return histogram;
    }

    private int binOf(Movie movie) {
        return binarize.apply(movie);
    }
}
