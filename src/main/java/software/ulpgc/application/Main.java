package software.ulpgc.application;

import software.ulpgc.io.RemoteMovieLoader;
import software.ulpgc.model.Movie;
import software.ulpgc.viewmodel.Histogram;
import software.ulpgc.viewmodel.HistogramBuilder;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Movie> movies = new RemoteMovieLoader().loadAll();
        Histogram histogram = new HistogramBuilder(movie -> (movie.year() / 10) * 10).buildWith(movies);
        for (int bin : histogram) {
            System.out.println(bin + ": " + histogram.count(bin));
        }
    }
}
