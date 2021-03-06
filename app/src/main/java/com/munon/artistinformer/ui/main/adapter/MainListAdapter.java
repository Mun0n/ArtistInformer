package com.munon.artistinformer.ui.main.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.munon.artistinformer.R;
import com.munon.artistinformer.common.imageloader.AsyncImageLoader;
import com.munon.artistinformer.model.Artist;
import com.squareup.picasso.Callback;

import java.util.List;


public class MainListAdapter extends RecyclerView.Adapter<MainListAdapter.ViewHolder> {

    private final Context context;
    private final List<Artist> list;
    private final MainListAdapterListener mainListAdapterListener;
    private boolean tabletLayout;
    private AsyncImageLoader imageLoader;

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView text;
        public final ImageView image;
        private MainListAdapterListener mainListAdapterListener;

        public ViewHolder(View itemView, MainListAdapterListener mainListAdapterListener) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.text);
            image = (ImageView) itemView.findViewById(R.id.artistImage);
            itemView.setOnClickListener(this);
            this.mainListAdapterListener = mainListAdapterListener;
        }

        @Override
        public void onClick(View v) {
            mainListAdapterListener.onClick(getAdapterPosition());
        }

        public static interface ViewHolderClicks {
            public void onClick(int position);
        }
    }

    public MainListAdapter(Activity context, List<Artist> list, MainListAdapterListener mainListAdapterListener, boolean tabletLayout) {
        this.context = context;
        this.list = list;
        this.mainListAdapterListener = mainListAdapterListener;
        this.tabletLayout = tabletLayout;

        imageLoader = new AsyncImageLoader(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_mainlist, parent, false);
        return new ViewHolder(v, mainListAdapterListener);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.text.setText(list.get(position).getArtistName());
        imageLoader.load(list.get(position).getAlbums()[0].getArtworkUrl100(), holder.image, new Callback() {
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
        return list.size();
    }


}
