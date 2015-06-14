package com.munon.artistinformer.ui.main.presenter;

import android.content.Context;

import com.munon.artistinformer.R;
import com.munon.artistinformer.model.Artist;
import com.munon.artistinformer.ui.main.MainView;
import com.munon.artistinformer.ui.main.OnFinishedListener;
import com.munon.artistinformer.ui.main.interactor.GetArtistInteractor;
import com.munon.artistinformer.ui.main.interactor.GetArtistInteractorImpl;

import java.util.List;

public class MainPresenterImpl implements MainPresenter, OnFinishedListener {

    private MainView mainView;
    private GetArtistInteractor interactor;
    private Context context;

    public MainPresenterImpl(Context context) {
        this.mainView = (MainView) context;
        this.context = context;
        interactor = new GetArtistInteractorImpl(context);
    }

    @Override
    public void onResume() {
        mainView.showProgress();
        interactor.findArtist(this);
    }

    @Override
    public void onItemClicked(int position) {

    }

    @Override
    public void onFinished(List<Artist> artists) {
        if (artists != null && artists.size() > 0) {
            mainView.setItems(artists);
        } else {
            mainView.showMessage(context.getString(R.string.not_found));
        }
    }

    @Override
    public void OnError() {
        mainView.showMessage(context.getString(R.string.not_found));
    }
}
