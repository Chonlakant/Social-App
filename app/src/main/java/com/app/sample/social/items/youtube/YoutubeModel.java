package com.app.sample.social.items.youtube;


import com.app.sample.social.items.BaseItemModel;

public class YoutubeModel implements BaseItemModel {

    public static final int TYPE = 7;
    private final int mID;
    private String urlYoutube;
    private String title;


    String avatar;
    String username;
    String countLike;
    int countComment;
    String cover;
    String userId;
    boolean isLike;
    String postId;
    String time;

    public YoutubeModel(int mID, String urlYoutube, String title, String cover, String avatar, String username, String countLike, int countComment, String userId, boolean isLike, String postId, String time) {
        this.mID = mID;
        this.urlYoutube = urlYoutube;
        this.title = title;
        this.cover = cover;
        this.avatar = avatar;
        this.username = username;
        this.countLike = countLike;
        this.countComment = countComment;
        this.userId = userId;
        this.isLike = isLike;
        this.postId = postId;
        this.time = time;
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

    public static int getTYPE() {
        return TYPE;
    }

    public int getmID() {
        return mID;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
