package com.app.sample.social.items.profile;


import com.app.sample.social.items.BaseItemModel;

public class ProfileModel implements BaseItemModel {

    public static final int TYPE = 9;
    private final int mID;
    private String name;
    private String urlAvatra;
    private String time;
    private String userId;
    private String cover;


    public ProfileModel(int mID, String name, String urlAvatra,String time,String userId,String cover) {
        this.mID = mID;
        this.name = name;
        this.urlAvatra = urlAvatra;
        this.time = time;
        this.userId = userId;
        this.cover = cover;

    }

    @Override
    public int getID() {
        return mID;
    }

    @Override
    public int getType() {
        return TYPE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlAvatra() {
        return urlAvatra;
    }

    public void setUrlAvatra(String urlAvatra) {
        this.urlAvatra = urlAvatra;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final ProfileModel that = (ProfileModel) o;

        if (mID != that.mID) {
            return false;
        }
        return name.equals(that.name);

    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }
}
