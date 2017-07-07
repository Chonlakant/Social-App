package com.app.sample.social.items.image_album;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;

import com.app.sample.social.R;
import com.app.sample.social.activity_feed_mutiple_image.ActivityMutiAlbumImageFeed;
import com.app.sample.social.activity_feed_mutiple_image.ActivityMutiImageFeed;
import com.app.sample.social.items.imageMutipleNoti.ImageMutipleNotiAdapter;
import com.app.sample.social.items.imageMutipleNoti.ImagesMutiNotiModel;
import com.app.sample.social.items.imageMutipleNoti.ImagesMutiNotiViewHolder;
import com.github.vivchar.rendererrecyclerviewadapter.ViewRenderer;

import java.util.List;

public class ImagesMutiAlbumViewRenderer extends ViewRenderer<ImagesMutiAlbumModel, ImagesMutiAlbumViewHolder> {

    @NonNull
    private final Listener mListener;

    ImageMutipleAlbumAdapter imageMutipleAdapter;

    private RecyclerView.LayoutManager mLayoutManager;

    public ImagesMutiAlbumViewRenderer(final int type, final Context context, @NonNull final Listener listener) {
        super(type, context);
        mListener = listener;

    }

    @Override
    public void bindView(final ImagesMutiAlbumModel item, final ImagesMutiAlbumViewHolder holder, final List payloads) {
        final Bundle o = (Bundle) payloads.get(0);
        for (String key : o.keySet()) {

        }
    }

    @Override
    public void bindView(@NonNull final ImagesMutiAlbumModel model, @NonNull final ImagesMutiAlbumViewHolder holder) {

//        ArrayList<String> item = new ArrayList<>();
//        item.add(model.getUrlAvatra());

        mLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        holder.recycler_view.setLayoutManager(mLayoutManager);

        holder.txt_content.setText(model.getTextContent());

        imageMutipleAdapter = new ImageMutipleAlbumAdapter(getContext(), model.getList());
        holder.recycler_view.setAdapter(imageMutipleAdapter);
        imageMutipleAdapter.setOnItemClickListener(new ImageMutipleAlbumAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                Intent i = new Intent(getContext(), ActivityMutiAlbumImageFeed.class);
                i.putExtra("postId", model.getPostId());
                getContext().startActivity(i);
            }
        });

//        Picasso.with(getContext())
//                .load(model.getUrlAvatra())
//                .into(holder.photo_content);
//
//        holder.photo_content.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mListener.onProfileClicked(model);
//            }
//        });


    }

    @NonNull
    @Override
    public ImagesMutiAlbumViewHolder createViewHolder(@Nullable final ViewGroup parent) {
        return new ImagesMutiAlbumViewHolder(inflate(R.layout.view_mutiple_image, parent));
    }

    public interface Listener {
        void onProfileClicked(@NonNull ImagesMutiAlbumModel model);
    }


}
