package software.ulpgc.io;

import software.ulpgc.model.Movie;

import java.util.List;

public interface MovieLoader {
    List<Movie> loadAll();
}
