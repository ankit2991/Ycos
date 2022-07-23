package com.ycos.user.Model;

public class CategoryModel {

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

    public CategoryModel(int image, String title) {
        this.image = image;
        this.title = title;
    }
}
