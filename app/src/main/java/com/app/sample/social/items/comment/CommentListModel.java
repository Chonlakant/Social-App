package com.app.sample.social.items.comment;

import android.support.annotation.NonNull;

import com.app.sample.social.items.BaseItemModel;


public class CommentListModel implements BaseItemModel {

    public boolean isLiked;
    public static final int TYPE = 11;
    private final int mID;
    private String userId;
    private String postId;
    private String text;
    private String timeStamp;

    @NonNull
    private final String countLike;


    public CommentListModel(final int ID, String userId, @NonNull final String countLike, boolean isLiked, String postId, String text, String timeStamp) {
        mID = ID;
        this.countLike = countLike;
        this.userId = userId;
        this.isLiked = isLiked;
        this.postId = postId;
        this.text = text;
        this.timeStamp = timeStamp;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
}
