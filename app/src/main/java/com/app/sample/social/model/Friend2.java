package com.app.sample.social.model;

import java.io.Serializable;
import java.util.List;

public class Friend2 implements Serializable {


	private String status;
	private int page;
	private int per_page;
	private int pages;
	private int total;
	private List<FriendsBean> friends;
	private List<UsersBean> users;

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

	public List<FriendsBean> getFriends() {
		return friends;
	}

	public void setFriends(List<FriendsBean> friends) {
		this.friends = friends;
	}

	public List<UsersBean> getUsers() {
		return users;
	}

	public void setUsers(List<UsersBean> users) {
		this.users = users;
	}

	public static class FriendsBean implements Serializable {


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
		private String birthday;
		private String gender;
		private String avatar;
		private String cover;
		private boolean is_following;
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

		public boolean isIs_following() {
			return is_following;
		}

		public void setIs_following(boolean is_following) {
			this.is_following = is_following;
		}

		public boolean isOnline() {
			return online;
		}

		public void setOnline(boolean online) {
			this.online = online;
		}
	}

	public static class UsersBean {


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
		private String birthday;
		private String gender;
		private String avatar;
		private String cover;
		private boolean is_following;
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

		public boolean isIs_following() {
			return is_following;
		}

		public void setIs_following(boolean is_following) {
			this.is_following = is_following;
		}

		public boolean isOnline() {
			return online;
		}

		public void setOnline(boolean online) {
			this.online = online;
		}
	}
}
