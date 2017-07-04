package com.app.sample.social.items.file;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;

import com.app.sample.social.R;
import com.github.vivchar.rendererrecyclerviewadapter.ViewRenderer;

import java.util.List;

public class fileViewRenderer extends ViewRenderer<fileModel, fileViewHolder> {

    @NonNull
    private final Listener mListener;

    public fileViewRenderer(final int type, final Context context, @NonNull final Listener listener) {
        super(type, context);
        mListener = listener;
    }

    @Override
    public void bindView(final fileModel item, final fileViewHolder holder, final List payloads) {
        final Bundle o = (Bundle) payloads.get(0);
        for (String key : o.keySet()) {

        }
    }

    @Override
    public void bindView(@NonNull final fileModel model, @NonNull final fileViewHolder holder) {

        holder.text_content_title.setText(model.getTitle());
        holder.text_fifle.setText(model.getTitle());
        holder.text_fifle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mListener.onFileClicked(model);
            }
        });

    }

    @NonNull
    @Override
    public fileViewHolder createViewHolder(@Nullable final ViewGroup parent) {
        return new fileViewHolder(inflate(R.layout.item_list_file, parent));
    }

    public interface Listener {
        void onFileClicked(@NonNull fileModel model);
    }

}
