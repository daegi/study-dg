package com.test0417;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class Test3 {

	public static void main(String[] args) {
		// Map : <값, 키>의 형태로 저장
		// 구현클래스: Hashtable, HashMap, TreeMap등
		// Iterator 가 없다. 즉 향상된 forans 사용 불가
		// 키는 중복을 허용하지 않는다(Set)
		// 순서가 없다.
		Hashtable<Integer, String> ht = new Hashtable<Integer, String>();

		// Map 에 저장
		ht.put(new Integer(100), "서울");
		ht.put(new Integer(200), "부산");
		ht.put(new Integer(30), "대구");
		ht.put(new Integer(400), "인천");
		ht.put(new Integer(50), "광주");
		ht.put(new Integer(100), "seoul");
		System.out.println(ht);

		// Map 가저오기
		String s;
		s = ht.get(100);
		System.out.println(s);
		s = ht.get(500);
		System.out.println(s);

		// 처음부터 끝까지 모든 자료 보기
		// 키는 Set이고 키를 이용한다.
		Set<Integer> set = ht.keySet();
		Iterator<Integer> it = set.iterator();
		while (it.hasNext()) {
			Integer key = it.next();
			String value = ht.get(key);
			System.out.println(key + ":" + value);
		}
		// 키가 존재하는지 확인
		if (ht.containsKey(new Integer(100)))
			System.out.println("100키는 존재");

		// 키 제거
		ht.remove(new Integer(400));
		System.out.println(ht);

	}
}
