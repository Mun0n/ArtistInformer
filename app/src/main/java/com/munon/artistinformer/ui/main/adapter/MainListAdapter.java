package com.munon.artistinformer.ui.main.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.munon.artistinformer.R;
import com.munon.artistinformer.common.imageloader.AsyncImageLoader;
import com.munon.artistinformer.model.Artist;

import java.util.List;


public class MainListAdapter extends RecyclerView.Adapter<ViewHolder> {

    private final Context context;
    private final List<Artist> list;
    private final MainListAdapterListener mainListAdapterListener;
    private AsyncImageLoader imageLoader;
    private boolean tableLayout;

    public MainListAdapter(Activity context, List<Artist> list, MainListAdapterListener mainListAdapterListener, boolean tableLayout) {
        this.context = context;
        this.list = list;
        this.mainListAdapterListener = mainListAdapterListener;
        this.tableLayout = tableLayout;

        imageLoader = new AsyncImageLoader(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_mainlist, parent, false);
        return new ViewHolder(v, new ViewHolder.ViewHolderClicks() {
            @Override
            public void onClick(int position) {

            }
        });
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.text.setText(list.get(position).getArtistName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


}
