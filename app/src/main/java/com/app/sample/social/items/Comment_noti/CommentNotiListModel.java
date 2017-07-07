package com.app.sample.social.items.Comment_noti;

import com.app.sample.social.items.BaseItemModel;
import com.app.sample.social.model.Feed;
import com.app.sample.social.model.GetPostId;

import java.util.ArrayList;
import java.util.List;


public class CommentNotiListModel implements BaseItemModel {


    public static final int TYPE = 11;
    private final int mID;


    private List<GetPostId.PostDataBean.GetPostCommentsBean> commentLists ;

    public CommentNotiListModel(final int ID, List<GetPostId.PostDataBean.GetPostCommentsBean> commentLists) {
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

    public List<GetPostId.PostDataBean.GetPostCommentsBean> getCommentLists() {
        return commentLists;
    }

    public void setCommentLists(ArrayList<GetPostId.PostDataBean.GetPostCommentsBean> commentLists) {
        this.commentLists = commentLists;
    }
}
