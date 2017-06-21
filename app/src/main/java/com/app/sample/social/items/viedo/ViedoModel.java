package com.app.sample.social.items.viedo;


import com.app.sample.social.items.BaseItemModel;

public class ViedoModel implements BaseItemModel {

    public static final int TYPE = 3;
    private final int mID;
    private String urlViedo;
    private String title;


    public ViedoModel(int mID, String urlViedo, String title) {
        this.mID = mID;

        this.urlViedo = urlViedo;
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


    public String getUrlViedo() {
        return urlViedo;
    }

    public void setUrlViedo(String urlViedo) {
        this.urlViedo = urlViedo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
