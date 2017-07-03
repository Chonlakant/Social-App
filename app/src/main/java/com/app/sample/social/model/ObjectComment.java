package com.app.sample.social.model;

/**
 * Created by Bas on 7/3/2017 AD.
 */

public class ObjectComment {

    String name;
    String textComment;
    String avatar;

    public ObjectComment(){

    }

    public ObjectComment(String name, String textComment, String avatar) {
        this.name = name;
        this.textComment = textComment;
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTextComment() {
        return textComment;
    }

    public void setTextComment(String textComment) {
        this.textComment = textComment;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
