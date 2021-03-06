package com.app.sample.social.model;

/**
 * Created by Bas on 7/7/2017 AD.
 */

public class ObjectImage {
    String timeStamp;
    String postId;
    String image;
    String avatar;
    String username;
    String countLike;
    int countComment;
    String cover;
    String userId;
    boolean isLike;

    public ObjectImage(){

    }

    public ObjectImage(String timeStamp, String postId, String image, String avatar, String username, boolean isLike, String countLike, int countComment,String cover, String userId) {
        this.timeStamp = timeStamp;
        this.postId = postId;
        this.image = image;
        this.avatar = avatar;
        this.username = username;
        this.isLike = isLike;
        this.countLike = countLike;
        this.countComment = countComment;
        this.cover = cover;
        this.userId = userId;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isLike() {
        return isLike;
    }

    public void setLike(boolean like) {
        isLike = like;
    }

    public String getCountLike() {
        return countLike;
    }

    public void setCountLike(String countLike) {
        this.countLike = countLike;
    }

    public int getCountComment() {
        return countComment;
    }

    public void setCountComment(int countComment) {
        this.countComment = countComment;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
