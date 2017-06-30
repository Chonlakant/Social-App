package com.app.sample.social.items.images;


import com.app.sample.social.items.BaseItemModel;

public class ImagesModel implements BaseItemModel {

    public static final int TYPE = 2;
    private final int mID;
    private String urlAvatra;
    private String postId;


    public ImagesModel(int mID, String urlAvatra,String postId) {
        this.mID = mID;

        this.urlAvatra = urlAvatra;
        this.postId = postId;

    }

    @Override
    public int getID() {
        return mID;
    }

    @Override
    public int getType() {
        return TYPE;
    }


    public String getUrlAvatra() {
        return urlAvatra;
    }

    public void setUrlAvatra(String urlAvatra) {
        this.urlAvatra = urlAvatra;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }
}
