package com.app.sample.social.items.footer;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.sample.social.R;

public class CommentViewHolder
        extends RecyclerView.ViewHolder {


    public final ImageButton bt_like;
    public final ImageView bt_comment;
    public final ImageView bt_share;
    public final TextView txt_like;


    public CommentViewHolder(final View itemView) {
        super(itemView);

        bt_like = (ImageButton) itemView.findViewById(R.id.bt_like);
        bt_comment = (ImageView) itemView.findViewById(R.id.bt_comment);
        bt_share = (ImageView) itemView.findViewById(R.id.bt_share);
        txt_like = (TextView) itemView.findViewById(R.id.txt_like);

    }
}
