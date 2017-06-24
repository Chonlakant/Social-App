package com.app.sample.social.items.header;

import android.content.Context;
import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.app.sample.social.R;
import com.app.sample.social.items.viedo.VideoViewRenderer;
import com.app.sample.social.items.viedo.ViedoModel;
import com.github.vivchar.rendererrecyclerviewadapter.ViewRenderer;
import com.squareup.picasso.Picasso;

public class HeaderViewRenderer extends ViewRenderer<HeaderModel, HeaderViewHolder> {


    @NonNull
    private Listener mListener;

    public HeaderViewRenderer(final int type, final Context context, @NonNull final Listener listener) {
        super(type, context);
        mListener = listener;
    }


    @Override
    public void bindView(@NonNull final HeaderModel model, @NonNull final HeaderViewHolder holder) {
        holder.title.setText("คุณกำลังคิดอะไรอยู่....");
        long t = Long.parseLong(model.getTime());


        Picasso.with(getContext())
                .load(model.getUrl())
                .into(holder.avatar_title);

        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onTextClicked(model);
            }
        });
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

    public interface Listener {
        void onTextClicked(@NonNull HeaderModel model);
    }
}
