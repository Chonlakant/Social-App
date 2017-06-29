package com.app.sample.social.model;

/**
 * Created by Bas on 6/28/2017 AD.
 */

public class UserProfile {


    /**
     * api_status : 200
     * api_text : success
     * api_version : 1.4.4
     * user_data : {"user_id":"166","username":"korrio","email":"idolkorrio@gmail.com","first_name":"Korr","last_name":"AQ","avatar":"https://www.zaab-d.com/upload/photos/2017/06/Lr6ENMZHDj239JjwjfZq_09_e7d9de7035937e5b9f4d3ee4f25668a1_avatar.jpg","cover":"https://www.zaab-d.com/upload/photos/d-cover.jpg","relationship_id":"0","address":"","working":"","working_link":"","about":null,"school":"","gender":"male","birthday":"1969-1-1","website":"","facebook":"","google":"","twitter":"","linkedin":"","youtube":"","vk":"","instagram":"","language":"thai","ip_address":"110.168.6.8","follow_privacy":"0","post_privacy":"ifollow","message_privacy":"0","confirm_followers":"0","show_activities_privacy":"1","birth_privacy":"0","visit_privacy":"0","verified":"0","lastseen":"1498659942","showlastseen":"1","status":"0","active":"1","admin":"0","registered":"6/2017","phone_number":"","is_pro":"0","pro_type":"0","joined":"1497021051","timezone":"UTC","referrer":"0","balance":"0","paypal_email":"","notifications_sound":"0","order_posts_by":"1","social_login":"0","url":"https://www.zaab-d.com/korrio","name":"Korr AQ","is_following":0,"can_follow":1,"post_count":"24","gender_text":"ชาย","lastseen_time_text":"2 ชั่วโมง ที่ผ่านมา","is_blocked":false}
     */

    private String api_status;
    private String api_text;
    private String api_version;
    private UserDataBean user_data;

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

    public UserDataBean getUser_data() {
        return user_data;
    }

    public void setUser_data(UserDataBean user_data) {
        this.user_data = user_data;
    }

    public static class UserDataBean {
        /**
         * user_id : 166
         * username : korrio
         * email : idolkorrio@gmail.com
         * first_name : Korr
         * last_name : AQ
         * avatar : https://www.zaab-d.com/upload/photos/2017/06/Lr6ENMZHDj239JjwjfZq_09_e7d9de7035937e5b9f4d3ee4f25668a1_avatar.jpg
         * cover : https://www.zaab-d.com/upload/photos/d-cover.jpg
         * relationship_id : 0
         * address :
         * working :
         * working_link :
         * about : null
         * school :
         * gender : male
         * birthday : 1969-1-1
         * website :
         * facebook :
         * google :
         * twitter :
         * linkedin :
         * youtube :
         * vk :
         * instagram :
         * language : thai
         * ip_address : 110.168.6.8
         * follow_privacy : 0
         * post_privacy : ifollow
         * message_privacy : 0
         * confirm_followers : 0
         * show_activities_privacy : 1
         * birth_privacy : 0
         * visit_privacy : 0
         * verified : 0
         * lastseen : 1498659942
         * showlastseen : 1
         * status : 0
         * active : 1
         * admin : 0
         * registered : 6/2017
         * phone_number :
         * is_pro : 0
         * pro_type : 0
         * joined : 1497021051
         * timezone : UTC
         * referrer : 0
         * balance : 0
         * paypal_email :
         * notifications_sound : 0
         * order_posts_by : 1
         * social_login : 0
         * url : https://www.zaab-d.com/korrio
         * name : Korr AQ
         * is_following : 0
         * can_follow : 1
         * post_count : 24
         * gender_text : ชาย
         * lastseen_time_text : 2 ชั่วโมง ที่ผ่านมา
         * is_blocked : false
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
        private int is_following;
        private int can_follow;
        private String post_count;
        private String gender_text;
        private String lastseen_time_text;
        private boolean is_blocked;

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

        public int getIs_following() {
            return is_following;
        }

        public void setIs_following(int is_following) {
            this.is_following = is_following;
        }

        public int getCan_follow() {
            return can_follow;
        }

        public void setCan_follow(int can_follow) {
            this.can_follow = can_follow;
        }

        public String getPost_count() {
            return post_count;
        }

        public void setPost_count(String post_count) {
            this.post_count = post_count;
        }

        public String getGender_text() {
            return gender_text;
        }

        public void setGender_text(String gender_text) {
            this.gender_text = gender_text;
        }

        public String getLastseen_time_text() {
            return lastseen_time_text;
        }

        public void setLastseen_time_text(String lastseen_time_text) {
            this.lastseen_time_text = lastseen_time_text;
        }

        public boolean isIs_blocked() {
            return is_blocked;
        }

        public void setIs_blocked(boolean is_blocked) {
            this.is_blocked = is_blocked;
        }
    }
}
