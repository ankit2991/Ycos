package com.ycos.user.Model;

public class ServiceCentersModel {

    int image1;
    int image2;
    int image3;

    String title1;
    String title2;

    public int getImage1() {
        return image1;
    }

    public void setImage1(int image1) {
        this.image1 = image1;
    }

    public int getImage2() {
        return image2;
    }

    public void setImage2(int image2) {
        this.image2 = image2;
    }

    public int getImage3() {
        return image3;
    }

    public void setImage3(int image3) {
        this.image3 = image3;
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



    public ServiceCentersModel(int image1, int image2, int image3, String title1, String title2) {
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        this.title1 = title1;
        this.title2 = title2;

    }
}
