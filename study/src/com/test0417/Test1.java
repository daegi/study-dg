package com.test0417;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class Test1 {

	public static void main(String[] args) {
		// Set: 중복을 허용하지 않음, 순서가 없다.
		HashSet<String> hs = new HashSet<String>();

		hs.add("서울");
		hs.add("부산");
		hs.add("대구");
		hs.add("인천");
		hs.add("광주");
		hs.add("대전");
		hs.add("울산");
		hs.add("세종");
		hs.add("서울");
		System.out.println(hs);

		Iterator<String> it = hs.iterator();
		while (it.hasNext()) {
			String s = it.next();
			System.out.println(s);
		}
		System.out.println();

		// 중복허용하지 않음. 정렬해서 저장
		TreeSet<String> ts = new TreeSet<String>();

		ts.add("서울");
		ts.add("부산");
		ts.add("대구");
		ts.add("인천");
		ts.add("광주");
		ts.add("대전");
		ts.add("울산");
		ts.add("세종");
		System.out.println(ts);

	}

}
