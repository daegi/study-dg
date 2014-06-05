package com.test0418;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Test1 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();

		list.add("서울");
		list.add("부산");
		list.add("대구");
		list.add("광주");
		list.add("인천");
		list.add("대전");

		ListIterator<String> it = list.listIterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println();

		System.out.println("역순...");
		while (it.hasPrevious()) {
			System.out.println(it.previous());
		}

	}
}
