package com.munon.artistinformer.ui.albums.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.munon.artistinformer.R;
import com.munon.artistinformer.common.imageloader.AsyncImageLoader;
import com.munon.artistinformer.model.Album;
import com.squareup.picasso.Callback;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder> {

    private Context context;
    private Album[] albums;
    private AsyncImageLoader imageLoader;

    public AlbumAdapter(Context context, Album[] albums) {
        this.context = context;
        this.albums = albums;

        imageLoader = new AsyncImageLoader(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_album, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.title.setText(albums[position].getCollectionName());
        imageLoader.load(albums[position].getArtworkUrl100(), holder.icon, new Callback() {
            @Override
            public void onSuccess() {
            }

            @Override
            public void onError() {
            }
        });
    }

    @Override
    public int getItemCount() {
        return albums.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final CardView root;
        public final TextView title;
        public final ImageView icon;

        public ViewHolder(View itemView) {
            super(itemView);

            root = (CardView) itemView.findViewById(R.id.root);
            icon = (ImageView) itemView.findViewById(R.id.icon);
            title = (TextView) itemView.findViewById(R.id.title);
        }
    }
}
