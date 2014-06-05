package com.test0408;

public class Test8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Ex8 oo = new Ex8();

		oo.print();
		oo.sub();

	}

}

class Ex8 {
	private int a = 10, b = 20;

	public void print() {
		System.out.println("super:" + a + ":" + b);
	}

	public void sub() {
		System.out.println("super sub()");
	}
}

/*
 * 
 * 재정의? 
 * 
 * - Override(재정의) 상위 클래스의 메소드를 재정의 메소드 
 * 이름, 리턴타입, 인수의 자료형 및 개수가 동일하며 접근제어자는 크거나
 * 같아야 한다. (다형성)
 * --상위 클래스 print() 메소드를 하위 클래스에서 정의한 경우
 * 
 * public void print(){} -> 재정의 
 * public int print(){return 0} -> 오류(리턴타입이다름) 
 * void print(){}//오류(접근제어자는 크거나 같아야함) 
 * public void print(int a){}
 */

class Demo8 extends Ex8 {
	private int b = 200, c = 300;

	public void print() {
		System.out.println("서브클래스:" + b + ":" + c);
	}

	public void fun() {
		System.out.println("sub class");
	}
}
