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
    private int countComment;


    public CommentModel(final int ID, @NonNull final String countLike,boolean isLiked,String postId,int countComment) {
        mID = ID;
        this.countLike = countLike;
       this.isLiked = isLiked;
        this.postId = postId;
        this.countComment = countComment;
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

    public int getCountComment() {
        return countComment;
    }

    public void setCountComment(int countComment) {
        this.countComment = countComment;
    }
}
