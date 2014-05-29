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

		System.out.println("접근 시간 테스트");
		System.out.println("ArrayList:" + access(al));
		System.out.println("LinkedList:" + access(ll));
		
		
	/*	for(int i =0; i<al.size();i++)
			System.out.println("아몰라"+al.get(i));*/
	
	}
	// 배열 리스트에 1~10000 까지의 값을 넣는다.
	public static void add(List list) {
		for (int i = 0; i < 100000; i++)
			list.add(i + "");
	}
	// 배열값 0~10000까지 넣을 동안 시작 시간~ 끝나는 시간을 뺀 값 증 10000까지의 값을 넣는 시간 측정
	public static long access(List list) {
		long start = System.currentTimeMillis();  
		for (int i = 0; i < 10000; i++)
			list.get(i);
		long end = System.currentTimeMillis();
		return end - start;
	}

}
