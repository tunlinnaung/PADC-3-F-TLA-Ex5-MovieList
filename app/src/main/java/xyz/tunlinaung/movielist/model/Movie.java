package xyz.tunlinaung.movielist.model;

/**
 * Created by eidoshack on 12/7/17.
 */

public class Movie
{
    private int poster;
    private String title;
    private String categories;
    private String rating;

    public Movie() {
    }

    public Movie(int poster, String title, String categories, String rating) {
        this.poster = poster;
        this.title = title;
        this.categories = categories;
        this.rating = rating;
    }

    public int getPoster() { return poster; }

    public void setPoster(int poster) { this.poster = poster; }

    public String getTitle() { return title; }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
