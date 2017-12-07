package xyz.tunlinaung.movielist.viewholders;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.tunlinaung.movielist.R;
import xyz.tunlinaung.movielist.model.Movie;

/**
 * Created by eidoshack on 12/7/17.
 */

public class ItemMoviesViewHolder extends RecyclerView.ViewHolder
{
    @BindView(R.id.cv_movies_list) CardView moviesCardView;

    @BindView(R.id.iv_movie_poster) ImageView ivMoviePoster;

    @BindView(R.id.lbl_movie_title) TextView lblMovieTitle;

    @BindView(R.id.lbl_movie_category) TextView lblMovieCategory;

    @BindView(R.id.lbl_rating) TextView lblRating;

    public ItemMoviesViewHolder(View itemView)
    {
        super(itemView);

        ButterKnife.bind(this, itemView);
    }

    public CardView getMoviesCardView() {
        return moviesCardView;
    }

    public void setMoviesCardView(CardView moviesCardView) {
        this.moviesCardView = moviesCardView;
    }

    public ImageView getIvMoviePoster() {
        return ivMoviePoster;
    }

    public void setIvMoviePoster(ImageView ivMoviePoster) {
        this.ivMoviePoster = ivMoviePoster;
    }

    public TextView getLblMovieTitle() {
        return lblMovieTitle;
    }

    public void setLblMovieTitle(TextView lblMovieTitle) {
        this.lblMovieTitle = lblMovieTitle;
    }

    public TextView getLblMovieCategory() {
        return lblMovieCategory;
    }

    public void setLblMovieCategory(TextView lblMovieCategory) {
        this.lblMovieCategory = lblMovieCategory;
    }

    public TextView getLblRating() {
        return lblRating;
    }

    public void setLblRating(TextView lblRating) {
        this.lblRating = lblRating;
    }
}
