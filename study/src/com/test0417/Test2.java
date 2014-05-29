package com.test0417;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

public class Test2 {
	public static void main(String[] args) {
		TreeSet<Ex2> list = new TreeSet<Ex2>();
		// ArrayList<Ex2>list=new ArrayList<Ex2>();
		list.add(new Ex2("홍길동", 20));
		list.add(new Ex2("이기자", 10));
		list.add(new Ex2("자바", 30));
		// Collections.sort(list);


		for (Ex2 ee : list) {
			System.out.println(ee.getName() + ":" + ee.getAge());
		}
	}
}

class Ex2 implements Comparable<Ex2> {
	private String name;
	private int age;

	public Ex2() {
	}

	public Ex2(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int compareTo(Ex2 o) {
		return name.compareTo(o.getName());
	}
}
