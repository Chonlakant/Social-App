package com.app.sample.social.items.image_mutiple;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;

import com.app.sample.social.R;
import com.app.sample.social.items.images.ImagesModel;
import com.app.sample.social.items.images.ImagesViewHolder;
import com.github.vivchar.rendererrecyclerviewadapter.ViewRenderer;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ImagesMutiViewRenderer extends ViewRenderer<ImagesMutiModel, ImagesMutiViewHolder> {

    @NonNull
    private final Listener mListener;

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

        Picasso.with(getContext())
                .load(model.getUrlAvatra())
                .into(holder.photo_content);

        holder.photo_content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onProfileClicked(model);
            }
        });



    }

    @NonNull
    @Override
    public ImagesMutiViewHolder createViewHolder(@Nullable final ViewGroup parent) {
        return new ImagesMutiViewHolder(inflate(R.layout.item_list_photo, parent));
    }

    public interface Listener {
        void onProfileClicked(@NonNull ImagesMutiModel model);
    }


}
