package com.app.sample.social.model;


public class Login {

    private String api_status;
    private String api_text;
    private String api_version;
    private String user_id;
    private MessagesBean messages;
    private String timezone;
    private String cookie;

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

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public MessagesBean getMessages() {
        return messages;
    }

    public void setMessages(MessagesBean messages) {
        this.messages = messages;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    public static class MessagesBean {
        /**
         * respond_message_1 : Successfully logged in, Please wait..
         */

        private String respond_message_1;

        public String getRespond_message_1() {
            return respond_message_1;
        }

        public void setRespond_message_1(String respond_message_1) {
            this.respond_message_1 = respond_message_1;
        }
    }
}
