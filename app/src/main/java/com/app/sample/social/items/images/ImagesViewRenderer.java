package com.app.sample.social.items.images;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;

import com.app.sample.social.R;
import com.github.vivchar.rendererrecyclerviewadapter.ViewRenderer;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ImagesViewRenderer extends ViewRenderer<ImagesModel, ImagesViewHolder> {

    @NonNull
    private final Listener mListener;

    public ImagesViewRenderer(final int type, final Context context, @NonNull final Listener listener) {
        super(type, context);
        mListener = listener;
    }

    @Override
    public void bindView(final ImagesModel item, final ImagesViewHolder holder, final List payloads) {
        final Bundle o = (Bundle) payloads.get(0);
        for (String key : o.keySet()) {

        }
    }

    @Override
    public void bindView(@NonNull final ImagesModel model, @NonNull final ImagesViewHolder holder) {

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
    public ImagesViewHolder createViewHolder(@Nullable final ViewGroup parent) {
        return new ImagesViewHolder(inflate(R.layout.item_list_photo, parent));
    }

    public interface Listener {
        void onProfileClicked(@NonNull ImagesModel model);
    }

}
