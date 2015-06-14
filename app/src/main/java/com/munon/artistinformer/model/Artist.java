package com.munon.artistinformer.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;
import com.hrules.busline.BusLineEvent;
import com.hrules.busline.BusLineListener;

import java.io.Serializable;
import java.util.ArrayList;

public class Artist extends BusLineEvent {

    @SerializedName("artistName")
    private String artistName;
    private Album[] albums;

    public Artist() {
        super("action");
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public Album[] getAlbums() {
        return albums;
    }

    public void setAlbums(Album[] albums) {
        this.albums = albums;
    }


}
