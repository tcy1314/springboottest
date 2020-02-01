package cn.itcyw.entity;

import java.sql.Timestamp;

/**  
 * @Description: 
 * @author tcy
 * @date 2020-01-14 
*/

public class User {
	private Integer id;
	private String username;
	private String password;
	private String url;
	private String nickname;
	private String email;
	private String phone;
	private Integer role = 0;
	private Timestamp createTime;
	private Timestamp lastLoginTime;
	private String avatar;
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return the nickname
	 */
	public String getNickname() {
		return nickname;
	}
	/**
	 * @param nickname the nickname to set
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the role
	 */
	public Integer getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(Integer role) {
		this.role = role;
	}
	/**
	 * @return the createTime
	 */
	public Timestamp getCreateTime() {
		return createTime;
	}
	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	/**
	 * @return the lastLoginTime
	 */
	public Timestamp getLastLoginTime() {
		return lastLoginTime;
	}
	/**
	 * @param lastLoginTime the lastLoginTime to set
	 */
	public void setLastLoginTime(Timestamp lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	/**
	 * @return the avatar
	 */
	public String getAvatar() {
		return avatar;
	}
	/**
	 * @param avatar the avatar to set
	 */
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	/**  
	 * @Title: toString
	 * @Description: 
	 * @return 
	 * @see java.lang.Object#toString() 
	 * @author tcy
	 * @date 2020-01-14 
	 */ 
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", url=" + url + ", nickname="
				+ nickname + ", email=" + email + ", phone=" + phone + ", role=" + role + ", createTime=" + createTime
				+ ", lastLoginTime=" + lastLoginTime + ", avatar=" + avatar + "]";
	}
	
	
}
