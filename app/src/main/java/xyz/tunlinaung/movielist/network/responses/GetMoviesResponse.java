package xyz.tunlinaung.movielist.network.responses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import xyz.tunlinaung.movielist.data.vo.MoviesVO;

/**
 * Created by eidoshack on 1/2/18.
 */

public class GetMoviesResponse {
    private int code;
    private String message;
    private String apiVersion;
    private String page;
    @SerializedName("popular-movies")
    private List<MoviesVO> popularMovies;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public String getPage() {
        return page;
    }

    public List<MoviesVO> getPopularMovies() {
        return popularMovies;
    }
}
