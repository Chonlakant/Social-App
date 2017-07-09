package com.app.sample.social.items.images;


import com.app.sample.social.items.BaseItemModel;

public class ImagesModel implements BaseItemModel {

    public static final int TYPE = 2;
    private final int mID;
    private String urlConntent;
    private String postId;
    private String username;
    private String avatarUrl;
    private boolean isLike;
    private String time;
    private String countLike;
    private int countComment;
    private String cover;
    private String userIds;

    public ImagesModel(int mID, String urlConntent, String postId, String username, String avatarUrl,boolean isLike,String time,String countLike,int countComment,String cover,String userIds) {
        this.mID = mID;

        this.urlConntent = urlConntent;
        this.postId = postId;
        this.username = username;
        this.avatarUrl = avatarUrl;
        this.isLike = isLike;
        this.time = time;
        this.countLike = countLike;
        this.countComment = countComment;
        this.cover = cover;
        this.userIds = userIds;
    }

    @Override
    public int getID() {
        return mID;
    }

    @Override
    public int getType() {
        return TYPE;
    }

    public String getUrlConntent() {
        return urlConntent;
    }

    public void setUrlConntent(String urlConntent) {
        this.urlConntent = urlConntent;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public boolean isLike() {
        return isLike;
    }

    public void setLike(boolean like) {
        isLike = like;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public static int getTYPE() {
        return TYPE;
    }

    public int getmID() {
        return mID;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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

    public String getUserIds() {
        return userIds;
    }

    public void setUserIds(String userIds) {
        this.userIds = userIds;
    }
}
