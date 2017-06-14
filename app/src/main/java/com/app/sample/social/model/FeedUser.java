package com.app.sample.social.model;

import java.util.List;

public class FeedUser {


    private String status;
    private int page;
    private int per_page;
    private int pages;
    private int total;
    private int offset;
    private String post_type;
    private String sort;
    private UserBean user;
    private CountBean count;
    private List<PostsBean> posts;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPer_page() {
        return per_page;
    }

    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public String getPost_type() {
        return post_type;
    }

    public void setPost_type(String post_type) {
        this.post_type = post_type;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public CountBean getCount() {
        return count;
    }

    public void setCount(CountBean count) {
        this.count = count;
    }

    public List<PostsBean> getPosts() {
        return posts;
    }

    public void setPosts(List<PostsBean> posts) {
        this.posts = posts;
    }

    public static class UserBean {

        private int id;
        private String about;
        private int active;
        private int avatar_id;
        private int cover_id;
        private int cover_position;
        private String email;
        private String email_verification_key;
        private int email_verified;
        private String language;
        private int last_logged;
        private String last_fb_token;
        private String name;
        private String password;
        private int time;
        private String timestamp;
        private String timezone;
        private String type;
        private String username;
        private String phone_code;
        private String phone;
        private int verified;
        private String updated_at;
        private String created_at;
        private String avatar;
        private String cover;
        private String birthday;
        private String gender;
        private boolean online;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getAbout() {
            return about;
        }

        public void setAbout(String about) {
            this.about = about;
        }

        public int getActive() {
            return active;
        }

        public void setActive(int active) {
            this.active = active;
        }

        public int getAvatar_id() {
            return avatar_id;
        }

        public void setAvatar_id(int avatar_id) {
            this.avatar_id = avatar_id;
        }

        public int getCover_id() {
            return cover_id;
        }

        public void setCover_id(int cover_id) {
            this.cover_id = cover_id;
        }

        public int getCover_position() {
            return cover_position;
        }

        public void setCover_position(int cover_position) {
            this.cover_position = cover_position;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getEmail_verification_key() {
            return email_verification_key;
        }

        public void setEmail_verification_key(String email_verification_key) {
            this.email_verification_key = email_verification_key;
        }

        public int getEmail_verified() {
            return email_verified;
        }

        public void setEmail_verified(int email_verified) {
            this.email_verified = email_verified;
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public int getLast_logged() {
            return last_logged;
        }

        public void setLast_logged(int last_logged) {
            this.last_logged = last_logged;
        }

        public String getLast_fb_token() {
            return last_fb_token;
        }

        public void setLast_fb_token(String last_fb_token) {
            this.last_fb_token = last_fb_token;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }

        public String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }

        public String getTimezone() {
            return timezone;
        }

        public void setTimezone(String timezone) {
            this.timezone = timezone;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPhone_code() {
            return phone_code;
        }

        public void setPhone_code(String phone_code) {
            this.phone_code = phone_code;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public int getVerified() {
            return verified;
        }

        public void setVerified(int verified) {
            this.verified = verified;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public boolean isOnline() {
            return online;
        }

        public void setOnline(boolean online) {
            this.online = online;
        }
    }

    public static class CountBean {
        /**
         * post : 10
         * follower : 16
         * following : 11
         * friend : 3
         * love : 1
         * group : 2
         */

        private int post;
        private int follower;
        private int following;
        private int friend;
        private int love;
        private int group;

        public int getPost() {
            return post;
        }

        public void setPost(int post) {
            this.post = post;
        }

        public int getFollower() {
            return follower;
        }

        public void setFollower(int follower) {
            this.follower = follower;
        }

        public int getFollowing() {
            return following;
        }

        public void setFollowing(int following) {
            this.following = following;
        }

        public int getFriend() {
            return friend;
        }

        public void setFriend(int friend) {
            this.friend = friend;
        }

        public int getLove() {
            return love;
        }

        public void setLove(int love) {
            this.love = love;
        }

        public int getGroup() {
            return group;
        }

        public void setGroup(int group) {
            this.group = group;
        }
    }

    public static class PostsBean {


        private int id;
        private int active;
        private AuthorBean author;
        private Object google_map_name;
        private Object link_title;
        private int post_id;
        private Object recipient_id;
        private int seen;
        private Object text;
        private Object emoticonized;
        private Object emoticonized_iOS;
        private Object tattoo_url;
        private int time;
        private int timeline_id;
        private String timestamp;
        private String type1;
        private String type2;
        private Object view;
        private int follow_count;
        private Object follow;
        private int love_count;
        private Object love;
        private int comment_count;
        private Object comment;
        private int share_count;
        private Object share;
        private String post_type;
        private MediaBean media;
        private Object clip;
        private Object soundcloud;
        private Object youtube;
        private boolean is_loved;
        private boolean is_commented;
        private boolean is_shared;
        private List<?> hidden;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getActive() {
            return active;
        }

        public void setActive(int active) {
            this.active = active;
        }

        public AuthorBean getAuthor() {
            return author;
        }

        public void setAuthor(AuthorBean author) {
            this.author = author;
        }

        public Object getGoogle_map_name() {
            return google_map_name;
        }

        public void setGoogle_map_name(Object google_map_name) {
            this.google_map_name = google_map_name;
        }

        public Object getLink_title() {
            return link_title;
        }

        public void setLink_title(Object link_title) {
            this.link_title = link_title;
        }

        public int getPost_id() {
            return post_id;
        }

        public void setPost_id(int post_id) {
            this.post_id = post_id;
        }

        public Object getRecipient_id() {
            return recipient_id;
        }

        public void setRecipient_id(Object recipient_id) {
            this.recipient_id = recipient_id;
        }

        public int getSeen() {
            return seen;
        }

        public void setSeen(int seen) {
            this.seen = seen;
        }

        public Object getText() {
            return text;
        }

        public void setText(Object text) {
            this.text = text;
        }

        public Object getEmoticonized() {
            return emoticonized;
        }

        public void setEmoticonized(Object emoticonized) {
            this.emoticonized = emoticonized;
        }

        public Object getEmoticonized_iOS() {
            return emoticonized_iOS;
        }

        public void setEmoticonized_iOS(Object emoticonized_iOS) {
            this.emoticonized_iOS = emoticonized_iOS;
        }

        public Object getTattoo_url() {
            return tattoo_url;
        }

        public void setTattoo_url(Object tattoo_url) {
            this.tattoo_url = tattoo_url;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }

        public int getTimeline_id() {
            return timeline_id;
        }

        public void setTimeline_id(int timeline_id) {
            this.timeline_id = timeline_id;
        }

        public String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }

        public String getType1() {
            return type1;
        }

        public void setType1(String type1) {
            this.type1 = type1;
        }

        public String getType2() {
            return type2;
        }

        public void setType2(String type2) {
            this.type2 = type2;
        }

        public Object getView() {
            return view;
        }

        public void setView(Object view) {
            this.view = view;
        }

        public int getFollow_count() {
            return follow_count;
        }

        public void setFollow_count(int follow_count) {
            this.follow_count = follow_count;
        }

        public Object getFollow() {
            return follow;
        }

        public void setFollow(Object follow) {
            this.follow = follow;
        }

        public int getLove_count() {
            return love_count;
        }

        public void setLove_count(int love_count) {
            this.love_count = love_count;
        }

        public Object getLove() {
            return love;
        }

        public void setLove(Object love) {
            this.love = love;
        }

        public int getComment_count() {
            return comment_count;
        }

        public void setComment_count(int comment_count) {
            this.comment_count = comment_count;
        }

        public Object getComment() {
            return comment;
        }

        public void setComment(Object comment) {
            this.comment = comment;
        }

        public int getShare_count() {
            return share_count;
        }

        public void setShare_count(int share_count) {
            this.share_count = share_count;
        }

        public Object getShare() {
            return share;
        }

        public void setShare(Object share) {
            this.share = share;
        }

        public String getPost_type() {
            return post_type;
        }

        public void setPost_type(String post_type) {
            this.post_type = post_type;
        }

        public MediaBean getMedia() {
            return media;
        }

        public void setMedia(MediaBean media) {
            this.media = media;
        }

        public Object getClip() {
            return clip;
        }

        public void setClip(Object clip) {
            this.clip = clip;
        }

        public Object getSoundcloud() {
            return soundcloud;
        }

        public void setSoundcloud(Object soundcloud) {
            this.soundcloud = soundcloud;
        }

        public Object getYoutube() {
            return youtube;
        }

        public void setYoutube(Object youtube) {
            this.youtube = youtube;
        }

        public boolean isIs_loved() {
            return is_loved;
        }

        public void setIs_loved(boolean is_loved) {
            this.is_loved = is_loved;
        }

        public boolean isIs_commented() {
            return is_commented;
        }

        public void setIs_commented(boolean is_commented) {
            this.is_commented = is_commented;
        }

        public boolean isIs_shared() {
            return is_shared;
        }

        public void setIs_shared(boolean is_shared) {
            this.is_shared = is_shared;
        }

        public List<?> getHidden() {
            return hidden;
        }

        public void setHidden(List<?> hidden) {
            this.hidden = hidden;
        }

        public static class AuthorBean {


            private int id;
            private String about;
            private int active;
            private int avatar_id;
            private int cover_id;
            private int cover_position;
            private String email;
            private String email_verification_key;
            private int email_verified;
            private String language;
            private int last_logged;
            private String last_fb_token;
            private String name;
            private String password;
            private int time;
            private String timestamp;
            private String timezone;
            private String type;
            private String username;
            private String phone_code;
            private String phone;
            private int verified;
            private String updated_at;
            private String created_at;
            private String avatar;
            private String cover;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getAbout() {
                return about;
            }

            public void setAbout(String about) {
                this.about = about;
            }

            public int getActive() {
                return active;
            }

            public void setActive(int active) {
                this.active = active;
            }

            public int getAvatar_id() {
                return avatar_id;
            }

            public void setAvatar_id(int avatar_id) {
                this.avatar_id = avatar_id;
            }

            public int getCover_id() {
                return cover_id;
            }

            public void setCover_id(int cover_id) {
                this.cover_id = cover_id;
            }

            public int getCover_position() {
                return cover_position;
            }

            public void setCover_position(int cover_position) {
                this.cover_position = cover_position;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getEmail_verification_key() {
                return email_verification_key;
            }

            public void setEmail_verification_key(String email_verification_key) {
                this.email_verification_key = email_verification_key;
            }

            public int getEmail_verified() {
                return email_verified;
            }

            public void setEmail_verified(int email_verified) {
                this.email_verified = email_verified;
            }

            public String getLanguage() {
                return language;
            }

            public void setLanguage(String language) {
                this.language = language;
            }

            public int getLast_logged() {
                return last_logged;
            }

            public void setLast_logged(int last_logged) {
                this.last_logged = last_logged;
            }

            public String getLast_fb_token() {
                return last_fb_token;
            }

            public void setLast_fb_token(String last_fb_token) {
                this.last_fb_token = last_fb_token;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public int getTime() {
                return time;
            }

            public void setTime(int time) {
                this.time = time;
            }

            public String getTimestamp() {
                return timestamp;
            }

            public void setTimestamp(String timestamp) {
                this.timestamp = timestamp;
            }

            public String getTimezone() {
                return timezone;
            }

            public void setTimezone(String timezone) {
                this.timezone = timezone;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getPhone_code() {
                return phone_code;
            }

            public void setPhone_code(String phone_code) {
                this.phone_code = phone_code;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public int getVerified() {
                return verified;
            }

            public void setVerified(int verified) {
                this.verified = verified;
            }

            public String getUpdated_at() {
                return updated_at;
            }

            public void setUpdated_at(String updated_at) {
                this.updated_at = updated_at;
            }

            public String getCreated_at() {
                return created_at;
            }

            public void setCreated_at(String created_at) {
                this.created_at = created_at;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getCover() {
                return cover;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }
        }

        public static class MediaBean {
            /**
             * id : 996
             * active : 1
             * album_id : 0
             * descr :
             * extension : none
             * name : Money
             * post_id : 0
             * temp : 0
             * timeline_id : 2
             * type : album
             * url : imgd.php?src=photos/2016/05/7lsVS_997_ec5aa0b7846082a2415f0902f0da88f2.jpg
             * url_thumb : imgd.php?src=.none&width=600
             * album_photos : [{"id":997,"album_id":996,"url":"photos/2016/05/7lsVS_997_ec5aa0b7846082a2415f0902f0da88f2.jpg","extension":"jpg","url_thumb":"imgd.php?src=photos/2016/05/7lsVS_997_ec5aa0b7846082a2415f0902f0da88f2.jpg&width=600&height=800"},{"id":998,"album_id":996,"url":"photos/2016/05/QvVnh_998_9ab0d88431732957a618d4a469a0d4c3.jpg","extension":"jpg","url_thumb":"imgd.php?src=photos/2016/05/QvVnh_998_9ab0d88431732957a618d4a469a0d4c3.jpg&width=600&height=800"},{"id":999,"album_id":996,"url":"photos/2016/05/Fsnnn_999_b706835de79a2b4e80506f582af3676a.jpg","extension":"jpg","url_thumb":"imgd.php?src=photos/2016/05/Fsnnn_999_b706835de79a2b4e80506f582af3676a.jpg&width=600&height=800"},{"id":1000,"album_id":996,"url":"photos/2016/05/GxKfH_1000_a9b7ba70783b617e9998dc4dd82eb3c5.jpg","extension":"jpg","url_thumb":"imgd.php?src=photos/2016/05/GxKfH_1000_a9b7ba70783b617e9998dc4dd82eb3c5.jpg&width=600&height=800"}]
             */

            private int id;
            private int active;
            private int album_id;
            private String descr;
            private String extension;
            private String name;
            private int post_id;
            private int temp;
            private int timeline_id;
            private String type;
            private String url;
            private String url_thumb;
            private List<AlbumPhotosBean> album_photos;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getActive() {
                return active;
            }

            public void setActive(int active) {
                this.active = active;
            }

            public int getAlbum_id() {
                return album_id;
            }

            public void setAlbum_id(int album_id) {
                this.album_id = album_id;
            }

            public String getDescr() {
                return descr;
            }

            public void setDescr(String descr) {
                this.descr = descr;
            }

            public String getExtension() {
                return extension;
            }

            public void setExtension(String extension) {
                this.extension = extension;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getPost_id() {
                return post_id;
            }

            public void setPost_id(int post_id) {
                this.post_id = post_id;
            }

            public int getTemp() {
                return temp;
            }

            public void setTemp(int temp) {
                this.temp = temp;
            }

            public int getTimeline_id() {
                return timeline_id;
            }

            public void setTimeline_id(int timeline_id) {
                this.timeline_id = timeline_id;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getUrl_thumb() {
                return url_thumb;
            }

            public void setUrl_thumb(String url_thumb) {
                this.url_thumb = url_thumb;
            }

            public List<AlbumPhotosBean> getAlbum_photos() {
                return album_photos;
            }

            public void setAlbum_photos(List<AlbumPhotosBean> album_photos) {
                this.album_photos = album_photos;
            }

            public static class AlbumPhotosBean {
                /**
                 * id : 997
                 * album_id : 996
                 * url : photos/2016/05/7lsVS_997_ec5aa0b7846082a2415f0902f0da88f2.jpg
                 * extension : jpg
                 * url_thumb : imgd.php?src=photos/2016/05/7lsVS_997_ec5aa0b7846082a2415f0902f0da88f2.jpg&width=600&height=800
                 */

                private int id;
                private int album_id;
                private String url;
                private String extension;
                private String url_thumb;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getAlbum_id() {
                    return album_id;
                }

                public void setAlbum_id(int album_id) {
                    this.album_id = album_id;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public String getExtension() {
                    return extension;
                }

                public void setExtension(String extension) {
                    this.extension = extension;
                }

                public String getUrl_thumb() {
                    return url_thumb;
                }

                public void setUrl_thumb(String url_thumb) {
                    this.url_thumb = url_thumb;
                }
            }
        }
    }
}
