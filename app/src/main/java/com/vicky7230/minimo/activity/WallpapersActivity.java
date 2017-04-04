package com.vicky7230.minimo.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.joanzapata.iconify.widget.IconTextView;
import com.vicky7230.minimo.R;
import com.vicky7230.minimo.adapter.RecyclerViewAdapter;
import com.vicky7230.minimo.adapter.WallpaperViewHolder;
import com.vicky7230.minimo.model.Wallpaper;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class WallpapersActivity extends AppCompatActivity {

    public static final String DATA = "Data";

    private RecyclerView wallpapersRecyclerView;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    private RecyclerViewAdapter recyclerViewAdapter;

    private IconTextView gear;

    private ProgressBar progressBar;

    @Override
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(context));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallpapers);

        init();
    }

    private void init() {

        progressBar = (ProgressBar) findViewById(R.id.progressBar3);

        gear = (IconTextView) findViewById(R.id.gear);
        gear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WallpapersActivity.this, AboutActivity.class));
            }
        });

        wallpapersRecyclerView = (RecyclerView) findViewById(R.id.wallpapers);
        wallpapersRecyclerView.setHasFixedSize(true);
        wallpapersRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference(DATA);

        recyclerViewAdapter = new RecyclerViewAdapter(WallpapersActivity.this, Wallpaper.class, R.layout.wallpaper, WallpaperViewHolder.class, databaseReference);

        wallpapersRecyclerView.setAdapter(recyclerViewAdapter);

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                progressBar.setVisibility(View.GONE);
                wallpapersRecyclerView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}
