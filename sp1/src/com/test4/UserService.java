package com.test4;

public class UserService {
	private User user;

	public void setUser(User user) {
		this.user = user;
	}

	public UserService() {

	}

	public UserService(User user) {
		this.user = user;
	}

	public void write() {
		System.out.println(user.result());
	}

}
