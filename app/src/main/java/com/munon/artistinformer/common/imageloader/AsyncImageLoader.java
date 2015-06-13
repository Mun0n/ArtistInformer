package com.munon.artistinformer.common.imageloader;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class AsyncImageLoader implements ImageLoader {
    private Context context;

    public AsyncImageLoader(Context context) {
        this.context = context;
    }

    @Override
    public void load(String imageUrl, ImageView dest) {
        Picasso.with(context).load(imageUrl).into(dest);
    }

    @Override
    public void load(String imageUrl, ImageView dest, Callback callback) {
        Picasso.with(context).load(imageUrl).into(dest, callback);
    }
}
