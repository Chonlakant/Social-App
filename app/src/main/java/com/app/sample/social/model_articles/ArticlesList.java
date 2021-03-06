package com.app.sample.social.model_articles;

import java.util.List;

/**
 * Created by Bas on 6/14/2017 AD.
 */

public class ArticlesList {

    private int status;
    private List<HtmlBean> html;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<HtmlBean> getHtml() {
        return html;
    }

    public void setHtml(List<HtmlBean> html) {
        this.html = html;
    }

    public static class HtmlBean {

        private String id;
        private String user;
        private String title;
        private String content;
        private String description;
        private String posted;
        private String category;
        private String thumbnail;
        private String view;
        private String shared;
        private String tags;
        private AuthorBean author;
        private String url;
        private String category_link;
        private String category_name;
        private boolean is_post_admin;
        private List<String> tags_array;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPosted() {
            return posted;
        }

        public void setPosted(String posted) {
            this.posted = posted;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public String getView() {
            return view;
        }

        public void setView(String view) {
            this.view = view;
        }

        public String getShared() {
            return shared;
        }

        public void setShared(String shared) {
            this.shared = shared;
        }

        public String getTags() {
            return tags;
        }

        public void setTags(String tags) {
            this.tags = tags;
        }

        public AuthorBean getAuthor() {
            return author;
        }

        public void setAuthor(AuthorBean author) {
            this.author = author;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getCategory_link() {
            return category_link;
        }

        public void setCategory_link(String category_link) {
            this.category_link = category_link;
        }

        public String getCategory_name() {
            return category_name;
        }

        public void setCategory_name(String category_name) {
            this.category_name = category_name;
        }

        public boolean isIs_post_admin() {
            return is_post_admin;
        }

        public void setIs_post_admin(boolean is_post_admin) {
            this.is_post_admin = is_post_admin;
        }

        public List<String> getTags_array() {
            return tags_array;
        }

        public void setTags_array(List<String> tags_array) {
            this.tags_array = tags_array;
        }

        public static class AuthorBean {
            /**
             * user_id : 2
             * username : skjoey
             * email : sakda.choommanee@gmail.com
             * password : 35313b37bae05e3b4fcf4783bc26c645
             * first_name :
             * last_name :
             * avatar : https://www.zaab-d.com/upload/photos/2017/05/qo4kRiO6KP5vkOTOHO5h_14_f4c6133640a5a144793149842df31b4f_avatar.jpg
             * cover : https://www.zaab-d.com/upload/photos/2017/05/Kh1aKxI3sDpKu94d2ZwA_19_65f50fc75a0577a72f7478aa95b711e4_cover.jpg
             * background_image :
             * background_image_status : 0
             * relationship_id : 0
             * address :
             * working :
             * working_link :
             * about : null
             * school :
             * gender : male
             * birthday : 00-00-0000
             * country_id : 0
             * website :
             * facebook : https://www.facebook.com/skjoey
             * google :
             * twitter :
             * linkedin :
             * youtube :
             * vk :
             * instagram :
             * language : thai
             * email_code : c18e656845aed5974e4fa991dd5b749a
             * src : site
             * ip_address : 171.97.201.123
             * follow_privacy : 0
             * post_privacy : ifollow
             * message_privacy : 0
             * confirm_followers : 0
             * show_activities_privacy : 1
             * birth_privacy : 0
             * visit_privacy : 0
             * verified : 0
             * lastseen : 1497330693
             * showlastseen : 1
             * emailNotification : 1
             * e_liked : 1
             * e_wondered : 1
             * e_shared : 1
             * e_followed : 1
             * e_commented : 1
             * e_visited : 1
             * e_liked_page : 1
             * e_mentioned : 1
             * e_joined_group : 1
             * e_accepted : 1
             * e_profile_wall_post : 1
             * status : 0
             * active : 1
             * admin : 0
             * type : user
             * registered : 3/2017
             * start_up : 1
             * start_up_info : 1
             * startup_follow : 1
             * startup_image : 1
             * last_email_sent : 0
             * phone_number :
             * sms_code : 0
             * is_pro : 0
             * pro_time : 0
             * pro_type : 0
             * joined : 1489361756
             * css_file :
             * timezone : Asia/Bangkok
             * referrer : 0
             * balance : 0
             * paypal_email :
             * notifications_sound : 0
             * order_posts_by : 1
             * social_login : 0
             * avatar_org : upload/photos/2017/05/qo4kRiO6KP5vkOTOHO5h_14_f4c6133640a5a144793149842df31b4f_avatar.jpg
             * cover_org : upload/photos/2017/05/Kh1aKxI3sDpKu94d2ZwA_19_65f50fc75a0577a72f7478aa95b711e4_cover.jpg
             * cover_full : upload/photos/2017/05/Kh1aKxI3sDpKu94d2ZwA_19_65f50fc75a0577a72f7478aa95b711e4_cover_full.jpg
             * id : 2
             * url : https://www.zaab-d.com/skjoey
             * name : skjoey
             */

            private String user_id;
            private String username;
            private String email;
            private String password;
            private String first_name;
            private String last_name;
            private String avatar;
            private String cover;
            private String background_image;
            private String background_image_status;
            private String relationship_id;
            private String address;
            private String working;
            private String working_link;
            private Object about;
            private String school;
            private String gender;
            private String birthday;
            private String country_id;
            private String website;
            private String facebook;
            private String google;
            private String twitter;
            private String linkedin;
            private String youtube;
            private String vk;
            private String instagram;
            private String language;
            private String email_code;
            private String src;
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
            private String emailNotification;
            private String e_liked;
            private String e_wondered;
            private String e_shared;
            private String e_followed;
            private String e_commented;
            private String e_visited;
            private String e_liked_page;
            private String e_mentioned;
            private String e_joined_group;
            private String e_accepted;
            private String e_profile_wall_post;
            private String status;
            private String active;
            private String admin;
            private String type;
            private String registered;
            private String start_up;
            private String start_up_info;
            private String startup_follow;
            private String startup_image;
            private String last_email_sent;
            private String phone_number;
            private String sms_code;
            private String is_pro;
            private String pro_time;
            private String pro_type;
            private String joined;
            private String css_file;
            private String timezone;
            private String referrer;
            private String balance;
            private String paypal_email;
            private String notifications_sound;
            private String order_posts_by;
            private String social_login;
            private String avatar_org;
            private String cover_org;
            private String cover_full;
            private String id;
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

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
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

            public String getBackground_image() {
                return background_image;
            }

            public void setBackground_image(String background_image) {
                this.background_image = background_image;
            }

            public String getBackground_image_status() {
                return background_image_status;
            }

            public void setBackground_image_status(String background_image_status) {
                this.background_image_status = background_image_status;
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

            public String getCountry_id() {
                return country_id;
            }

            public void setCountry_id(String country_id) {
                this.country_id = country_id;
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

            public String getEmail_code() {
                return email_code;
            }

            public void setEmail_code(String email_code) {
                this.email_code = email_code;
            }

            public String getSrc() {
                return src;
            }

            public void setSrc(String src) {
                this.src = src;
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

            public String getEmailNotification() {
                return emailNotification;
            }

            public void setEmailNotification(String emailNotification) {
                this.emailNotification = emailNotification;
            }

            public String getE_liked() {
                return e_liked;
            }

            public void setE_liked(String e_liked) {
                this.e_liked = e_liked;
            }

            public String getE_wondered() {
                return e_wondered;
            }

            public void setE_wondered(String e_wondered) {
                this.e_wondered = e_wondered;
            }

            public String getE_shared() {
                return e_shared;
            }

            public void setE_shared(String e_shared) {
                this.e_shared = e_shared;
            }

            public String getE_followed() {
                return e_followed;
            }

            public void setE_followed(String e_followed) {
                this.e_followed = e_followed;
            }

            public String getE_commented() {
                return e_commented;
            }

            public void setE_commented(String e_commented) {
                this.e_commented = e_commented;
            }

            public String getE_visited() {
                return e_visited;
            }

            public void setE_visited(String e_visited) {
                this.e_visited = e_visited;
            }

            public String getE_liked_page() {
                return e_liked_page;
            }

            public void setE_liked_page(String e_liked_page) {
                this.e_liked_page = e_liked_page;
            }

            public String getE_mentioned() {
                return e_mentioned;
            }

            public void setE_mentioned(String e_mentioned) {
                this.e_mentioned = e_mentioned;
            }

            public String getE_joined_group() {
                return e_joined_group;
            }

            public void setE_joined_group(String e_joined_group) {
                this.e_joined_group = e_joined_group;
            }

            public String getE_accepted() {
                return e_accepted;
            }

            public void setE_accepted(String e_accepted) {
                this.e_accepted = e_accepted;
            }

            public String getE_profile_wall_post() {
                return e_profile_wall_post;
            }

            public void setE_profile_wall_post(String e_profile_wall_post) {
                this.e_profile_wall_post = e_profile_wall_post;
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

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getRegistered() {
                return registered;
            }

            public void setRegistered(String registered) {
                this.registered = registered;
            }

            public String getStart_up() {
                return start_up;
            }

            public void setStart_up(String start_up) {
                this.start_up = start_up;
            }

            public String getStart_up_info() {
                return start_up_info;
            }

            public void setStart_up_info(String start_up_info) {
                this.start_up_info = start_up_info;
            }

            public String getStartup_follow() {
                return startup_follow;
            }

            public void setStartup_follow(String startup_follow) {
                this.startup_follow = startup_follow;
            }

            public String getStartup_image() {
                return startup_image;
            }

            public void setStartup_image(String startup_image) {
                this.startup_image = startup_image;
            }

            public String getLast_email_sent() {
                return last_email_sent;
            }

            public void setLast_email_sent(String last_email_sent) {
                this.last_email_sent = last_email_sent;
            }

            public String getPhone_number() {
                return phone_number;
            }

            public void setPhone_number(String phone_number) {
                this.phone_number = phone_number;
            }

            public String getSms_code() {
                return sms_code;
            }

            public void setSms_code(String sms_code) {
                this.sms_code = sms_code;
            }

            public String getIs_pro() {
                return is_pro;
            }

            public void setIs_pro(String is_pro) {
                this.is_pro = is_pro;
            }

            public String getPro_time() {
                return pro_time;
            }

            public void setPro_time(String pro_time) {
                this.pro_time = pro_time;
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

            public String getCss_file() {
                return css_file;
            }

            public void setCss_file(String css_file) {
                this.css_file = css_file;
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

            public String getAvatar_org() {
                return avatar_org;
            }

            public void setAvatar_org(String avatar_org) {
                this.avatar_org = avatar_org;
            }

            public String getCover_org() {
                return cover_org;
            }

            public void setCover_org(String cover_org) {
                this.cover_org = cover_org;
            }

            public String getCover_full() {
                return cover_full;
            }

            public void setCover_full(String cover_full) {
                this.cover_full = cover_full;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
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
}
