package com.app.sample.social.items.comment;

import android.support.annotation.NonNull;

import com.app.sample.social.items.BaseItemModel;
import com.app.sample.social.model.Feed;

import java.util.ArrayList;
import java.util.List;


public class CommentListModel implements BaseItemModel {


    public static final int TYPE = 11;
    private final int mID;

    private List<Feed.PostsBean.GetPostCommentsBean> commentLists ;

    public CommentListModel(final int ID, List<Feed.PostsBean.GetPostCommentsBean> commentLists) {
        mID = ID;


        this.commentLists = commentLists;
    }

    @Override
    public int getID() {
        return mID;
    }

    @Override
    public int getType() {
        return TYPE;
    }


    public static int getTYPE() {
        return TYPE;
    }

    public int getmID() {
        return mID;
    }

    public List<Feed.PostsBean.GetPostCommentsBean> getCommentLists() {
        return commentLists;
    }

    public void setCommentLists(ArrayList<Feed.PostsBean.GetPostCommentsBean> commentLists) {
        this.commentLists = commentLists;
    }
}
