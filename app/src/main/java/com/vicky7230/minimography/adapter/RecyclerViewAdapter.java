package com.vicky7230.minimography.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.Query;
import com.vicky7230.minimography.R;
import com.vicky7230.minimography.model.Wallpaper;

/**
 * Created by agrim on 27/3/17.
 */

public class RecyclerViewAdapter extends FirebaseRecyclerAdapter<Wallpaper, RecyclerViewAdapter.WallpaperViewHolder> {

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
    protected void populateViewHolder(WallpaperViewHolder viewHolder, Wallpaper model, int position) {

        viewHolder.setTitle(model.getTitle());
        viewHolder.setImage(context, model.getImage());

    }

    public static class WallpaperViewHolder extends RecyclerView.ViewHolder {

        View view;

        public WallpaperViewHolder(View itemView) {

            super(itemView);

            view = itemView;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                }
            });
        }

        public void setTitle(String title) {
            TextView titleTextView = (TextView) view.findViewById(R.id.title);
            titleTextView.setText(title);
        }

        public void setImage(Context ctx, String image) {
            ImageView imageView = (ImageView) view.findViewById(R.id.image);
            // We Need TO pass Context
            Glide.with(ctx).load(image).into(imageView);
        }
    }
}
