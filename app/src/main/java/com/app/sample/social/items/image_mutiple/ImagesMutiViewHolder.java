package com.app.sample.social.items.image_mutiple;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.sample.social.R;


public class ImagesMutiViewHolder extends RecyclerView.ViewHolder {


    public final RecyclerView recycler_view;
    public final TextView txt_content;

    public ImagesMutiViewHolder(final View itemView) {
        super(itemView);

        recycler_view = (RecyclerView) itemView.findViewById(R.id.recycler_view);
        txt_content = (TextView) itemView.findViewById(R.id.txt_content);

    }
}
