package com.app.sample.social.items.viedo;


import com.app.sample.social.items.BaseItemModel;

public class ViedoModel implements BaseItemModel {

    public static final int TYPE = 3;
    private final int mID;
    private String urlViedo;
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


    public ViedoModel(int mID, String urlViedo, String title, String avatar, String username, String countLike, int countComment, String cover, String userId, boolean isLike, String postId,String time) {
        this.mID = mID;
        this.urlViedo = urlViedo;
        this.title = title;
        this.avatar = avatar;
        this.username = username;
        this.countLike = countLike;
        this.countComment = countComment;
        this.cover = cover;
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
