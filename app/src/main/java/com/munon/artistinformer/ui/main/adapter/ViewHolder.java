package com.munon.artistinformer.ui.main.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.munon.artistinformer.R;

public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public final TextView text;
    public final ViewHolderClicks viewHolderClicks;

    public ViewHolder(View itemView, ViewHolderClicks viewHolderClicks) {
        super(itemView);

        text = (TextView) itemView.findViewById(R.id.text);

        itemView.setOnClickListener(this);
        this.viewHolderClicks = viewHolderClicks;
    }

    @Override
    public void onClick(View v) {
        viewHolderClicks.onClick(getAdapterPosition());
    }

    public static interface ViewHolderClicks {
        public void onClick(int position);
    }
}
