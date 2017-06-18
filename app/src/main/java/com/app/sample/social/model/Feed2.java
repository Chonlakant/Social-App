package com.app.sample.social.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Feed2 {


    private String api_status;
    private String api_version;
    private List<ItemsBean> items;

    public String getApi_status() {
        return api_status;
    }

    public void setApi_status(String api_status) {
        this.api_status = api_status;
    }

    public String getApi_version() {
        return api_version;
    }

    public void setApi_version(String api_version) {
        this.api_version = api_version;
    }

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public static class ItemsBean {


        private String post_id;
        private String post_type;
        private int post_type2;
        private PostDataBean post_data;
        private PublisherDataBean publisher_data;

        public String getPost_id() {
            return post_id;
        }

        public void setPost_id(String post_id) {
            this.post_id = post_id;
        }

        public String getPost_type() {
            return post_type;
        }

        public void setPost_type(String post_type) {
            this.post_type = post_type;
        }

        public int getPost_type2() {
            return post_type2;
        }

        public void setPost_type2(int post_type2) {
            this.post_type2 = post_type2;
        }

        public PostDataBean getPost_data() {
            return post_data;
        }

        public void setPost_data(PostDataBean post_data) {
            this.post_data = post_data;
        }

        public PublisherDataBean getPublisher_data() {
            return publisher_data;
        }

        public void setPublisher_data(PublisherDataBean publisher_data) {
            this.publisher_data = publisher_data;
        }

        public static class PostDataBean {
            /**
             * post_id : 1564
             * post_text : bootstrap
             * post_file : ttt
             * post_soundcloud :
             * post_youtube :
             * post_vine :
             * post_map :
             * post_time : 1497592806
             * post_likes : 0
             * post_wonders : 0
             */

            private String post_id;
            private String post_text;
            private String post_file;
            private String post_soundcloud;
            private String post_youtube;
            private String post_vine;
            private String post_map;
            private String post_time;
            private String post_likes;
            private String post_wonders;

            public String getPost_id() {
                return post_id;
            }

            public void setPost_id(String post_id) {
                this.post_id = post_id;
            }

            public String getPost_text() {
                return post_text;
            }

            public void setPost_text(String post_text) {
                this.post_text = post_text;
            }

            public String getPost_file() {
                return post_file;
            }

            public void setPost_file(String post_file) {
                this.post_file = post_file;
            }

            public String getPost_soundcloud() {
                return post_soundcloud;
            }

            public void setPost_soundcloud(String post_soundcloud) {
                this.post_soundcloud = post_soundcloud;
            }

            public String getPost_youtube() {
                return post_youtube;
            }

            public void setPost_youtube(String post_youtube) {
                this.post_youtube = post_youtube;
            }

            public String getPost_vine() {
                return post_vine;
            }

            public void setPost_vine(String post_vine) {
                this.post_vine = post_vine;
            }

            public String getPost_map() {
                return post_map;
            }

            public void setPost_map(String post_map) {
                this.post_map = post_map;
            }

            public String getPost_time() {
                return post_time;
            }

            public void setPost_time(String post_time) {
                this.post_time = post_time;
            }

            public String getPost_likes() {
                return post_likes;
            }

            public void setPost_likes(String post_likes) {
                this.post_likes = post_likes;
            }

            public String getPost_wonders() {
                return post_wonders;
            }

            public void setPost_wonders(String post_wonders) {
                this.post_wonders = post_wonders;
            }
        }

        public static class PublisherDataBean {

            private String id;
            private String username;
            private String first_name;
            private String last_name;
            private String gender;
            private String birthday;
            private Object about;
            private String website;
            private String facebook;
            private String twitter;
            private String vk;
            @SerializedName("google+")
            private String _$Google282; // FIXME check this code
            private String profile_picture;
            private String cover_picture;
            private String verified;
            private String url;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getFirst_name() {
                return first_name;
            }

            public void setFirst_name(String first_name) {
                this.first_name = first_name;
            }

            public String getLast_name() {
                return last_name;
            }

            public void setLast_name(String last_name) {
                this.last_name = last_name;
            }

            public String getGender() {
                return gender;
            }

            public void setGender(String gender) {
                this.gender = gender;
            }

            public String getBirthday() {
                return birthday;
            }

            public void setBirthday(String birthday) {
                this.birthday = birthday;
            }

            public Object getAbout() {
                return about;
            }

            public void setAbout(Object about) {
                this.about = about;
            }

            public String getWebsite() {
                return website;
            }

            public void setWebsite(String website) {
                this.website = website;
            }

            public String getFacebook() {
                return facebook;
            }

            public void setFacebook(String facebook) {
                this.facebook = facebook;
            }

            public String getTwitter() {
                return twitter;
            }

            public void setTwitter(String twitter) {
                this.twitter = twitter;
            }

            public String getVk() {
                return vk;
            }

            public void setVk(String vk) {
                this.vk = vk;
            }

            public String get_$Google282() {
                return _$Google282;
            }

            public void set_$Google282(String _$Google282) {
                this._$Google282 = _$Google282;
            }

            public String getProfile_picture() {
                return profile_picture;
            }

            public void setProfile_picture(String profile_picture) {
                this.profile_picture = profile_picture;
            }

            public String getCover_picture() {
                return cover_picture;
            }

            public void setCover_picture(String cover_picture) {
                this.cover_picture = cover_picture;
            }

            public String getVerified() {
                return verified;
            }

            public void setVerified(String verified) {
                this.verified = verified;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
