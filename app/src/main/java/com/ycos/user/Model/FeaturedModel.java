package com.ycos.user.Model;

public class FeaturedModel {

    int image;
    String title;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public FeaturedModel(int image, String title) {
        this.image = image;
        this.title = title;
    }
}
