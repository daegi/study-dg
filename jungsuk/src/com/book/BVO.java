package com.book;

import java.io.Serializable;
import java.util.Vector;

public class BVO implements Serializable {

	private String id;
	private String name;
	private String tel;
	private String password;
	private int age;
	private Vector<String> booklist = new Vector<String>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Vector<String> getBooklist() {
		return booklist;
	}

	public void setBooklist(String bookname) {
		booklist.add(bookname);
	}
}