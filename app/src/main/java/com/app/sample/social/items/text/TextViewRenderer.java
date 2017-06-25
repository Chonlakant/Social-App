package com.app.sample.social.items.text;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Html;
import android.text.Spanned;
import android.view.ViewGroup;

import com.app.sample.social.MyApplication;
import com.app.sample.social.R;
import com.github.vivchar.rendererrecyclerviewadapter.ViewRenderer;

import java.io.InputStream;
import java.net.URL;
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


        if (model.getText2() == "") {
            String html2 = model.geText();
            String result2 = Html.fromHtml(html2).toString();
            holder.text_content.setText(result2);
        } else {
            String html = model.getText2();
            String result = Html.fromHtml(html).toString();
            // Spanned spanned = Html.fromHtml(html, this, null);
            // holder.text_content.setText(result);
           // holder.text_content.setText(Html.fromHtml(html, imgGetter, null));

            holder.text_content.setText(result);

           // holder.text_content.setText(Html.fromHtml(html,new MyImageGetter(),null));

        }

    }

    private class MyImageGetter implements Html.ImageGetter{

        @Override
        public Drawable getDrawable(String arg0) {
            Bitmap bitmap;
            try {
                bitmap = BitmapFactory.decodeStream(new URL(arg0).openStream());
               // bitmap=BitmapFactory.decodeStream((InputStream) new URL(arg0).getContent(), null, null);
                Drawable drawable = new BitmapDrawable(bitmap);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            } catch (Exception e) {
                Drawable d = MyApplication.getAppContext().getResources().getDrawable(R.drawable.background_1);
                d.setBounds(0,0,d.getIntrinsicWidth(),d.getIntrinsicHeight());
                return d;
            }
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
