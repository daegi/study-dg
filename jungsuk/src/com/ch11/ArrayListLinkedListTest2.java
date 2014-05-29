package com.ch11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListLinkedListTest2 {

	public static void main(String[] args) {

		ArrayList al = new ArrayList(1000000);
		LinkedList ll = new LinkedList();
		
		//al.add(100000);

		add(al);
		add(ll);

		System.out.println("���� �ð� �׽�Ʈ");
		System.out.println("ArrayList:" + access(al));
		System.out.println("LinkedList:" + access(ll));
		
		
	/*	for(int i =0; i<al.size();i++)
			System.out.println("�Ƹ���"+al.get(i));*/
	
	}
	// �迭 ����Ʈ�� 1~10000 ������ ���� �ִ´�.
	public static void add(List list) {
		for (int i = 0; i < 100000; i++)
			list.add(i + "");
	}
	// �迭�� 0~10000���� ���� ���� ���� �ð�~ ������ �ð��� �� �� �� 10000������ ���� �ִ� �ð� ����
	public static long access(List list) {
		long start = System.currentTimeMillis();  
		for (int i = 0; i < 10000; i++)
			list.get(i);
		long end = System.currentTimeMillis();
		return end - start;
	}

}
