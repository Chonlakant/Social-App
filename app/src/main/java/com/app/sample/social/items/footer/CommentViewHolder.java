package com.app.sample.social.items.footer;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;

import com.app.sample.social.R;

public class CommentViewHolder
        extends RecyclerView.ViewHolder {


    public final ImageButton bt_like;
    public final ImageButton bt_comment;
    public final ImageButton btnMore;
    public final TextSwitcher txt_like;


    public CommentViewHolder(final View itemView) {
        super(itemView);

        bt_like = (ImageButton) itemView.findViewById(R.id.bt_like);
        bt_comment = (ImageButton) itemView.findViewById(R.id.bt_comment);
        btnMore = (ImageButton) itemView.findViewById(R.id.btnMore);
        txt_like = (TextSwitcher) itemView.findViewById(R.id.txt_like);

    }
}
