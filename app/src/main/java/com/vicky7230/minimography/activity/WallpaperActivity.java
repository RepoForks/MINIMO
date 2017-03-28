package com.vicky7230.minimography.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.vicky7230.minimography.R;
import com.vicky7230.minimography.adapter.RecyclerViewAdapter;

import uk.co.senab.photoview.PhotoView;

public class WallpaperActivity extends AppCompatActivity {

    private PhotoView photoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallpaper);

        init();
    }

    private void init() {

        Intent intent = getIntent();

        photoView = (PhotoView) findViewById(R.id.photo_view);

        Glide.with(this).load(intent.getStringExtra(RecyclerViewAdapter.IMAGE_URL)).into(photoView);
    }
}
