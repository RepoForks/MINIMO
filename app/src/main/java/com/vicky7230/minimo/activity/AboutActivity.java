package com.vicky7230.minimo.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.vicky7230.minimo.BuildConfig;
import com.vicky7230.minimo.R;

import de.psdev.licensesdialog.LicensesDialog;
import de.psdev.licensesdialog.licenses.ApacheSoftwareLicense20;
import de.psdev.licensesdialog.model.Notice;
import de.psdev.licensesdialog.model.Notices;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class AboutActivity extends AppCompatActivity {


    private TextView version;
    private TextView libraries;
    private LicensesDialog licensesDialog;

    private Notices notices;

    @Override
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(context));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        init();
    }

    private void init() {

        notices = new Notices();
        notices.addNotice(new Notice("CircleImageView", "https://github.com/hdodenhof/CircleImageView", "Copyright 2014 - 2017 Henning Dodenhof", new ApacheSoftwareLicense20()));
        notices.addNotice(new Notice("Calligraphy", "https://github.com/chrisjenx/Calligraphy", "Copyright 2013 Christopher Jenkins", new ApacheSoftwareLicense20()));
        notices.addNotice(new Notice("android-iconify", "https://github.com/JoanZapata/android-iconify", "Copyright 2015 Joan Zapata", new ApacheSoftwareLicense20()));
        notices.addNotice(new Notice("PhotoView", "https://github.com/chrisbanes/PhotoView", "Copyright 2017 Chris Banes", new ApacheSoftwareLicense20()));
        notices.addNotice(new Notice("glide", "https://github.com/bumptech/glide", "Copyright 2014 Google, Inc. All rights reserved.", new ApacheSoftwareLicense20()));

        licensesDialog = new LicensesDialog.Builder(AboutActivity.this)
                .setTitle("Libraries")
                .setNotices(notices)
                .setIncludeOwnLicense(true)
                .build();

        version = (TextView) findViewById(R.id.version);
        version.setText("MINIMO\nversion : " + BuildConfig.VERSION_NAME);

        libraries = (TextView) findViewById(R.id.libraries);
        libraries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                licensesDialog.show();

            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case android.R.id.home:
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
