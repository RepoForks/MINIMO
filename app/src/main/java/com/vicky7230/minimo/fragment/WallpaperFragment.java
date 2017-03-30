package com.vicky7230.minimo.fragment;


import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.vicky7230.minimo.R;
import com.vicky7230.minimo.adapter.RecyclerViewAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class WallpaperFragment extends DialogFragment {

    private ImageView imageView;


    public WallpaperFragment() {
        // Required empty public constructor
    }


    @Override
    public void onResume() {
        super.onResume();
        int width = getResources().getDimensionPixelSize(R.dimen.dialog_width);
        int height = getResources().getDimensionPixelSize(R.dimen.dialog_height);
        getDialog().getWindow().setLayout(width, height);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //((SellerHomeActivity) getActivity()).enableDisableDrawer(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        //((SellerHomeActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        return inflater.inflate(R.layout.fragment_wallpaper, container, false);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Dialog dialog = super.onCreateDialog(savedInstanceState);
        // request a window without the title
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        return dialog;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        imageView = (ImageView) getView().findViewById(R.id.wallpaper_diag);

        Bundle bundle = this.getArguments();
        if (bundle != null) {

            Glide.
                    with(this)
                    .load(bundle.getString(RecyclerViewAdapter.IMAGE_URL))
                    .crossFade()
                    .into(imageView);

            Toast.makeText(getActivity(), "Loading......", Toast.LENGTH_SHORT).show();

        }


    }

}

