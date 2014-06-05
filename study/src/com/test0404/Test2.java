package com.test0404;

public class Test2 {

	public static void main(String[] args) {

	}
}

class Ex2 {

	int a, b = 10, c;
	// a=10;// 에러 실행문이 올수 없다

	{
		// 초기화 블럭
		// 1. 생성자 호출 ->메모리 할당->초기화블럭 실행-> 생성자 내부 코드 실행

		System.out.println("여기는 될까..");
		a = 5;
	}

	public Ex2() {
		System.out.println("생성자");
		c = 100;
	}

	public void print() {

		System.out.println(a + ":" + b + ":" + c);

	}
}
