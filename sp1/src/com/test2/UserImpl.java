package com.test2;

public class UserImpl implements User {
	private String name;
	private String tel;
	private int age;

	public UserImpl() {

	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public UserImpl(String name, String tel, int age) {
		this.name = name;
		this.tel = tel;
		this.age = age;

	}

	@Override
	public String result() {
		return name + ":" + tel + ":" + age;
	}

}
