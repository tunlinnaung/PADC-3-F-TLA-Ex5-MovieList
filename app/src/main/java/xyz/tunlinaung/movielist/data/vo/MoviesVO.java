package xyz.tunlinaung.movielist.data.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by eidoshack on 12/20/17.
 */

public class MoviesVO {

    @SerializedName("vote_count")
    private int voteCount;
    private int id;
    private boolean video;
    @SerializedName("vote_average")
    private double voteAverage;
    private String title;
    private double popularity;
    @SerializedName("poster_path")
    private String posterPath;
    @SerializedName("original_language")
    private String originalLanguage;
    @SerializedName("original_title")
    private String originalTitle;
    @SerializedName("genre_ids")
    private int[] genreIds;
    @SerializedName("backdrop_path")
    private String backdropPath;
    private boolean adult;
    private String overview;
    @SerializedName("release_date")
    private String releaseDate;

    public int getVoteCount() {
        return voteCount;
    }

    public int getId() {
        return id;
    }

    public boolean isVideo() { return video; }

    public double getVoteAverage() {
        return voteAverage;
    }

    public String getTitle() {
        return title;
    }

    public double getPopularity() {
        return popularity;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public int[] getGenreIds() {
        return genreIds;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public boolean isAdult() {
        return adult;
    }

    public String getOverview() {
        return overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    /* sample json
        {
            "vote_count": 4194,
            "id": 346364,
            "video": false,
            "vote_average": 7.2,
            "title": "It",
            "popularity": 981.284165,
            "poster_path": "/9E2y5Q7WlCVNEhP5GiVTjhEhx1o.jpg",
            "original_language": "en",
            "original_title": "It",
            "genre_ids": [
                18,
                14,
                27,
                53
            ],
            "backdrop_path": "/tcheoA2nPATCm2vvXw2hVQoaEFD.jpg",
            "adult": false,
            "overview": "In a small town in Maine, seven children known as The Losers Club come face to face with life problems, bullies and a monster that takes the shape of a clown called Pennywise.",
            "release_date": "2017-09-05"
        }
     */
}
