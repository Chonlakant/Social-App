package com.app.sample.social.items.footer;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.app.sample.social.R;
import com.github.vivchar.rendererrecyclerviewadapter.ViewRenderer;

import java.util.List;

public class CommentViewRenderer extends ViewRenderer<CommentModel, CommentViewHolder> {

    boolean isPressed = false;
    int status = 0;

    @NonNull
    private final Listener mListener;

    @NonNull
    private final ListenerLike mListenerLike;

    public CommentViewRenderer(final int type, final Context context, @NonNull final Listener listener, @NonNull final ListenerLike mListenerL) {
        super(type, context);
        mListener = listener;
        mListenerLike = mListenerL;
    }

    @Override
    public void bindView(final CommentModel item, final CommentViewHolder holder, final List payloads) {
        final Bundle o = (Bundle) payloads.get(0);
        for (String key : o.keySet()) {

        }
    }

    @Override
    public void bindView(@NonNull final CommentModel model, @NonNull final CommentViewHolder holder) {

       // holder.txt_like.setText(model.getCountLike());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                // mListener.onContentItemClicked(model);
            }
        });

        holder.txt_like.setCurrentText(model.getCountLike()+" likes");
        holder.txt_count_comment.setText(model.getCountComment()+ "  รายการ");
        holder.bt_comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onCommentClicked(model);
            }
        });

        if(model.isLiked == true){

            holder.bt_like.setImageResource(R.drawable.ic_heart_red);

        }else{

            holder.bt_like.setImageResource(R.drawable.ic_heart_outline_grey);
        }

      holder.bt_like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListenerLike.onLikeClicked(model);
            }
        });

//        holder.bt_like.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mListenerLike.onLikeClicked(model);
//
//                if (status == 0) {
//
//                    status=1 ;
//                }
//
//                else {
//
//                    status =0;
//                }
//
//            }
//        });
    }

    @NonNull
    @Override
    public CommentViewHolder createViewHolder(@Nullable final ViewGroup parent) {
        return new CommentViewHolder(inflate(R.layout.item_tap_comments, parent));
    }

    public interface Listener {
        void onCommentClicked(@NonNull CommentModel model);
    }

    public interface ListenerLike {
        void onLikeClicked(@NonNull CommentModel model);
    }
}
