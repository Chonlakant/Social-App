package com.app.sample.social.items.comment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.sample.social.R;

public class CommentListViewHolder
        extends RecyclerView.ViewHolder {


//    public final TextView text_name;
//    public final TextView text_comment;
//    public final TextView text_date;
//    public final ImageView photo;

    public final RecyclerView re_comment;


    public CommentListViewHolder(final View itemView) {
        super(itemView);

          re_comment = (RecyclerView) itemView.findViewById(R.id.re_comment);

//        text_name = (TextView) itemView.findViewById(R.id.text_name);
//        text_comment = (TextView) itemView.findViewById(R.id.text_comment);
//        text_date = (TextView) itemView.findViewById(R.id.text_date);
//        photo = (ImageView) itemView.findViewById(R.id.photo);

    }
}
