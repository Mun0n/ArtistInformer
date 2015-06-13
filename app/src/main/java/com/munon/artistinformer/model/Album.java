package com.munon.artistinformer.model;

import com.google.gson.annotations.SerializedName;

public class Album {

    @SerializedName("collectionName")
    private String collectionName;
    @SerializedName("artworkUrl100")
    private String artworkUrl100;

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public String getArtworkUrl100() {
        return artworkUrl100;
    }

    public void setArtworkUrl100(String artworkUrl100) {
        this.artworkUrl100 = artworkUrl100;
    }
}
