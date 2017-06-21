package com.app.sample.social.items.viedo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.app.sample.social.R;


public class VideoViewHolder
        extends RecyclerView.ViewHolder {


    public final ImageView img_play;
    public final VideoView myvideoView;
    public final TextView txt_title_video;

    public VideoViewHolder(final View itemView) {
        super(itemView);

        img_play = (ImageView) itemView.findViewById(R.id.img_play);
        myvideoView = (VideoView) itemView.findViewById(R.id.myvideoView);
        txt_title_video = (TextView) itemView.findViewById(R.id.txt_title_video);


    }
}
