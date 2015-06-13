package com.munon.artistinformer.ui.albums;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.munon.artistinformer.R;
import com.munon.artistinformer.ui.BaseActivity;

public class AlbumsActivity extends BaseActivity{

    public static final String ALBUM_DATA = "albums";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
}
