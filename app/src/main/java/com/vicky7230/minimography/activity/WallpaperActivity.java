package com.vicky7230.minimography.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Slide;
import android.view.Gravity;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.vicky7230.minimography.R;
import com.vicky7230.minimography.adapter.RecyclerViewAdapter;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;
import uk.co.senab.photoview.PhotoView;

public class WallpaperActivity extends AppCompatActivity {

    private PhotoView photoView;
    private TextView textViewTitle;

    @Override
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(context));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallpaper);

        init();
    }

    private void init() {

        Intent intent = getIntent();

        photoView = (PhotoView) findViewById(R.id.photo_view);

        Glide.
                with(this)
                .load(intent.getStringExtra(RecyclerViewAdapter.IMAGE_URL))
                .crossFade()
                .into(photoView);

        textViewTitle = (TextView) findViewById(R.id.title_bottom);

        textViewTitle.setText(intent.getStringExtra(RecyclerViewAdapter.TITLE));

        Slide slide = new Slide(Gravity.BOTTOM);
        slide.addTarget(R.id.title_bottom);
        slide.setInterpolator(AnimationUtils.loadInterpolator(this, android.R.interpolator.linear_out_slow_in));
        slide.setDuration(500);
        getWindow().setEnterTransition(slide);
    }
}
