package com.app.sample.social.model;

/**
 * Created by Bas on 6/16/2017 AD.
 */

public class PostLike {

    /**
     * status : 300
     * likes : 0
     * like_lang : ชอบ
     * dislike : 1
     * default_lang_like : ชอบ
     * default_lang_dislike : ไม่ชอบ
     */

    private int status;
    private String likes;
    private String like_lang;
    private int dislike;
    private String default_lang_like;
    private String default_lang_dislike;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getLike_lang() {
        return like_lang;
    }

    public void setLike_lang(String like_lang) {
        this.like_lang = like_lang;
    }

    public int getDislike() {
        return dislike;
    }

    public void setDislike(int dislike) {
        this.dislike = dislike;
    }

    public String getDefault_lang_like() {
        return default_lang_like;
    }

    public void setDefault_lang_like(String default_lang_like) {
        this.default_lang_like = default_lang_like;
    }

    public String getDefault_lang_dislike() {
        return default_lang_dislike;
    }

    public void setDefault_lang_dislike(String default_lang_dislike) {
        this.default_lang_dislike = default_lang_dislike;
    }
}
