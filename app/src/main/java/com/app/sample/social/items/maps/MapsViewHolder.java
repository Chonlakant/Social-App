package com.app.sample.social.items.maps;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.app.sample.social.R;

public class MapsViewHolder
        extends RecyclerView.ViewHolder {



    public final TextView txt_maps;


    public MapsViewHolder(final View itemView) {
        super(itemView);

        txt_maps = (TextView) itemView.findViewById(R.id.txt_maps);

    }
}
