package com.app.sample.social.items.Comment_noti;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.view.ViewGroup;

import com.app.sample.social.R;
import com.app.sample.social.adapter.CommentListAdapter;
import com.app.sample.social.items.comment.CommentListModel;
import com.app.sample.social.items.comment.CommentListViewHolder;
import com.app.sample.social.model.FilterComment;
import com.github.vivchar.rendererrecyclerviewadapter.ViewRenderer;

import java.util.ArrayList;
import java.util.List;

public class CommentListNotiViewRenderer extends ViewRenderer<CommentNotiListModel, CommentNotiListViewHolder> {

    boolean isPressed = false;
    int status = 0;

    CommentNotiListAdapter commentListAdapter;

    ArrayList<FilterComment> list =new ArrayList<>();

    @NonNull
    private final Listener mListener;


    public CommentListNotiViewRenderer(final int type, final Context context, @NonNull final Listener listener) {
        super(type, context);
        mListener = listener;

    }

    @Override
    public void bindView(final CommentNotiListModel item, final CommentNotiListViewHolder holder, final List payloads) {
        final Bundle o = (Bundle) payloads.get(0);
        for (String key : o.keySet()) {

        }
    }

    @Override
    public void bindView(@NonNull final CommentNotiListModel model, @NonNull final CommentNotiListViewHolder holder) {


            commentListAdapter = new CommentNotiListAdapter(getContext(), model.getCommentLists());




        holder.re_comment.setLayoutManager(new LinearLayoutManager(getContext()));
        holder.re_comment.setHasFixedSize(true);
        holder.re_comment.setItemAnimator(new DefaultItemAnimator());

        holder.re_comment.setAdapter(commentListAdapter);

//        for (int i = 0; i < model.getCommentLists().size(); i++) {//Wasnt accepting for each
//
//            if (model.getCommentLists().size() > 0) {
//                Log.e("getCommentLists", model.getCommentLists().get(i).getText());
//                Log.e("getPostId", model.getCommentLists().get(i).getPostId());
//                holder.text_name.setText(model.getCommentLists().get(i).getName());
//                holder.text_comment.setText(model.getCommentLists().get(i).getText());
//                holder.text_date.setText(model.getCommentLists().get(i).getText());
//            }
//
//        }

    }

    @NonNull
    @Override
    public CommentNotiListViewHolder createViewHolder(@Nullable final ViewGroup parent) {
        return new CommentNotiListViewHolder(inflate(R.layout.view_comment, parent));
    }

    public interface Listener {
        void onCommentClicked(@NonNull CommentListModel model);
    }

}
