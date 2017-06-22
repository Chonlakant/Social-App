package com.app.sample.social.items.header;

import android.support.annotation.NonNull;

import com.app.sample.social.items.BaseItemModel;

public class HeaderModel implements BaseItemModel {

    public static final int TYPE = 0;
    private final int mID;
    String url;
    String time;

    @NonNull
    private final String mName;
    String userId;

    public HeaderModel(final int ID, @NonNull final String name, String url,String time) {
        mID = ID;
        mName = name;
        this.url = url;
        this.time = time;
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
    public String getName() {
        return mName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
