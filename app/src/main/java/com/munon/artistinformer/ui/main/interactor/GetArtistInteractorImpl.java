package com.munon.artistinformer.ui.main.interactor;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.munon.artistinformer.R;
import com.munon.artistinformer.model.Album;
import com.munon.artistinformer.model.Artist;
import com.munon.artistinformer.model.ConverterObject;
import com.munon.artistinformer.ui.main.OnFinishedListener;

import java.util.ArrayList;
import java.util.List;

public class GetArtistInteractorImpl implements GetArtistInteractor {

    private Context context;
    private List<Artist> artists;

    public GetArtistInteractorImpl(Context context) {
        this.context = context;
    }

    @Override
    public void findArtist(final OnFinishedListener listener) {
        artists = new ArrayList<Artist>();
        Ion.with(context).load(context.getString(R.string.artist_1)).asJsonObject().setCallback(new FutureCallback<JsonObject>() {
            @Override
            public void onCompleted(Exception e, JsonObject result) {
                if (e == null) {
                    parseJsonData(result);
                    Ion.with(context).load(context.getString(R.string.artist_2)).asJsonObject().setCallback(new FutureCallback<JsonObject>() {
                        @Override
                        public void onCompleted(Exception e, JsonObject result) {
                            if (e == null) {
                                parseJsonData(result);
                                Ion.with(context).load(context.getString(R.string.artist_3)).asJsonObject().setCallback(new FutureCallback<JsonObject>() {
                                    @Override
                                    public void onCompleted(Exception e, JsonObject result) {
                                        if (e == null) {
                                            parseJsonData(result);
                                            listener.onFinished(artists);
                                        } else {
                                            listener.OnError();
                                        }
                                    }
                                });
                            } else {
                                listener.OnError();
                            }
                        }
                    });
                } else {
                    listener.OnError();
                }
            }
        });


    }

    private void parseJsonData(JsonObject result) {
        ConverterObject resultGenericObject = new ConverterObject();
        Gson gson = new Gson();
        JsonArray arrayResult = result.getAsJsonArray("results");
        for (int i = 0; i < arrayResult.size(); i++) {
            JsonElement element = arrayResult.get(i);
            ConverterObject g = gson.fromJson(element, ConverterObject.class);
            if (g.getWrapperType().equalsIgnoreCase("artist")) {
                resultGenericObject.setArtist(gson.fromJson(element, Artist.class));
                Album[] albums = new Album[arrayResult.size() - 1];
                resultGenericObject.getArtist().setAlbums(albums);
            } else {
                Album a = gson.fromJson(element, Album.class);
                resultGenericObject.getArtist().getAlbums()[i - 1] = a;
            }
        }
        artists.add(resultGenericObject.getArtist());
    }
}
