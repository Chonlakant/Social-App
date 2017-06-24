package com.app.sample.social.model;

import java.util.List;

/**
 * Created by Bas on 6/23/2017 AD.
 */

public class Notifications {


    private String api_status;
    private String api_text;
    private String api_version;
    private String count_notifications;
    private String count_friend_requests;
    private String count_messages;
    private List<NotificationsBean> notifications;
    private List<FriendRequestsBean> friend_requests;
    private List<?> pro_users;
    private List<TrendingHashtagBean> trending_hashtag;
    private List<?> promoted_pages;

    public String getApi_status() {
        return api_status;
    }

    public void setApi_status(String api_status) {
        this.api_status = api_status;
    }

    public String getApi_text() {
        return api_text;
    }

    public void setApi_text(String api_text) {
        this.api_text = api_text;
    }

    public String getApi_version() {
        return api_version;
    }

    public void setApi_version(String api_version) {
        this.api_version = api_version;
    }

    public String getCount_notifications() {
        return count_notifications;
    }

    public void setCount_notifications(String count_notifications) {
        this.count_notifications = count_notifications;
    }

    public String getCount_friend_requests() {
        return count_friend_requests;
    }

    public void setCount_friend_requests(String count_friend_requests) {
        this.count_friend_requests = count_friend_requests;
    }

    public String getCount_messages() {
        return count_messages;
    }

    public void setCount_messages(String count_messages) {
        this.count_messages = count_messages;
    }

    public List<NotificationsBean> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<NotificationsBean> notifications) {
        this.notifications = notifications;
    }

    public List<FriendRequestsBean> getFriend_requests() {
        return friend_requests;
    }

    public void setFriend_requests(List<FriendRequestsBean> friend_requests) {
        this.friend_requests = friend_requests;
    }

    public List<?> getPro_users() {
        return pro_users;
    }

    public void setPro_users(List<?> pro_users) {
        this.pro_users = pro_users;
    }

    public List<TrendingHashtagBean> getTrending_hashtag() {
        return trending_hashtag;
    }

    public void setTrending_hashtag(List<TrendingHashtagBean> trending_hashtag) {
        this.trending_hashtag = trending_hashtag;
    }

    public List<?> getPromoted_pages() {
        return promoted_pages;
    }

    public void setPromoted_pages(List<?> promoted_pages) {
        this.promoted_pages = promoted_pages;
    }

    public static class NotificationsBean {
        /**
         * id : 9054
         * notifier_id : 164
         * recipient_id : 166
         * post_id : 0
         * page_id : 0
         * group_id : 0
         * seen_pop : 0
         * type : visited_profile
         * type2 :
         * text :
         * url : https://www.zaab-d.com/Chonlakant
         * seen : 0
         * time : 1498212211
         * notifier : {"user_id":"164","username":"Chonlakant","email":"sattboot1@gmail.com","first_name":"","last_name":"","avatar":"https://www.zaab-d.com/upload/photos/2017/06/46LTgnYPwnoR7VBaKXCt_17_70ef68232ea9523ade99770aaeb7dd0a_avatar.jpg","cover":"https://www.zaab-d.com/upload/photos/d-cover.jpg","relationship_id":"0","address":"","working":"","working_link":"","about":null,"school":"","gender":"male","birthday":"0000-00-00","website":"","facebook":"","google":"","twitter":"","linkedin":"","youtube":"","vk":"","instagram":"","language":"thai","ip_address":"27.130.195.161","follow_privacy":"0","post_privacy":"ifollow","message_privacy":"0","confirm_followers":"0","show_activities_privacy":"1","birth_privacy":"0","visit_privacy":"0","verified":"0","lastseen":"1498224392","showlastseen":"1","status":"0","active":"1","admin":"0","registered":"6/2017","phone_number":"","is_pro":"0","pro_type":"0","joined":"1496826926","timezone":"UTC","referrer":"0","balance":"0","paypal_email":"","notifications_sound":"0","order_posts_by":"1","social_login":"0","url":"https://www.zaab-d.com/Chonlakant","name":"Chonlakant"}
         * ajax_url : ?link1=timeline&u=Chonlakant
         * type_text : เข้าสู่โปรไฟล์ของคุณ
         * icon : eye
         * time_text_string : 3 ชั่วโมง ที่ผ่านมา
         * time_text : 10:03
         */

        private String id;
        private String notifier_id;
        private String recipient_id;
        private String post_id;
        private String page_id;
        private String group_id;
        private String seen_pop;
        private String type;
        private String type2;
        private String text;
        private String url;
        private String seen;
        private String time;
        private NotifierBean notifier;
        private String ajax_url;
        private String type_text;
        private String icon;
        private String time_text_string;
        private String time_text;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getNotifier_id() {
            return notifier_id;
        }

        public void setNotifier_id(String notifier_id) {
            this.notifier_id = notifier_id;
        }

        public String getRecipient_id() {
            return recipient_id;
        }

        public void setRecipient_id(String recipient_id) {
            this.recipient_id = recipient_id;
        }

        public String getPost_id() {
            return post_id;
        }

        public void setPost_id(String post_id) {
            this.post_id = post_id;
        }

        public String getPage_id() {
            return page_id;
        }

        public void setPage_id(String page_id) {
            this.page_id = page_id;
        }

        public String getGroup_id() {
            return group_id;
        }

        public void setGroup_id(String group_id) {
            this.group_id = group_id;
        }

        public String getSeen_pop() {
            return seen_pop;
        }

        public void setSeen_pop(String seen_pop) {
            this.seen_pop = seen_pop;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getType2() {
            return type2;
        }

        public void setType2(String type2) {
            this.type2 = type2;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getSeen() {
            return seen;
        }

        public void setSeen(String seen) {
            this.seen = seen;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public NotifierBean getNotifier() {
            return notifier;
        }

        public void setNotifier(NotifierBean notifier) {
            this.notifier = notifier;
        }

        public String getAjax_url() {
            return ajax_url;
        }

        public void setAjax_url(String ajax_url) {
            this.ajax_url = ajax_url;
        }

        public String getType_text() {
            return type_text;
        }

        public void setType_text(String type_text) {
            this.type_text = type_text;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getTime_text_string() {
            return time_text_string;
        }

        public void setTime_text_string(String time_text_string) {
            this.time_text_string = time_text_string;
        }

        public String getTime_text() {
            return time_text;
        }

        public void setTime_text(String time_text) {
            this.time_text = time_text;
        }

        public static class NotifierBean {


            private String user_id;
            private String username;
            private String email;
            private String first_name;
            private String last_name;
            private String avatar;
            private String cover;
            private String relationship_id;
            private String address;
            private String working;
            private String working_link;
            private Object about;
            private String school;
            private String gender;
            private String birthday;
            private String website;
            private String facebook;
            private String google;
            private String twitter;
            private String linkedin;
            private String youtube;
            private String vk;
            private String instagram;
            private String language;
            private String ip_address;
            private String follow_privacy;
            private String post_privacy;
            private String message_privacy;
            private String confirm_followers;
            private String show_activities_privacy;
            private String birth_privacy;
            private String visit_privacy;
            private String verified;
            private String lastseen;
            private String showlastseen;
            private String status;
            private String active;
            private String admin;
            private String registered;
            private String phone_number;
            private String is_pro;
            private String pro_type;
            private String joined;
            private String timezone;
            private String referrer;
            private String balance;
            private String paypal_email;
            private String notifications_sound;
            private String order_posts_by;
            private String social_login;
            private String url;
            private String name;

            public String getUser_id() {
                return user_id;
            }

            public void setUser_id(String user_id) {
                this.user_id = user_id;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
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

            public String getRelationship_id() {
                return relationship_id;
            }

            public void setRelationship_id(String relationship_id) {
                this.relationship_id = relationship_id;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getWorking() {
                return working;
            }

            public void setWorking(String working) {
                this.working = working;
            }

            public String getWorking_link() {
                return working_link;
            }

            public void setWorking_link(String working_link) {
                this.working_link = working_link;
            }

            public Object getAbout() {
                return about;
            }

            public void setAbout(Object about) {
                this.about = about;
            }

            public String getSchool() {
                return school;
            }

            public void setSchool(String school) {
                this.school = school;
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

            public String getGoogle() {
                return google;
            }

            public void setGoogle(String google) {
                this.google = google;
            }

            public String getTwitter() {
                return twitter;
            }

            public void setTwitter(String twitter) {
                this.twitter = twitter;
            }

            public String getLinkedin() {
                return linkedin;
            }

            public void setLinkedin(String linkedin) {
                this.linkedin = linkedin;
            }

            public String getYoutube() {
                return youtube;
            }

            public void setYoutube(String youtube) {
                this.youtube = youtube;
            }

            public String getVk() {
                return vk;
            }

            public void setVk(String vk) {
                this.vk = vk;
            }

            public String getInstagram() {
                return instagram;
            }

            public void setInstagram(String instagram) {
                this.instagram = instagram;
            }

            public String getLanguage() {
                return language;
            }

            public void setLanguage(String language) {
                this.language = language;
            }

            public String getIp_address() {
                return ip_address;
            }

            public void setIp_address(String ip_address) {
                this.ip_address = ip_address;
            }

            public String getFollow_privacy() {
                return follow_privacy;
            }

            public void setFollow_privacy(String follow_privacy) {
                this.follow_privacy = follow_privacy;
            }

            public String getPost_privacy() {
                return post_privacy;
            }

            public void setPost_privacy(String post_privacy) {
                this.post_privacy = post_privacy;
            }

            public String getMessage_privacy() {
                return message_privacy;
            }

            public void setMessage_privacy(String message_privacy) {
                this.message_privacy = message_privacy;
            }

            public String getConfirm_followers() {
                return confirm_followers;
            }

            public void setConfirm_followers(String confirm_followers) {
                this.confirm_followers = confirm_followers;
            }

            public String getShow_activities_privacy() {
                return show_activities_privacy;
            }

            public void setShow_activities_privacy(String show_activities_privacy) {
                this.show_activities_privacy = show_activities_privacy;
            }

            public String getBirth_privacy() {
                return birth_privacy;
            }

            public void setBirth_privacy(String birth_privacy) {
                this.birth_privacy = birth_privacy;
            }

            public String getVisit_privacy() {
                return visit_privacy;
            }

            public void setVisit_privacy(String visit_privacy) {
                this.visit_privacy = visit_privacy;
            }

            public String getVerified() {
                return verified;
            }

            public void setVerified(String verified) {
                this.verified = verified;
            }

            public String getLastseen() {
                return lastseen;
            }

            public void setLastseen(String lastseen) {
                this.lastseen = lastseen;
            }

            public String getShowlastseen() {
                return showlastseen;
            }

            public void setShowlastseen(String showlastseen) {
                this.showlastseen = showlastseen;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getActive() {
                return active;
            }

            public void setActive(String active) {
                this.active = active;
            }

            public String getAdmin() {
                return admin;
            }

            public void setAdmin(String admin) {
                this.admin = admin;
            }

            public String getRegistered() {
                return registered;
            }

            public void setRegistered(String registered) {
                this.registered = registered;
            }

            public String getPhone_number() {
                return phone_number;
            }

            public void setPhone_number(String phone_number) {
                this.phone_number = phone_number;
            }

            public String getIs_pro() {
                return is_pro;
            }

            public void setIs_pro(String is_pro) {
                this.is_pro = is_pro;
            }

            public String getPro_type() {
                return pro_type;
            }

            public void setPro_type(String pro_type) {
                this.pro_type = pro_type;
            }

            public String getJoined() {
                return joined;
            }

            public void setJoined(String joined) {
                this.joined = joined;
            }

            public String getTimezone() {
                return timezone;
            }

            public void setTimezone(String timezone) {
                this.timezone = timezone;
            }

            public String getReferrer() {
                return referrer;
            }

            public void setReferrer(String referrer) {
                this.referrer = referrer;
            }

            public String getBalance() {
                return balance;
            }

            public void setBalance(String balance) {
                this.balance = balance;
            }

            public String getPaypal_email() {
                return paypal_email;
            }

            public void setPaypal_email(String paypal_email) {
                this.paypal_email = paypal_email;
            }

            public String getNotifications_sound() {
                return notifications_sound;
            }

            public void setNotifications_sound(String notifications_sound) {
                this.notifications_sound = notifications_sound;
            }

            public String getOrder_posts_by() {
                return order_posts_by;
            }

            public void setOrder_posts_by(String order_posts_by) {
                this.order_posts_by = order_posts_by;
            }

            public String getSocial_login() {
                return social_login;
            }

            public void setSocial_login(String social_login) {
                this.social_login = social_login;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }

    public static class FriendRequestsBean {
        /**
         * user_id : 164
         * username : Chonlakant
         * email : sattboot1@gmail.com
         * first_name :
         * last_name :
         * avatar : https://www.zaab-d.com/upload/photos/2017/06/46LTgnYPwnoR7VBaKXCt_17_70ef68232ea9523ade99770aaeb7dd0a_avatar.jpg
         * cover : https://www.zaab-d.com/upload/photos/d-cover.jpg
         * relationship_id : 0
         * address :
         * working :
         * working_link :
         * about : null
         * school :
         * gender : male
         * birthday : 0000-00-00
         * website :
         * facebook :
         * google :
         * twitter :
         * linkedin :
         * youtube :
         * vk :
         * instagram :
         * language : thai
         * ip_address : 27.130.195.161
         * follow_privacy : 0
         * post_privacy : ifollow
         * message_privacy : 0
         * confirm_followers : 0
         * show_activities_privacy : 1
         * birth_privacy : 0
         * visit_privacy : 0
         * verified : 0
         * lastseen : 1498224392
         * showlastseen : 1
         * status : 0
         * active : 1
         * admin : 0
         * registered : 6/2017
         * phone_number :
         * is_pro : 0
         * pro_type : 0
         * joined : 1496826926
         * timezone : UTC
         * referrer : 0
         * balance : 0
         * paypal_email :
         * notifications_sound : 0
         * order_posts_by : 1
         * social_login : 0
         * url : https://www.zaab-d.com/Chonlakant
         * name : Chonlakant
         */

        private String user_id;
        private String username;
        private String email;
        private String first_name;
        private String last_name;
        private String avatar;
        private String cover;
        private String relationship_id;
        private String address;
        private String working;
        private String working_link;
        private Object about;
        private String school;
        private String gender;
        private String birthday;
        private String website;
        private String facebook;
        private String google;
        private String twitter;
        private String linkedin;
        private String youtube;
        private String vk;
        private String instagram;
        private String language;
        private String ip_address;
        private String follow_privacy;
        private String post_privacy;
        private String message_privacy;
        private String confirm_followers;
        private String show_activities_privacy;
        private String birth_privacy;
        private String visit_privacy;
        private String verified;
        private String lastseen;
        private String showlastseen;
        private String status;
        private String active;
        private String admin;
        private String registered;
        private String phone_number;
        private String is_pro;
        private String pro_type;
        private String joined;
        private String timezone;
        private String referrer;
        private String balance;
        private String paypal_email;
        private String notifications_sound;
        private String order_posts_by;
        private String social_login;
        private String url;
        private String name;

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
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

        public String getRelationship_id() {
            return relationship_id;
        }

        public void setRelationship_id(String relationship_id) {
            this.relationship_id = relationship_id;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getWorking() {
            return working;
        }

        public void setWorking(String working) {
            this.working = working;
        }

        public String getWorking_link() {
            return working_link;
        }

        public void setWorking_link(String working_link) {
            this.working_link = working_link;
        }

        public Object getAbout() {
            return about;
        }

        public void setAbout(Object about) {
            this.about = about;
        }

        public String getSchool() {
            return school;
        }

        public void setSchool(String school) {
            this.school = school;
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

        public String getGoogle() {
            return google;
        }

        public void setGoogle(String google) {
            this.google = google;
        }

        public String getTwitter() {
            return twitter;
        }

        public void setTwitter(String twitter) {
            this.twitter = twitter;
        }

        public String getLinkedin() {
            return linkedin;
        }

        public void setLinkedin(String linkedin) {
            this.linkedin = linkedin;
        }

        public String getYoutube() {
            return youtube;
        }

        public void setYoutube(String youtube) {
            this.youtube = youtube;
        }

        public String getVk() {
            return vk;
        }

        public void setVk(String vk) {
            this.vk = vk;
        }

        public String getInstagram() {
            return instagram;
        }

        public void setInstagram(String instagram) {
            this.instagram = instagram;
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public String getIp_address() {
            return ip_address;
        }

        public void setIp_address(String ip_address) {
            this.ip_address = ip_address;
        }

        public String getFollow_privacy() {
            return follow_privacy;
        }

        public void setFollow_privacy(String follow_privacy) {
            this.follow_privacy = follow_privacy;
        }

        public String getPost_privacy() {
            return post_privacy;
        }

        public void setPost_privacy(String post_privacy) {
            this.post_privacy = post_privacy;
        }

        public String getMessage_privacy() {
            return message_privacy;
        }

        public void setMessage_privacy(String message_privacy) {
            this.message_privacy = message_privacy;
        }

        public String getConfirm_followers() {
            return confirm_followers;
        }

        public void setConfirm_followers(String confirm_followers) {
            this.confirm_followers = confirm_followers;
        }

        public String getShow_activities_privacy() {
            return show_activities_privacy;
        }

        public void setShow_activities_privacy(String show_activities_privacy) {
            this.show_activities_privacy = show_activities_privacy;
        }

        public String getBirth_privacy() {
            return birth_privacy;
        }

        public void setBirth_privacy(String birth_privacy) {
            this.birth_privacy = birth_privacy;
        }

        public String getVisit_privacy() {
            return visit_privacy;
        }

        public void setVisit_privacy(String visit_privacy) {
            this.visit_privacy = visit_privacy;
        }

        public String getVerified() {
            return verified;
        }

        public void setVerified(String verified) {
            this.verified = verified;
        }

        public String getLastseen() {
            return lastseen;
        }

        public void setLastseen(String lastseen) {
            this.lastseen = lastseen;
        }

        public String getShowlastseen() {
            return showlastseen;
        }

        public void setShowlastseen(String showlastseen) {
            this.showlastseen = showlastseen;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getActive() {
            return active;
        }

        public void setActive(String active) {
            this.active = active;
        }

        public String getAdmin() {
            return admin;
        }

        public void setAdmin(String admin) {
            this.admin = admin;
        }

        public String getRegistered() {
            return registered;
        }

        public void setRegistered(String registered) {
            this.registered = registered;
        }

        public String getPhone_number() {
            return phone_number;
        }

        public void setPhone_number(String phone_number) {
            this.phone_number = phone_number;
        }

        public String getIs_pro() {
            return is_pro;
        }

        public void setIs_pro(String is_pro) {
            this.is_pro = is_pro;
        }

        public String getPro_type() {
            return pro_type;
        }

        public void setPro_type(String pro_type) {
            this.pro_type = pro_type;
        }

        public String getJoined() {
            return joined;
        }

        public void setJoined(String joined) {
            this.joined = joined;
        }

        public String getTimezone() {
            return timezone;
        }

        public void setTimezone(String timezone) {
            this.timezone = timezone;
        }

        public String getReferrer() {
            return referrer;
        }

        public void setReferrer(String referrer) {
            this.referrer = referrer;
        }

        public String getBalance() {
            return balance;
        }

        public void setBalance(String balance) {
            this.balance = balance;
        }

        public String getPaypal_email() {
            return paypal_email;
        }

        public void setPaypal_email(String paypal_email) {
            this.paypal_email = paypal_email;
        }

        public String getNotifications_sound() {
            return notifications_sound;
        }

        public void setNotifications_sound(String notifications_sound) {
            this.notifications_sound = notifications_sound;
        }

        public String getOrder_posts_by() {
            return order_posts_by;
        }

        public void setOrder_posts_by(String order_posts_by) {
            this.order_posts_by = order_posts_by;
        }

        public String getSocial_login() {
            return social_login;
        }

        public void setSocial_login(String social_login) {
            this.social_login = social_login;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class TrendingHashtagBean {
        /**
         * id : 6
         * hash : c780032604ee179f2b4f633f2b837fc0
         * tag : เราจะสร้างชุมชนของเรา
         * last_trend_time : 1498197996
         * trend_use_num : 378
         * url : https://www.zaab-d.com/hashtag/เราจะสร้างชุมชนของเรา
         */

        private String id;
        private String hash;
        private String tag;
        private String last_trend_time;
        private String trend_use_num;
        private String url;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getHash() {
            return hash;
        }

        public void setHash(String hash) {
            this.hash = hash;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getLast_trend_time() {
            return last_trend_time;
        }

        public void setLast_trend_time(String last_trend_time) {
            this.last_trend_time = last_trend_time;
        }

        public String getTrend_use_num() {
            return trend_use_num;
        }

        public void setTrend_use_num(String trend_use_num) {
            this.trend_use_num = trend_use_num;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
