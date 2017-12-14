package xyz.tunlinaung.movielist.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.tunlinaung.movielist.R;
import xyz.tunlinaung.movielist.viewitems.TrailersInMoviesViewItem;

/**
 * Created by eidoshack on 12/14/17.
 */

public class TrailersInMoviesAdapter extends PagerAdapter {
    @Override
    public int getCount() {
        return 6;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == (View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Context context = container.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        TrailersInMoviesViewItem view =
                (TrailersInMoviesViewItem) inflater.inflate(R.layout.item_movies_trailers, container, false);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
