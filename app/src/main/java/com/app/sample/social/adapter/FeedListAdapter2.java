package com.app.sample.social.adapter;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.sample.social.R;
import com.app.sample.social.model.Feed;
import com.app.sample.social.model.Feed2;
import com.app.sample.social.widget.CircleTransform;
import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class FeedListAdapter2 extends RecyclerView.Adapter<FeedListAdapter2.ViewHolder> {

    private List<Feed2> items = new ArrayList<>();

    private Context ctx;

    public static OnItemClickLike mItemClickLike;
    public static OnPhotoClick mPhotoClick;
    public static OnCommentClick mCommentClick;
    public static OnShareClick mShareClick;
    public static OnMoreClick mMoreClick;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // each data item is just a string in this case
        public ImageView photo;
        public TextView text_name;
        public ImageView bt_more;
        public ImageView photo_content;
        public ImageView bt_like;
        public ImageView bt_comment;
        public ImageView bt_share;
        public TextView text_content;
        public TextView text_date;

        public ViewHolder(View v) {
            super(v);
            photo = (ImageView) v.findViewById(R.id.photo);
            text_name = (TextView) v.findViewById(R.id.text_name);
            bt_more = (ImageView) v.findViewById(R.id.bt_more);
            photo_content = (ImageView) v.findViewById(R.id.photo_content);
            bt_like = (ImageView) v.findViewById(R.id.bt_like);
            bt_comment = (ImageView) v.findViewById(R.id.bt_comment);
            bt_share = (ImageView) v.findViewById(R.id.bt_share);
            text_content = (TextView) v.findViewById(R.id.text_content);
            text_date = (TextView) v.findViewById(R.id.text_date);

            bt_like.setOnClickListener(this);
            photo_content.setOnClickListener(this);
            bt_comment.setOnClickListener(this);
            bt_share.setOnClickListener(this);
            bt_more.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            switch (view.getId()) {
                case R.id.bt_like:
                    if (mItemClickLike != null) {
                        mItemClickLike.onItemClickLike(view, getPosition());
                    }
                    break;
                case R.id.photo_content:
                    if (mPhotoClick != null) {
                        mPhotoClick.onPhotoClick(view, getPosition());
                    }
                    break;
                case R.id.bt_comment:
                    if (mCommentClick != null) {
                        mCommentClick.onCommentClick(view, getPosition());
                    }
                    break;
                case R.id.bt_share:
                    if (mShareClick != null) {
                        mShareClick.onShareClick(view, getPosition());
                    }
                    break;
                case R.id.bt_more:
                    if (mMoreClick != null) {
                        mMoreClick.onMoreClick(view, getPosition());
                    }

            }
        }
    }

    public interface OnItemClickLike {
        public void onItemClickLike(View view, int position);
    }

    public void SetOnItemClickLike(final OnItemClickLike mItemClickLike) {
        this.mItemClickLike = mItemClickLike;
    }

    public interface OnPhotoClick {
        public void onPhotoClick(View view, int position);
    }

    public void SetOnPhotoClick(final OnPhotoClick mPhotoClick) {
        this.mPhotoClick = mPhotoClick;
    }

    public interface OnCommentClick {
        public void onCommentClick(View view, int position);
    }

    public void SetOnCommentClick(final OnCommentClick mCommentClick) {
        this.mCommentClick = mCommentClick;
    }

    public interface OnShareClick {
        public void onShareClick(View view, int position);
    }

    public void SetOnShareClick(final OnShareClick mShareClick) {
        this.mShareClick = mShareClick;
    }

    public interface OnMoreClick {
        public void onMoreClick(View view, int position);
    }

    public void SetOnMoreClick(final OnMoreClick mMoreClick) {
        this.mMoreClick = mMoreClick;
    }


    // Provide a suitable constructor (depends on the kind of dataset)
    public FeedListAdapter2(Context ctx, List<Feed2> items) {
        this.ctx = ctx;
        this.items = items;
    }

    @Override
    public FeedListAdapter2.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_feed, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Feed2 p = items.get(position);
        String avatar = "http://api.candychat.net/" + p.getPosts().get(position).getAuthor().getAvatar();
        Picasso.with(ctx)
                .load(avatar)
                .resize(80, 80)
                .transform(new CircleTransform())
                .into(holder.photo);
        holder.text_name.setText(p.getPosts().get(position).getAuthor().getUsername());
        // content photo

        if (p.getPosts().get(position).getPost_type().equals("photo")) {
            holder.photo_content.setVisibility(View.VISIBLE);
            String cover = "http://api.candychat.net/" + p.getPosts().get(position).getMedia().getUrl();
            Glide.with(ctx)
                    .load(cover)
                    .into(holder.photo_content);

        } else {

            holder.text_content.setVisibility(View.VISIBLE);
            holder.text_content.setText(p.getPosts().get(position).getText().toString());
        }


        holder.text_date.setText(p.getPosts().get(position).getAuthor().getTimestamp());


    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


}