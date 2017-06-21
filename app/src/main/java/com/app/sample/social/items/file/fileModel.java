package com.app.sample.social.items.file;


import com.app.sample.social.items.BaseItemModel;

public class fileModel implements BaseItemModel {

    public static final int TYPE = 4;
    private final int mID;
    private String urlfifle;
    private String title;


    public fileModel(int mID, String urlfifle, String title) {
        this.mID = mID;

        this.urlfifle = urlfifle;
        this.title = title;

    }

    @Override
    public int getID() {
        return mID;
    }

    @Override
    public int getType() {
        return TYPE;
    }


    public String getUrlfifle() {
        return urlfifle;
    }

    public void setUrlfifle(String urlfifle) {
        this.urlfifle = urlfifle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
