package com.munon.artistinformer.ui.main;

import com.munon.artistinformer.model.Artist;
import java.util.List;

public class MainPresenterImpl implements MainPresenter, OnFinishedListener {

    private MainView mainView;
    private GetArtistInteractor interactor;

    @Override
    public void onResume() {

    }

    @Override
    public void onItemClicked(int position) {

    }

    @Override
    public void onFinished(List<Artist> artists) {

    }
}
