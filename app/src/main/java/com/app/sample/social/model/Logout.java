package com.app.sample.social.model;

/**
 * Created by Bas on 6/23/2017 AD.
 */

public class Logout {


    /**
     * api_status : 200
     * api_text : success
     * api_version : 1.4.4
     * messages : {"respond_message":"Successfully logged out.."}
     */

    private String api_status;
    private String api_text;
    private String api_version;
    private MessagesBean messages;

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

    public MessagesBean getMessages() {
        return messages;
    }

    public void setMessages(MessagesBean messages) {
        this.messages = messages;
    }

    public static class MessagesBean {
        /**
         * respond_message : Successfully logged out..
         */

        private String respond_message;

        public String getRespond_message() {
            return respond_message;
        }

        public void setRespond_message(String respond_message) {
            this.respond_message = respond_message;
        }
    }
}
