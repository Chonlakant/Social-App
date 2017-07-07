package com.app.sample.social.items.imageMutipleNoti;

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
import com.app.sample.social.activity_feed_mutiple_image.ActivityMutiImageFeed;
import com.app.sample.social.items.image_mutiple.ImageMutipleAdapter;
import com.app.sample.social.items.image_mutiple.ImagesMutiModel;
import com.app.sample.social.items.image_mutiple.ImagesMutiViewHolder;
import com.github.vivchar.rendererrecyclerviewadapter.ViewRenderer;

import java.util.List;

public class ImagesMutiNotiViewRenderer extends ViewRenderer<ImagesMutiNotiModel, ImagesMutiNotiViewHolder> {

    @NonNull
    private final Listener mListener;

    ImageMutipleNotiAdapter imageMutipleAdapter;

    private RecyclerView.LayoutManager mLayoutManager;

    public ImagesMutiNotiViewRenderer(final int type, final Context context, @NonNull final Listener listener) {
        super(type, context);
        mListener = listener;

    }

    @Override
    public void bindView(final ImagesMutiNotiModel item, final ImagesMutiNotiViewHolder holder, final List payloads) {
        final Bundle o = (Bundle) payloads.get(0);
        for (String key : o.keySet()) {

        }
    }

    @Override
    public void bindView(@NonNull final ImagesMutiNotiModel model, @NonNull final ImagesMutiNotiViewHolder holder) {

//        ArrayList<String> item = new ArrayList<>();
//        item.add(model.getUrlAvatra());

        mLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        holder.recycler_view.setLayoutManager(mLayoutManager);

        holder.txt_content.setText(model.getTextContent());

        imageMutipleAdapter = new ImageMutipleNotiAdapter(getContext(), model.getList());
        holder.recycler_view.setAdapter(imageMutipleAdapter);
        imageMutipleAdapter.setOnItemClickListener(new ImageMutipleNotiAdapter.OnItemClickListener() {
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
    public ImagesMutiNotiViewHolder createViewHolder(@Nullable final ViewGroup parent) {
        return new ImagesMutiNotiViewHolder(inflate(R.layout.view_mutiple_image, parent));
    }

    public interface Listener {
        void onProfileClicked(@NonNull ImagesMutiNotiModel model);
    }


}
