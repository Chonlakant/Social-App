package com.app.sample.social.items.text;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Spanned;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.sample.social.R;
import com.github.vivchar.rendererrecyclerviewadapter.ViewRenderer;

import java.util.List;

public class TextViewRenderer
        extends ViewRenderer<TextModel, TextViewHolder> {
    @NonNull
    private final Listener mListener;

    public TextViewRenderer(final int type, final Context context, @NonNull final Listener listener) {
        super(type, context);
        mListener = listener;
    }

    @Override
    public void bindView(final TextModel item, final TextViewHolder holder, final List payloads) {
        final Bundle o = (Bundle) payloads.get(0);
        for (String key : o.keySet()) {

        }
    }

    @Override
    public void bindView(@NonNull final TextModel model, @NonNull final TextViewHolder holder) {


                if(model.geText() != null){
                    holder.text_content.setText(model.geText());
                }

                if(model.getText2() != null){
                            holder.text_content.setText(model.getText2(),TextView.BufferType.SPANNABLE);
                 }

    }

    @NonNull
    @Override
    public TextViewHolder createViewHolder(@Nullable final ViewGroup parent) {
        return new TextViewHolder(inflate(R.layout.item_list_text, parent));
    }

    public interface Listener {
        void onTextClicked(@NonNull TextModel model);
    }
}
