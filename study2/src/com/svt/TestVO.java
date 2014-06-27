package com.svt;

public class TestVO {

	private int num;
	private String name;
	private String subject;

	public TestVO() {

	}

	public TestVO(int num, String name, String subject) {
		this.num = num;
		this.name = name;
		this.subject = subject;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
}
