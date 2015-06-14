package com.munon.artistinformer.ui.main;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.hrules.busline.BusLine;
import com.munon.artistinformer.R;
import com.munon.artistinformer.model.Artist;
import com.munon.artistinformer.ui.BaseActivity;
import com.munon.artistinformer.ui.albums.AlbumsActivity;
import com.munon.artistinformer.ui.albums.AlbumsFragment;
import com.munon.artistinformer.ui.main.events.MainListBusLineEvent;
import com.munon.artistinformer.ui.main.presenter.MainPresenter;
import com.munon.artistinformer.ui.main.presenter.MainPresenterImpl;

import java.util.List;


public class MainActivity extends BaseActivity implements MainView, MainFragment.Listener {

    private static boolean tabletLayout;
    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        tabletLayout = getResources().getBoolean(R.bool.tablet);
        presenter = new MainPresenterImpl(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_main;
    }

    @Override
    protected String getActivityTitle() {
        return getString(R.string.app_name);
    }

    @Override
    protected boolean getActivityHomeAsUpEnabled() {
        return false;
    }

    @Override
    public void showProgress() {
        BusLine.with(this).send(new MainListBusLineEvent(MainListBusLineEvent.ACTION_SHOW_PROGRESS));
    }

    @Override
    public void setItems(List<Artist> items) {
        if (items != null && items.size() > 0) {
            BusLine.with(this).send(new MainListBusLineEvent(MainListBusLineEvent.ACTION_SHOW_LIST, items));
        } else {
            BusLine.with(this).send(new MainListBusLineEvent(MainListBusLineEvent.ACTION_SHOW_TEXT));
        }
    }

    @Override
    public void showMessage(String message) {
        BusLine.with(this).send(new MainListBusLineEvent(MainListBusLineEvent.ACTION_SHOW_TEXT));
    }

    @Override
    public void onItemSelected(Artist artistData) {
        if (tabletLayout) {
            findViewById(R.id.iconEmpty).setVisibility(View.GONE);
            Bundle arguments = new Bundle();
            arguments.putSerializable(AlbumsFragment.ALBUM_DATA, artistData);
            AlbumsFragment fragment = new AlbumsFragment();
            fragment.setArguments(arguments);
            getFragmentManager().beginTransaction()
                    .replace(R.id.albums_container, fragment)
                    .commit();

        } else {
            Intent albumsIntent = new Intent(this, AlbumsActivity.class);
            albumsIntent.putExtra(AlbumsFragment.ALBUM_DATA, artistData);
            startActivity(albumsIntent);
        }
    }

    public boolean isTabletLayout() {
        return tabletLayout;
    }
}
