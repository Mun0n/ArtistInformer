package com.munon.artistinformer.model;

import com.google.gson.annotations.SerializedName;
import com.hrules.busline.BusLineEvent;

public class Album extends BusLineEvent{

    @SerializedName("collectionName")
    private String collectionName;
    @SerializedName("artworkUrl100")
    private String artworkUrl100;

    protected Album() {
        super("album");
    }

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
