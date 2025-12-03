package software.ulpgc.application;

import software.ulpgc.io.RemoteMovieLoader;
import software.ulpgc.model.Movie;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        RemoteMovieLoader loader = new RemoteMovieLoader();
        List<Movie> movie = loader.loadAll();
        for (Movie m : movie) {
            System.out.println(m);
        }
    }
}
