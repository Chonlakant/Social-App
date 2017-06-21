package com.app.sample.social.items.header;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.sample.social.R;


public
class HeaderViewHolder
		extends RecyclerView.ViewHolder
{

	public final TextView title;
	public final ImageView avatar_title;

	public
	HeaderViewHolder(final View itemView) {
		super(itemView);
		title = (TextView) itemView.findViewById(R.id.title);
		avatar_title = (ImageView) itemView.findViewById(R.id.avatar_title);
	}
}
