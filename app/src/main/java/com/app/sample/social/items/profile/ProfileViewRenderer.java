package com.app.sample.social.items.profile;

import android.content.Context;
import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.app.sample.social.R;
import com.app.sample.social.widget.CircleTransform;
import com.github.vivchar.rendererrecyclerviewadapter.ViewRenderer;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProfileViewRenderer extends ViewRenderer<ProfileModel, ProfileViewHolder> {

    @NonNull
    private final Listener mListener;
    public static OnPhotoClick mPhotoClick;

    public ProfileViewRenderer(final int type, final Context context, @NonNull final Listener listener) {
        super(type, context);
        mListener = listener;
    }

    @Override
    public void bindView(final ProfileModel item, final ProfileViewHolder holder, final List payloads) {
        final Bundle o = (Bundle) payloads.get(0);
        for (String key : o.keySet()) {

        }
    }

    @Override
    public void bindView(@NonNull final ProfileModel model, @NonNull final ProfileViewHolder holder) {
        holder.text_name.setText(model.getName());

        long t = Long.parseLong(model.getTime());
        Log.e("time", getDate(t, "hh:mm:ss"));
        holder.text_date.setText(getDate(t, "d-M-yyyy hh:mm") + "");

        Picasso.with(getContext())
                .load(model.getUrlAvatra())
                .resize(80, 80)
                .transform(new CircleTransform())
                .into(holder.photo);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                // mListener.onContentItemClicked(model);
            }
        });
        holder.photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onProfileClicked(model);
            }
        });
    }

    @NonNull
    @Override
    public ProfileViewHolder createViewHolder(@Nullable final ViewGroup parent) {
        return new ProfileViewHolder(inflate(R.layout.item_profile, parent));
    }

    public interface Listener {
        void onProfileClicked(@NonNull ProfileModel model);
    }

    public interface OnPhotoClick {
        public void onPhotoClick(View view, int position);
    }

    public void SetOnPhotoClick(final OnPhotoClick mPhotoClick) {
        this.mPhotoClick = mPhotoClick;
    }

    private String getDate(long milliSeconds, String dateFormat) {

        DateFormat formatter = new SimpleDateFormat(dateFormat);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliSeconds);
        return formatter.format(calendar.getTime());
    }
}
