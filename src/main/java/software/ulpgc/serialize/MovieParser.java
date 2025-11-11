package software.ulpgc.serialize;

import software.ulpgc.model.Movie;

public interface MovieParser {
    Movie from(String str);
}
