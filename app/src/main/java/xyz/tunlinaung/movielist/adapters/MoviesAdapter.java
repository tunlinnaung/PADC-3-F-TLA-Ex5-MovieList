package xyz.tunlinaung.movielist.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import xyz.tunlinaung.movielist.R;
import xyz.tunlinaung.movielist.model.Movie;
import xyz.tunlinaung.movielist.viewholders.ItemMoviesViewHolder;

/**
 * Created by eidoshack on 12/7/17.
 */

public class MoviesAdapter extends RecyclerView.Adapter<ItemMoviesViewHolder> {

    private List<Movie> movieList;

    public MoviesAdapter(List<Movie> movieList) {
        this.movieList = movieList;
    }

    @Override
    public ItemMoviesViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        return new ItemMoviesViewHolder(
                LayoutInflater.from(parent.getContext())
                              .inflate(R.layout.item_movies, parent, false));
    }

    @Override
    public void onBindViewHolder(ItemMoviesViewHolder holder, int position)
    {
        holder.getIvMoviePoster().setImageResource(movieList.get(position).getPoster());
        holder.getLblMovieTitle().setText(movieList.get(position).getTitle());
        holder.getLblMovieCategory().setText(movieList.get(position).getCategories());
        holder.getLblRating().setText(movieList.get(position).getRating());
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView)
    {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }
}
