package com.vicky7230.minimography.model;

/**
 * Created by agrim on 27/3/17.
 */

public class Wallpaper {

    private String title;
    private String image;

    public Wallpaper(String title, String image) {
        this.title = title;
        this.image = image;
    }

    public Wallpaper() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
