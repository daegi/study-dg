package com.test0331;

public class Test2 {

	public static void main(String[] args) {
		// 배열 초기화
		
		int n[] = new int []{1,3,5,7,9};
		//int n[] = {1,3,5,7,9};
		
		
		//배열의 모든 내용 출력 방법 1
		
		for(int i=0; i<n.length; i++)
			System.out.println(n[i]);
		System.out.println();
		
		
		
		//배열의 모든 내용 출력 방법 2
				
		for(int a:n)		//향상된 for문(jdk 5.0 부터 제공) for(변수:arr)
			System.out.println(a);
	}
}
