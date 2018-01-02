package xyz.tunlinaung.movielist.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import xyz.tunlinaung.movielist.R;
import xyz.tunlinaung.movielist.data.vo.MoviesVO;
import xyz.tunlinaung.movielist.delegates.MoviesActionDelegate;
import xyz.tunlinaung.movielist.model.Movie;
import xyz.tunlinaung.movielist.viewholders.ItemMoviesViewHolder;

/**
 * Created by eidoshack on 12/7/17.
 */

public class MoviesAdapter extends RecyclerView.Adapter<ItemMoviesViewHolder> {

    private List<MoviesVO> movieList;

    private MoviesActionDelegate moviesActionDelegate;

    public MoviesAdapter(MoviesActionDelegate moviesActionDelegate) {
        this.moviesActionDelegate = moviesActionDelegate;
        this.movieList = new ArrayList<>();
    }

    @Override
    public ItemMoviesViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        return new ItemMoviesViewHolder(
                moviesActionDelegate,
                LayoutInflater.from(parent.getContext())
                              .inflate(R.layout.item_movies, parent, false));
    }

    @Override
    public void onBindViewHolder(ItemMoviesViewHolder holder, int position)
    {
        holder.setMovies(movieList.get(position));
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public void setMovies(List<MoviesVO> moviesVOList) {
        movieList = moviesVOList;
        notifyDataSetChanged();
    }
}
