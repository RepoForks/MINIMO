package com.vicky7230.minimo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.vicky7230.minimo.R;

/**
 * Created by agrim on 28/3/17.
 */

public class WallpaperViewHolder extends RecyclerView.ViewHolder {

    public TextView titleTextView;
    public ImageView imageView;

    public WallpaperViewHolder(View itemView) {
        super(itemView);

        titleTextView = (TextView) itemView.findViewById(R.id.title);
        imageView = (ImageView) itemView.findViewById(R.id.image);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mClickListener.onItemClick(v, getAdapterPosition());

            }
        });
    }

    //Interface to send callbacks...
    public interface ClickListener {
        public void onItemClick(View view, int position);

        public void onItemLongClick(View view, int position);
    }

    private WallpaperViewHolder.ClickListener mClickListener;

    public void setOnClickListener(WallpaperViewHolder.ClickListener clickListener) {
        mClickListener = clickListener;
    }
}
