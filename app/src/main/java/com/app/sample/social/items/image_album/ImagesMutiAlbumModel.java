package com.app.sample.social.items.image_album;


import com.app.sample.social.items.BaseItemModel;
import com.app.sample.social.model.Feed;
import com.app.sample.social.model.GetPostId;

import java.util.ArrayList;
import java.util.List;

public class ImagesMutiAlbumModel implements BaseItemModel {

    public static final int TYPE = 21;
    private final int mID;
    private String urlAvatra;
    private String postId;
    private String textContent;
    private List<Feed.PostsBean.Album> list = new ArrayList<>();

    public ImagesMutiAlbumModel(int mID, String urlAvatra, String postId, List<Feed.PostsBean.Album> list, String textContent) {
        this.mID = mID;

        this.urlAvatra = urlAvatra;
        this.postId = postId;
        this.list = list;
        this.textContent = textContent;

    }

    @Override
    public int getID() {
        return mID;
    }

    @Override
    public int getType() {
        return TYPE;
    }


    public String getUrlAvatra() {
        return urlAvatra;
    }

    public void setUrlAvatra(String urlAvatra) {
        this.urlAvatra = urlAvatra;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public List<Feed.PostsBean.Album> getList() {
        return list;
    }

    public void setList(List<Feed.PostsBean.Album> list) {
        this.list = list;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }
}
