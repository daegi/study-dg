package com.test3;

public class UserService {
	private User user;

	public void setUser(User user) {
		this.user = user;
	}

	public void write() {
		System.out.println(user.result());
	}
}
