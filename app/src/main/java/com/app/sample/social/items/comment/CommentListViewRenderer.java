package com.app.sample.social.items.comment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.app.sample.social.R;
import com.app.sample.social.adapter.CommentListAdapter;
import com.app.sample.social.items.footer.CommentModel;
import com.app.sample.social.items.footer.CommentViewHolder;
import com.github.vivchar.rendererrecyclerviewadapter.ViewRenderer;

import java.util.ArrayList;
import java.util.List;

public class CommentListViewRenderer extends ViewRenderer<CommentListModel, CommentListViewHolder> {

    boolean isPressed = false;
    int status = 0;

    CommentListAdapter commentListAdapter;

    @NonNull
    private final Listener mListener;


    public CommentListViewRenderer(final int type, final Context context, @NonNull final Listener listener) {
        super(type, context);
        mListener = listener;

    }

    @Override
    public void bindView(final CommentListModel item, final CommentListViewHolder holder, final List payloads) {
        final Bundle o = (Bundle) payloads.get(0);
        for (String key : o.keySet()) {

        }
    }

    @Override
    public void bindView(@NonNull final CommentListModel model, @NonNull final CommentListViewHolder holder) {


        commentListAdapter = new CommentListAdapter(getContext(), model.getCommentLists());

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
    public CommentListViewHolder createViewHolder(@Nullable final ViewGroup parent) {
        return new CommentListViewHolder(inflate(R.layout.view_comment, parent));
    }

    public interface Listener {
        void onCommentClicked(@NonNull CommentListModel model);
    }

}
