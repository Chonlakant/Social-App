package com.app.sample.social.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.app.sample.social.R;
import com.app.sample.social.model.Feed;
import com.app.sample.social.model.Friend2;
import com.app.sample.social.widget.CircleTransform;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CommentListAdapter extends RecyclerView.Adapter<CommentListAdapter.ViewHolder> {

    private List<Feed.PostsBean.GetPostCommentsBean> original_items = new ArrayList<>();

    private Context ctx;
    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public CommentListAdapter(Context context, List<Feed.PostsBean.GetPostCommentsBean> items) {
        original_items = items;
        ctx = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        // each data item is just a string in this case
        public final TextView text_name;
        public final TextView text_comment;
        public final TextView text_date;
        public final ImageView photo;

        public ViewHolder(View v) {
            super(v);
            text_name = (TextView) v.findViewById(R.id.text_name);
            text_comment = (TextView) v.findViewById(R.id.text_comment);
            text_date = (TextView) v.findViewById(R.id.text_date);
            photo = (ImageView) v.findViewById(R.id.photo);
            photo.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.photo:
                    if (mOnItemClickListener != null) {
                        mOnItemClickListener.onItemClick(v, getPosition());
                    }

            }

        }
    }


    @Override
    public CommentListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_comment, parent, false);

        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Feed.PostsBean.GetPostCommentsBean c = original_items.get(position);



        holder.text_name.setText(c.getPublisher().getName());
        holder.text_comment.setText(c.getText());
        Picasso.with(ctx)
                .load(c.getPublisher().getAvatar())
                .resize(100, 100)
                .transform(new CircleTransform())
                .into(holder.photo);


    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return original_items.size() / 1;
    }


}