package com.app.sample.social.items.maps;

import android.support.annotation.NonNull;

import com.app.sample.social.items.BaseItemModel;

public class MapsModel
        implements BaseItemModel {

    public static final int TYPE = 6;
    private final int mID;
    @NonNull
    private final String mTitle;

    public MapsModel(final int ID, @NonNull final String title) {
        mID = ID;
        mTitle = title;
    }

    @Override
    public int getID() {
        return mID;
    }

    @Override
    public int getType() {
        return TYPE;
    }

    @NonNull
    public String geText() {
        return mTitle;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final MapsModel that = (MapsModel) o;

        if (mID != that.mID) {
            return false;
        }
        return mTitle.equals(that.mTitle);

    }

    @Override
    public int hashCode() {
        int result = mID;
        result = 31 * result + mTitle.hashCode();
        return result;
    }
}
