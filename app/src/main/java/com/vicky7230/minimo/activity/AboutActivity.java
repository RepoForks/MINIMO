package com.vicky7230.minimo.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.joanzapata.iconify.widget.IconTextView;
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

    private IconTextView facebook;
    private IconTextView github;
    private IconTextView stackOverflow;
    private IconTextView linkedIn;
    private IconTextView mail;

    private HtmlTextView pexels;

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

        facebook = (IconTextView) findViewById(R.id.facebook);
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/vicky1902"));
                startActivity(browserIntent);
            }
        });

        mail = (IconTextView) findViewById(R.id.mail);
        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"vicky7230@gmail.com"});
                email.setType("text/plain");
                startActivity(email);
            }
        });

        github = (IconTextView) findViewById(R.id.github);
        github.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/vicky7230"));
                startActivity(browserIntent);
            }
        });

        stackOverflow = (IconTextView) findViewById(R.id.stack_overflow);
        stackOverflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://stackoverflow.com/users/5031114/vicky"));
                startActivity(browserIntent);
            }
        });

        linkedIn = (IconTextView) findViewById(R.id.linkedin);
        linkedIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/vipin-kumar-ba0540100"));
                startActivity(browserIntent);
            }
        });

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
        fonts.setHtml("Fonts Used : <br><a href=\"https://fonts.google.com/specimen/Josefin+Sans\">JOSEFIN SANS</a><br>Copyright (c) 2010 by Typemade (hi@typemade.mx). All rights reserved.<br>Licensed under the<br><a href=\"http://scripts.sil.org/OFL\">SIL OPEN FONT LICENSE, 1.1</a>");

        pexels = (HtmlTextView) findViewById(R.id.pexels);
        pexels.setHtml("All photos in the app are taken from <br><a href=\"https://www.pexels.com/\">PEXELS.COM</a><br> and are licensed under the <br><a href=\"https://creativecommons.org/publicdomain/zero/1.0/\">CREATIVE COMMONS ZERO (CC0) LICENSE.</a>");
    }

}
