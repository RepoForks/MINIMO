package com.vicky7230.minimography.adapter;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.Query;
import com.vicky7230.minimography.activity.WallpaperActivity;
import com.vicky7230.minimography.model.Wallpaper;

/**
 * Created by agrim on 27/3/17.
 */

public class RecyclerViewAdapter extends FirebaseRecyclerAdapter<Wallpaper, WallpaperViewHolder> {

    public static final String IMAGE_URL = "url";
    private Context context;

    /**
     * @param modelClass      Firebase will marshall the data at a location into
     *                        an instance of a class that you provide
     * @param modelLayout     This is the layout used to represent a single item in the list.
     *                        You will be responsible for populating an instance of the corresponding
     *                        view with the data from an instance of modelClass.
     * @param viewHolderClass The class that hold references to all sub-views in an instance modelLayout.
     * @param ref             The Firebase location to watch for data changes. Can also be a slice of a location,
     *                        using some combination of {@code limit()}, {@code startAt()}, and {@code endAt()}.
     */
    public RecyclerViewAdapter(Context context, Class<Wallpaper> modelClass, int modelLayout, Class<WallpaperViewHolder> viewHolderClass, Query ref) {
        super(modelClass, modelLayout, viewHolderClass, ref);
        this.context = context;
    }

    @Override
    public WallpaperViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        final WallpaperViewHolder wallpaperViewHolder = super.onCreateViewHolder(parent, viewType);

        wallpaperViewHolder.setOnClickListener(new WallpaperViewHolder.ClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                Bundle bundle = ActivityOptions.makeSceneTransitionAnimation((Activity) context, wallpaperViewHolder.imageView, wallpaperViewHolder.imageView.getTransitionName()).toBundle();

                Intent intent = new Intent(context, WallpaperActivity.class);
                intent.putExtra(IMAGE_URL, getItem(position).getImage());

                context.startActivity(intent, bundle);

            }

            @Override
            public void onItemLongClick(View view, int position) {

            }

        });

        return wallpaperViewHolder;
    }

    @Override
    protected void populateViewHolder(WallpaperViewHolder viewHolder, Wallpaper model, int position) {

        viewHolder.titleTextView.setText(model.getTitle());
        Glide.with(context).load(model.getImage()).into(viewHolder.imageView);

    }

}
