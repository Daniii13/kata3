package software.ulpgc.io;

import software.ulpgc.model.Movie;
import software.ulpgc.application.TsvMovieParser;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;

public class RemoteMovieLoader implements  MovieLoader {
    private static final String remoteUrl = "https://datasets.imdbws.com/title.basics.tsv.gz";
    private static final int bufferSize = 65526;

    @Override
    public List<Movie> loadAll() {
        try {
            return loadAllFrom(new URL(remoteUrl));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Movie> loadAllFrom(URL url) throws IOException {
        return loadALlFrom(url.openConnection());
    }

    private List<Movie> loadALlFrom(URLConnection connection) throws IOException {
        try(InputStream is = new GZIPInputStream(new BufferedInputStream(connection.getInputStream(), bufferSize))) {
            return loadAllFrom(is);
        }
    }

    private List<Movie> loadAllFrom(InputStream is) throws IOException {
        return loadAllFrom(new BufferedReader(new InputStreamReader(is)));
    }

    private List<Movie> loadAllFrom(BufferedReader reader) throws IOException {
        List<Movie> movies = new ArrayList<>();
        TsvMovieParser parser = new TsvMovieParser();
        reader.readLine();
        while (true) {
            String line = reader.readLine();
            if (line == null) {break;}
            movies.add(parser.from(line));
        }
        return movies;
    }
}
