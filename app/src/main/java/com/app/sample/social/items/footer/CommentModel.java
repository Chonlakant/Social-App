package com.app.sample.social.items.footer;

import android.support.annotation.NonNull;

import com.app.sample.social.items.BaseItemModel;


public class CommentModel implements BaseItemModel {

    public boolean isLiked;
    public static final int TYPE = 10;
    private final int mID;
    @NonNull
    private final String countLike;
    private String postId;

    public CommentModel(final int ID, @NonNull final String countLike,boolean isLiked,String postId) {
        mID = ID;
        this.countLike = countLike;
       this.isLiked = isLiked;
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

    @NonNull
    public String getCountLike() {
        return countLike;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }
}
