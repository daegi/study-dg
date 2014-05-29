package com.test0416;

import java.util.Collections;
import java.util.Vector;

public class Test4 {
	public static void main(String[] args) {
		Vector<String> vv=new Vector<String>();
		
		vv.add("서울");
		vv.add("부산");
		vv.add("대구");
		vv.add("광주");
		vv.add("인천");
		
		System.out.println("벡터내용...");
		for(String s:vv)
			System.out.print(s+"   ");
		System.out.println();
		
		// 순차검색
		if(vv.contains("부산")) { // 존재하면
			int i=vv.indexOf("부산"); // 존재하는것의 위치
			System.out.println(i+"인덱스에 존재");
		}
		
		// 정렬
		Collections.sort(vv);
		System.out.println("오름차순정렬...");
		for(String s:vv)
			System.out.print(s+"   ");
		System.out.println();
		
		// 이분검색(검색할 자료로 정렬되어있어야함)
		int idx=Collections.binarySearch(vv, "대구");
		// 없으면 idx=-1
		if(idx!=-1)
			System.out.println("검색결과:"+vv.get(idx));
		
		Collections.sort(vv, Collections.reverseOrder());
		System.out.println("내림차순정렬...");
		for(String s:vv)
			System.out.print(s+"   ");
		System.out.println();
		
	
		
		
		
		
	}
}
