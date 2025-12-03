package software.ulpgc.application;

import software.ulpgc.model.Movie;

public class TsvMovieParser implements MovieParser {
    @Override
    public Movie from(String str) {
        return from(str.split("\t"));
    }

    private Movie from(String[] split) {
        return new Movie(split[2], toInt(split[5]), toInt(split[7]));

    }

    private int toInt(String str) {
        if(isVoid(str)) return -1;
        return Integer.parseInt(str);
    }

    private static boolean isVoid(String str) {
        return str.equals("\\N");
    }
}
