package com.app.sample.social.items.Comment_noti;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.sample.social.R;
import com.app.sample.social.model.Feed;
import com.app.sample.social.model.Friend2;
import com.app.sample.social.model.GetPostId;
import com.app.sample.social.widget.CircleTransform;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CommentNotiListAdapter extends RecyclerView.Adapter<CommentNotiListAdapter.ViewHolder> {

    private List<GetPostId.PostDataBean.GetPostCommentsBean> original_items = new ArrayList<>();

    private Context ctx;
    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(View view, Friend2 obj, int position);
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public CommentNotiListAdapter(Context context, List<GetPostId.PostDataBean.GetPostCommentsBean> items) {
        original_items = items;
        ctx = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
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
        }
    }


    @Override
    public CommentNotiListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_comment, parent, false);

        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final GetPostId.PostDataBean.GetPostCommentsBean c = original_items.get(position);



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