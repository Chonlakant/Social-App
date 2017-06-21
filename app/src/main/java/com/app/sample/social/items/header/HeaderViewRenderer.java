package com.app.sample.social.items.header;

import android.content.Context;
import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.ViewGroup;

import com.app.sample.social.R;
import com.github.vivchar.rendererrecyclerviewadapter.ViewRenderer;
import com.squareup.picasso.Picasso;

public class HeaderViewRenderer
        extends ViewRenderer<HeaderModel, HeaderViewHolder> {
    public HeaderViewRenderer(final int type, final Context context) {
        super(type, context);
    }

    @Override
    public void bindView(@NonNull final HeaderModel model, @NonNull final HeaderViewHolder holder) {
        holder.title.setText(model.getName());
        long t = Long.parseLong(model.getTime());
        Log.e("time", getDate(t, "hh:mm:ss"));

        Picasso.with(getContext())
                .load(model.getUrl())
                .into(holder.avatar_title);
    }

    @NonNull
    @Override
    public HeaderViewHolder createViewHolder(@Nullable final ViewGroup parent) {
        return new HeaderViewHolder(inflate(R.layout.header_item, parent));
    }

    private String getDate(long milliSeconds, String dateFormat) {

        DateFormat formatter = new SimpleDateFormat(dateFormat);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliSeconds);
        return formatter.format(calendar.getTime());
    }
}
