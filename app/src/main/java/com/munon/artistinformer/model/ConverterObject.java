package com.munon.artistinformer.model;

import android.os.Parcel;

import com.google.gson.annotations.SerializedName;

public class ConverterObject {

    @SerializedName("wrapperType")
    private String wrapperType;
    private Artist artist;

    public ConverterObject() {
        artist = new Artist();
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public String getWrapperType() {
        return wrapperType;
    }

    public void setWrapperType(String wrapperType) {
        this.wrapperType = wrapperType;
    }
}
