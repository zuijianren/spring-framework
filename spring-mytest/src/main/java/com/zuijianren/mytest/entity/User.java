package com.zuijianren.mytest.entity;

/**
 * @author 姜辞旧
 * @date 2023/2/14 11:20
 */
public class User {

	private Long userId;
	private String username;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "User{" +
				"userId=" + userId +
				", username='" + username + '\'' +
				'}';
	}
}
