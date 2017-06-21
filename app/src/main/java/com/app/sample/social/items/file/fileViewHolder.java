package com.app.sample.social.items.file;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.app.sample.social.R;

public class fileViewHolder
        extends RecyclerView.ViewHolder {


    public final TextView text_content_title;
    public final TextView text_fifle;

    public fileViewHolder(final View itemView) {
        super(itemView);

        text_content_title = (TextView) itemView.findViewById(R.id.text_content_title);
        text_fifle = (TextView) itemView.findViewById(R.id.text_fifle);


    }
}
