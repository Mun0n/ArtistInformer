package com.munon.artistinformer.ui.main;

import com.munon.artistinformer.model.Artist;

import java.util.List;

public interface MainView {

    void showProgress();

    void setItems(List<Artist> items);

    void showMessage(String message);

}
