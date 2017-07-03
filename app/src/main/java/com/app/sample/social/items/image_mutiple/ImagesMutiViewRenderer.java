package com.app.sample.social.items.image_mutiple;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.app.sample.social.R;
import com.app.sample.social.activity_feed_mutiple_image.ActivityMutiImageFeed;
import com.app.sample.social.items.images.ImagesModel;
import com.app.sample.social.items.images.ImagesViewHolder;
import com.github.vivchar.rendererrecyclerviewadapter.ViewRenderer;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ImagesMutiViewRenderer extends ViewRenderer<ImagesMutiModel, ImagesMutiViewHolder> {

    @NonNull
    private final Listener mListener;

    ImageMutipleAdapter imageMutipleAdapter;

    private RecyclerView.LayoutManager mLayoutManager;

    public ImagesMutiViewRenderer(final int type, final Context context, @NonNull final Listener listener) {
        super(type, context);
        mListener = listener;

    }

    @Override
    public void bindView(final ImagesMutiModel item, final ImagesMutiViewHolder holder, final List payloads) {
        final Bundle o = (Bundle) payloads.get(0);
        for (String key : o.keySet()) {

        }
    }

    @Override
    public void bindView(@NonNull final ImagesMutiModel model, @NonNull final ImagesMutiViewHolder holder) {

//        ArrayList<String> item = new ArrayList<>();
//        item.add(model.getUrlAvatra());

        mLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        holder.recycler_view.setLayoutManager(mLayoutManager);

        holder.txt_content.setText(model.getTextContent());

        imageMutipleAdapter = new ImageMutipleAdapter(getContext(), model.getList());
        holder.recycler_view.setAdapter(imageMutipleAdapter);
        imageMutipleAdapter.setOnItemClickListener(new ImageMutipleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                Intent i = new Intent(getContext(), ActivityMutiImageFeed.class);
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
    public ImagesMutiViewHolder createViewHolder(@Nullable final ViewGroup parent) {
        return new ImagesMutiViewHolder(inflate(R.layout.view_mutiple_image, parent));
    }

    public interface Listener {
        void onProfileClicked(@NonNull ImagesMutiModel model);
    }


}
