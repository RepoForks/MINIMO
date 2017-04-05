package com.vicky7230.minimo.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.vicky7230.minimo.BuildConfig;
import com.vicky7230.minimo.R;

import org.sufficientlysecure.htmltextview.HtmlTextView;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class AboutActivity extends AppCompatActivity {


    private TextView version;
    private ImageView back;

    private HtmlTextView circleImageView;
    private HtmlTextView calligraphy;
    private HtmlTextView iconify;
    private HtmlTextView photoView;
    private HtmlTextView glide;
    private HtmlTextView htmlTextView;
    private HtmlTextView fonts;

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

        back = (ImageView) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        version = (TextView) findViewById(R.id.version);
        version.setText("MINIMO\nversion : " + BuildConfig.VERSION_NAME);

        circleImageView = (HtmlTextView) findViewById(R.id.circle_image_view);
        circleImageView.setHtml("<a href=\"https://github.com/hdodenhof/CircleImageView\">hdodenhof/CircleImageView</a>");

        calligraphy = (HtmlTextView) findViewById(R.id.calligraphy);
        calligraphy.setHtml("<a href=\"https://github.com/chrisjenx/Calligraphy\">chrisjenx/Calligraphy</a>");

        iconify = (HtmlTextView) findViewById(R.id.iconify);
        iconify.setHtml("<a href=\"https://github.com/JoanZapata/android-iconify\">JoanZapata/android-iconify</a>");

        photoView = (HtmlTextView) findViewById(R.id.photo_view);
        photoView.setHtml("<a href=\"https://github.com/chrisbanes/PhotoView\">chrisbanes/PhotoView</a>");

        glide = (HtmlTextView) findViewById(R.id.glide);
        glide.setHtml("<a href=\"https://github.com/bumptech/glide\">bumptech/glide</a>");

        htmlTextView = (HtmlTextView) findViewById(R.id.html_text_view);
        htmlTextView.setHtml("<a href=\"https://github.com/SufficientlySecure/html-textview\">SufficientlySecure/html-textview</a>");

        fonts = (HtmlTextView) findViewById(R.id.fonts);
        fonts.setHtml("<a href=\"https://fonts.google.com/specimen/Josefin+Sans\">Fonts Used : Josefin Sans</a>");

    }

}
