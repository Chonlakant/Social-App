package com.app.sample.social.items.imageMutipleNoti;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.app.sample.social.R;
import com.app.sample.social.model.Feed;
import com.app.sample.social.model.FeedUser;
import com.app.sample.social.model.GetPostId;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class ImageMutipleNotiAdapter extends RecyclerView.Adapter<ImageMutipleNotiAdapter.ViewHolder> {
    public OnItemClickListener mOnItemClickListener;
    List<GetPostId.PostDataBean.PhotoMultiBean> list = new ArrayList<>();
    Context context;

    public ImageMutipleNotiAdapter(Context context, List<GetPostId.PostDataBean.PhotoMultiBean> list) {
        this.context = context;
        this.list = list;

    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView img_mutiple;


        public ViewHolder(View v) {
            super(v);
            img_mutiple = (ImageView) v.findViewById(R.id.img_mutiple);

            img_mutiple.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.img_mutiple:
                    if (mOnItemClickListener != null) {
                        mOnItemClickListener.onItemClick(v, getPosition());
                    }

            }
        }
    }

    @Override
    public ImageMutipleNotiAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Create a new View
        View v = LayoutInflater.from(context).inflate(R.layout.item_image_mutiple, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        GetPostId.PostDataBean.PhotoMultiBean item = list.get(position);
        String thumb = "http://zaab-d.com/imgd.php?w=600&src="+item.getImage();
        Picasso.with(context)
                .load(thumb)
                .into(holder.img_mutiple);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }
}