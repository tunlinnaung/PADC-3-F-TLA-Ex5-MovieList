package xyz.tunlinaung.movielist.data.models;

import xyz.tunlinaung.movielist.network.HttpUrlConnectionDataAgent;
import xyz.tunlinaung.movielist.network.MoviesDataAgent;

/**
 * Created by eidoshack on 1/2/18.
 */

public class MoviesModel {
    private static MoviesModel sObjInstance;
    private MoviesDataAgent mMoviesDataAgent;

    private MoviesModel() {
        mMoviesDataAgent = HttpUrlConnectionDataAgent.getInstance();
    }

    public static MoviesModel getInstance() {
        if (sObjInstance == null) {
            sObjInstance = new MoviesModel();
        }

        return sObjInstance;
    }

    public void loadMovies() {
        mMoviesDataAgent.loadMovies();
    }
}
