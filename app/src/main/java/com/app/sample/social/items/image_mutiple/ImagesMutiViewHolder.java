package com.app.sample.social.items.image_mutiple;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.app.sample.social.R;


public class ImagesMutiViewHolder
        extends RecyclerView.ViewHolder {


    public final ImageView photo_content;

    public ImagesMutiViewHolder(final View itemView) {
        super(itemView);

        photo_content = (ImageView) itemView.findViewById(R.id.photo_content);


    }
}
