package com.app.sample.social.model;

import android.util.Log;

/**
 * Created by Bas on 7/5/2017 AD.
 */

public class FilterComment {

    String txet;
    String userName;
    String avatar;
    String postId;

    public  FilterComment(){

    }

    public FilterComment(String txet, String userName, String avatar, String postId) {
        this.txet = txet;
        this.userName = userName;
        this.avatar = avatar;
        this.postId = postId;
    }

    public String getTxet() {
        return txet;
    }

    public void setTxet(String txet) {
        this.txet = txet;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }
}
