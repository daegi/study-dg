package com.test0415;

import java.util.Iterator;
import java.util.Vector;

public class Test9 {

	public static void main(String[] args) {
		// Vector<> v = new Vector<>(); ----> JDK 1.7
		// 배열과 유사, 순사가 있음
		Vector<String> v = new Vector<String>();
		System.out.println("벡터의 초기 크기:" + v.capacity());

		// 벡터에 데이터 추가
		v.add("서울");	//벡터에 서울을 저장하것이 아니라 서울의 주소를 저장
		v.add("부산");
		v.add("대구");
		v.add("광주");
		v.add("인천");

		System.out.println("요소의 개수:" + v.size());

		// 첫번째 요소 가져오기
		System.out.println("처음: " + v.get(0));
		System.out.println("처음: " + v.firstElement());

		// 마지막 요소 가져오기
		System.out.println("마지막: " + v.get(v.size() - 1));
		System.out.println("마지막: " + v.lastElement());
		
		// 처음요소 변경
		v.set(0,"seoul");
		
		//1인덱스에 추가 
		v.add(1, "대한");
		
		// 제거 v.remove("대한")
		v.remove(1);

		String s;
		// 처음부터 끝까지 모든 데이터 가져오기
		System.out.println("모든 데이터 방법 1....");
		for (int i = 0; i < v.size(); i++) {
			s = v.get(i);
			System.out.println(s);
		}
		System.out.println();

		System.out.println("모든 데이터 방법 2....");
		for (String ss : v)
			System.out.println(ss);
		System.out.println();

		System.out.println("모든 데이터 방법 3....");
		Iterator<String> it = v.iterator(); // 반복자
		while (it.hasNext()) { // 데이터가 존재하면
			s = it.next();
			System.out.println(s);
		}
		System.out.println();
		
		
		//다지우기
		v.clear();
		System.out.println(v.size());

	}

}
