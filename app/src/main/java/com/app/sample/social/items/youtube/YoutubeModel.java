package com.app.sample.social.items.youtube;


import com.app.sample.social.items.BaseItemModel;

public class YoutubeModel implements BaseItemModel {

    public static final int TYPE = 7;
    private final int mID;
    private String urlYoutube;
    private String title;
    private String cover;


    public YoutubeModel(int mID, String urlYoutube, String title, String cover) {
        this.mID = mID;
        this.urlYoutube = urlYoutube;
        this.title = title;
        this.cover = cover;
    }

    @Override
    public int getID() {
        return mID;
    }

    @Override
    public int getType() {
        return TYPE;
    }


    public String getUrlYoutube() {
        return urlYoutube;
    }

    public void setUrlYoutube(String urlYoutube) {
        this.urlYoutube = urlYoutube;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }
}
