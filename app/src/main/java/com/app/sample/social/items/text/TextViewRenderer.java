package com.app.sample.social.items.text;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Html;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.util.Base64;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.app.sample.social.R;
import com.github.vivchar.rendererrecyclerviewadapter.ViewRenderer;

import java.io.ByteArrayOutputStream;
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




       // String text2 = model.getText2();

        if(model.getText2() == ""){
            String html2 = model.geText();
            String result2 = Html.fromHtml(html2).toString();
            holder.text_content.setText(result2);
        } else {
            String html = model.getText2();
            String result = Html.fromHtml(html).toString();
            holder.text_content.setText(result);
        }

       // Spanned spannedFromHtml = Html.fromHtml(html, new DrawableImageGetter(), null);

       // Log.e("hhhh",spannedFromHtml.toString());



       // holder.text_content(spannedFromHtml);


//
//        if (model.getText2() != null) {
//
//
//            String code = model.getText2();
//
//
//            Spanned spanned = Html.fromHtml(code);
//            Log.e("code", code);
//            Log.e("spanne", spanned + "");
//
//
//            holder.text_content.setText(model.getText2(), TextView.BufferType.SPANNABLE);
//        }

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
