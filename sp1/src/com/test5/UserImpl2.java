package com.test5;

public class UserImpl2 implements User {
	private String name;
	private String tel;
	private int age;

	public UserImpl2() {

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

	public UserImpl2(String name, String tel, int age) {
		this.name = name;
		this.tel = tel;
		this.age = age;

	}

	@Override
	public String result() {
		return "¿Ã∏ß:" + name + ":" + tel + ":" + age;
	}

}
