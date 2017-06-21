package com.app.sample.social.items.youtube;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.sample.social.R;

public class YoutubeViewHolder
        extends RecyclerView.ViewHolder {


    public final ImageView photo_youtube;
    public final TextView txt_title_youtube;
    public final ImageView img_play;

    public YoutubeViewHolder(final View itemView) {
        super(itemView);

        photo_youtube = (ImageView) itemView.findViewById(R.id.photo_youtube);
        txt_title_youtube = (TextView) itemView.findViewById(R.id.txt_title_youtube);
        img_play = (ImageView) itemView.findViewById(R.id.img_play);

    }
}
