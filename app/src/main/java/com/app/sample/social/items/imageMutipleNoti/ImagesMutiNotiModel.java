package com.app.sample.social.items.imageMutipleNoti;


import com.app.sample.social.items.BaseItemModel;
import com.app.sample.social.model.Feed;
import com.app.sample.social.model.GetPostId;

import java.util.ArrayList;
import java.util.List;

public class ImagesMutiNotiModel implements BaseItemModel {

    public static final int TYPE = 22;
    private final int mID;
    private String urlAvatra;
    private String postId;
    private String textContent;
    private List<GetPostId.PostDataBean.PhotoMultiBean> list = new ArrayList<>();

    public ImagesMutiNotiModel(int mID, String urlAvatra, String postId, List<GetPostId.PostDataBean.PhotoMultiBean> list, String textContent) {
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

    public List<GetPostId.PostDataBean.PhotoMultiBean> getList() {
        return list;
    }

    public void setList(List<GetPostId.PostDataBean.PhotoMultiBean> list) {
        this.list = list;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }
}
