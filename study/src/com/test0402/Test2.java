package com.test0402;

public class Test2 {
	int num = 0;

	// 합구하기
	public int sum(int n) { // n:가인수(형식 매개변수).sum() 메소드를 빠져나가면 소멸

		int s = 0;// 지역변수, 초기화 필요
		for (int i = 1; i <= n; i++)
			s += 1;
		return s;
	}

	public void sub(int i) { // 형식매개변수와 실매개변수는 기억공간을 공유하지 않음
		i = 200;
		System.out.println("sub에서" + num);
	}

	public void test() {
		num = 300;
	}
	
	public void sub1(int[] n) { //가인수가 배열
		n[1] = 200;
	}
	
	public void sub2(Test2 tt) { //가인수가 객체 
		tt.num = 700;
	}
	
	

	// static: 클래스가 로딩되는 순간 메모리 할당 받음
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 100;

		int s;
		// s=sum(i);
		Test2 t = new Test2();
		s = t.sum(i); // i: 실인수 (실매개변수)
		System.out.println("결과: " + s);

		t.test();
		
		//기본 자료형은 형식매개변수와 실매개변수는 기억장소를 공유하지 않음
		//call by value

		t.sub(i);
		System.out.println(i);
		
		
		//참조형(배열, 책체등)은 형식 매개변수와 실매개변수가 기억공간을 공유
		//call by reference
		int []nn= new int[5];
		t.sub1(nn);
		System.out.println(nn[0]);
		System.out.println(nn[1]);
		
		t.sub2(t);
		System.out.println(t.num);
		
		
		
		

	}

}
