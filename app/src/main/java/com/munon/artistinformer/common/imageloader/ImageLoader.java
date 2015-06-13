package com.munon.artistinformer.common.imageloader;

import android.widget.ImageView;

import com.squareup.picasso.Callback;

interface ImageLoader {
    void load(String imageUrl, ImageView dest);

    void load(String imageUrl, ImageView dest, Callback callback);
}
