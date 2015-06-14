package com.munon.artistinformer.ui.albums;

import android.os.Bundle;
import android.view.MenuItem;

import com.munon.artistinformer.R;
import com.munon.artistinformer.model.Artist;
import com.munon.artistinformer.ui.BaseActivity;

import java.io.Serializable;

public class AlbumsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            Bundle arguments = new Bundle();
            Artist s = (Artist) getIntent().getSerializableExtra(AlbumsFragment.ALBUM_DATA);
            getSupportActionBar().setTitle(s.getArtistName());
            arguments.putSerializable(AlbumsFragment.ALBUM_DATA, getIntent().getSerializableExtra(AlbumsFragment.ALBUM_DATA));
            AlbumsFragment fragment = new AlbumsFragment();
            fragment.setArguments(arguments);
            getFragmentManager().beginTransaction()
                    .add(R.id.albums_container, fragment)
                    .commit();

        }

    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_albums;
    }

    @Override
    protected String getActivityTitle() {
        return null;
    }

    @Override
    protected boolean getActivityHomeAsUpEnabled() {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
