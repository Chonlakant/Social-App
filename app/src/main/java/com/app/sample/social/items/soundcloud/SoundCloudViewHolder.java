package com.app.sample.social.items.soundcloud;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.app.sample.social.R;


public class SoundCloudViewHolder
        extends RecyclerView.ViewHolder {



    public final TextView text_soundcloud;


    public SoundCloudViewHolder(final View itemView) {
        super(itemView);

        text_soundcloud = (TextView) itemView.findViewById(R.id.text_soundcloud);

    }
}
