package com.munon.artistinformer.model;

import com.google.gson.annotations.SerializedName;
import com.hrules.busline.BusLineEvent;

import java.util.ArrayList;

public class Artist{

    @SerializedName("artistName")
    private String artistName;
    private ArrayList<Album> albums;

    public Artist() {
        albums = new ArrayList<Album>();
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public ArrayList<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(ArrayList<Album> albums) {
        this.albums = albums;
    }
}
