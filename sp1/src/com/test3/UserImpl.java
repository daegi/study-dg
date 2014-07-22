package com.test3;

import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class UserImpl implements User {
	private String name;
	private Map<String, String> address;
	private List<String> hobby;

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(Map<String, String> address) {
		this.address = address;
	}

	public void setHobby(List<String> hobby) {
		this.hobby = hobby;
	}

	@Override
	public String result() {
		String s = "이름" + name + "\n주소록...\n이름 주소\n";
		Iterator<String> it = address.keySet().iterator();
		while (it.hasNext()) {
			String k = it.next();
			String v = address.get(k);
			s += k + " " + v + "\n";
		}

		s += "취미....\n";
		for (String n : hobby) {
			s += n+ " ";
		}

		return s;
	}

}
