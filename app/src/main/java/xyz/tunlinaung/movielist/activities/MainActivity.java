package xyz.tunlinaung.movielist.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.tunlinaung.movielist.R;
import xyz.tunlinaung.movielist.adapters.MoviesAdapter;
import xyz.tunlinaung.movielist.delegates.MoviesActionDelegate;
import xyz.tunlinaung.movielist.model.Movie;

public class MainActivity extends AppCompatActivity implements MoviesActionDelegate {

    @BindView(R.id.rv_movie_list) RecyclerView rvMovieList;

    @BindView(R.id.toolbar) Toolbar toolbar;

    @BindView(R.id.fab) FloatingActionButton fab;

    private MoviesAdapter moviesAdapter;

    private List<Movie> movieList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this, this);

        setSupportActionBar(toolbar);

        inializeMovieList();

        moviesAdapter = new MoviesAdapter(this, movieList);

        LinearLayoutManager layoutManager =
                new LinearLayoutManager(getApplicationContext(),
                                        LinearLayoutManager.VERTICAL, false);

        rvMovieList.setLayoutManager(layoutManager);

        rvMovieList.setAdapter(moviesAdapter);

    }

    private void inializeMovieList() {
        movieList = new ArrayList<>();

        movieList.add(new Movie(R.drawable.it_poster, "It", "(Drama, Horror, Thriller)", "7.4"));
        movieList.add(new Movie(R.drawable.blade_runner_2049, "Blade Runner 2049", "(Action, Thriller, Science Fiction, Mystery)", "7.5"));
        movieList.add(new Movie(R.drawable.thor, "Thor: Ragnarok", "(Adventure, Fantasy, Action, Science Fiction)", "7.5"));

    }

    public void initHamburger() {
//        final ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.openDrawer, R.string.closeDrawer) {
//            @Override
//            public void onDrawerOpened(View drawerView) {
//                super.onDrawerOpened(drawerView);
//            }
//            @Override
//            public void onDrawerClosed(View drawerView) {
//                super.onDrawerClosed(drawerView);
//            }
//        };
//        //Setting the actionbarToggle to drawer layout
//        mDrawerLayout.addDrawerListener(actionBarDrawerToggle);
//        //calling sync state is necessay or else your hamburger icon wont show up
//        actionBarDrawerToggle.syncState();
    }

    @OnClick(R.id.fab)
    public void onClickFab(View view)
    {
        Snackbar.make(view, "Search function is in progress. Coming soon.", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTapMovieItem() {

    }

    @Override
    public void onTapFavouriteButton() {

    }

    @Override
    public void onTapMovieOverviewButton() {
        Intent intent = new Intent(getApplicationContext(), MoviesDetailsActivity.class);
        startActivity(intent);
    }

    @Override
    public void onTapMaximizeButton() {

    }
}
