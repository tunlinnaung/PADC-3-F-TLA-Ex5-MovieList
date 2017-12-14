package xyz.tunlinaung.movielist.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.tunlinaung.movielist.R;
import xyz.tunlinaung.movielist.adapters.TrailersInMoviesAdapter;

/**
 * Created by eidoshack on 12/13/17.
 */

public class MoviesDetailsActivity extends AppCompatActivity
{
    @BindView(R.id.vp_movies_trailer)
    ViewPager viewPager;

    private TrailersInMoviesAdapter mTrailersInMoviesAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_details);

        ButterKnife.bind(this, this);

        mTrailersInMoviesAdapter = new TrailersInMoviesAdapter();
        viewPager.setAdapter(mTrailersInMoviesAdapter);
        int pagerPadding = 28;
        viewPager.setClipToPadding(false);
        viewPager.setPadding(pagerPadding, 1, pagerPadding, 1);
    }

}
