package com.munon.artistinformer.ui;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.munon.artistinformer.R;


public abstract class BaseActivity extends ActionBarActivity {

    @InjectView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResource());
        ButterKnife.inject(this);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle(getActivityTitle());
            getSupportActionBar().setDisplayHomeAsUpEnabled(getActivityHomeAsUpEnabled());
        }
    }

    protected abstract int getLayoutResource();

    protected abstract String getActivityTitle();

    protected abstract boolean getActivityHomeAsUpEnabled();
}