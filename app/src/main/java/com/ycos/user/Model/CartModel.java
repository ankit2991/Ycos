package com.ycos.user.Model;

public class CartModel {

    int image;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle1() {
        return title1;
    }

    public void setTitle1(String title1) {
        this.title1 = title1;
    }

    public String getTitle2() {
        return title2;
    }

    public void setTitle2(String title2) {
        this.title2 = title2;
    }

    public String getTitle3() {
        return title3;
    }

    public void setTitle3(String title3) {
        this.title3 = title3;
    }

    public CartModel(int image, String title1, String title2, String title3) {
        this.image = image;
        this.title1 = title1;
        this.title2 = title2;
        this.title3 = title3;
    }

    String title1;
    String title2;
    String title3;

}
