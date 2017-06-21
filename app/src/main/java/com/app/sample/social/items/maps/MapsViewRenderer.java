package com.app.sample.social.items.maps;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.ViewGroup;

import com.app.sample.social.R;
import com.github.vivchar.rendererrecyclerviewadapter.ViewRenderer;

import java.util.List;


public class MapsViewRenderer
        extends ViewRenderer<MapsModel, MapsViewHolder> {
    @NonNull
    private final Listener mListener;

    public MapsViewRenderer(final int type, final Context context, @NonNull final Listener listener) {
        super(type, context);
        mListener = listener;
    }

    @Override
    public void bindView(final MapsModel item, final MapsViewHolder holder, final List payloads) {
        final Bundle o = (Bundle) payloads.get(0);
        for (String key : o.keySet()) {

        }
    }

    @Override
    public void bindView(@NonNull final MapsModel model, @NonNull final MapsViewHolder holder) {
        holder.txt_maps.setText(model.geText());

    }

    @NonNull
    @Override
    public MapsViewHolder createViewHolder(@Nullable final ViewGroup parent) {
        return new MapsViewHolder(inflate(R.layout.item_list_maps, parent));
    }

    public interface Listener {
        void onMpasClicked(@NonNull MapsModel model);
    }
}
