package com.vicky7230.minimo.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.joanzapata.iconify.widget.IconTextView;
import com.vicky7230.minimo.R;
import com.vicky7230.minimo.adapter.RecyclerViewAdapter;
import com.vicky7230.minimo.fragment.WallpaperFragment;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;
import uk.co.senab.photoview.PhotoView;

public class WallpaperActivity extends AppCompatActivity {

    private static final String FRAG_TAG_WALLPAPER_FRAGMENT = "wallpaperFragment";
    private PhotoView photoView;
    private TextView textViewTitle;
    Intent intent;

    private IconTextView downArrow;

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

        intent = getIntent();

        downArrow = (IconTextView) findViewById(R.id.down_arrow);
        downArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager fragmentManager = getSupportFragmentManager();
                WallpaperFragment wallpaperFragment = new WallpaperFragment();

                Bundle bundle = new Bundle();
                bundle.putString(RecyclerViewAdapter.IMAGE_URL, intent.getStringExtra(RecyclerViewAdapter.IMAGE_URL));
                wallpaperFragment.setArguments(bundle);
                wallpaperFragment.show(fragmentManager, FRAG_TAG_WALLPAPER_FRAGMENT);
            }
        });

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
