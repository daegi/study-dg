package com.test0418;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Test1 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();

		list.add("����");
		list.add("�λ�");
		list.add("�뱸");
		list.add("����");
		list.add("��õ");
		list.add("����");

		ListIterator<String> it = list.listIterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println();

		System.out.println("����...");
		while (it.hasPrevious()) {
			System.out.println(it.previous());
		}

	}
}
