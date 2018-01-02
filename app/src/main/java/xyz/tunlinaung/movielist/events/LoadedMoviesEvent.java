package xyz.tunlinaung.movielist.events;

import java.util.List;

import xyz.tunlinaung.movielist.data.vo.MoviesVO;

/**
 * Created by eidoshack on 1/2/18.
 */

public class LoadedMoviesEvent {
    private List<MoviesVO> moviesList;

    public LoadedMoviesEvent(List<MoviesVO> moviesList) {
        this.moviesList = moviesList;
    }

    public List<MoviesVO> getMoviesList() {
        return moviesList;
    }
}
