package software.ulpgc.application;

import software.ulpgc.model.Movie;

public interface MovieParser {
    Movie from(String str);
}
