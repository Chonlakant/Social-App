package com.app.sample.social.items.image_mutiple;


import com.app.sample.social.items.BaseItemModel;

public class ImagesMutiModel implements BaseItemModel {

    public static final int TYPE = 22;
    private final int mID;
    private String urlAvatra;
    private String postId;


    public ImagesMutiModel(int mID, String urlAvatra, String postId) {
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
