package com.app.sample.social.model;

import java.io.Serializable;
import java.util.List;

public class Friend2 implements Serializable {

	private int api_status;
	private String api_text;
	private String api_version;
	private String theme_url;
	private List<UsersBean> users;
	private List<?> online;

	public int getApi_status() {
		return api_status;
	}

	public void setApi_status(int api_status) {
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

	public String getTheme_url() {
		return theme_url;
	}

	public void setTheme_url(String theme_url) {
		this.theme_url = theme_url;
	}

	public List<UsersBean> getUsers() {
		return users;
	}

	public void setUsers(List<UsersBean> users) {
		this.users = users;
	}

	public List<?> getOnline() {
		return online;
	}

	public void setOnline(List<?> online) {
		this.online = online;
	}

	public static class UsersBean {


		private String user_id;
		private String username;
		private String name;
		private String profile_picture;
		private String cover_picture;
		private String verified;
		private String lastseen;
		private String lastseen_unix_time;
		private String lastseen_time_text;
		private String url;
		private String user_platform;

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

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
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

		public String getLastseen() {
			return lastseen;
		}

		public void setLastseen(String lastseen) {
			this.lastseen = lastseen;
		}

		public String getLastseen_unix_time() {
			return lastseen_unix_time;
		}

		public void setLastseen_unix_time(String lastseen_unix_time) {
			this.lastseen_unix_time = lastseen_unix_time;
		}

		public String getLastseen_time_text() {
			return lastseen_time_text;
		}

		public void setLastseen_time_text(String lastseen_time_text) {
			this.lastseen_time_text = lastseen_time_text;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public String getUser_platform() {
			return user_platform;
		}

		public void setUser_platform(String user_platform) {
			this.user_platform = user_platform;
		}
	}
}
