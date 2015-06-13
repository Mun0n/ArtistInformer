package com.munon.artistinformer.ui.main;

import com.munon.artistinformer.model.Artist;
import java.util.List;

public interface OnFinishedListener {

    void onFinished(List<Artist> artists);

    void OnError();

}
