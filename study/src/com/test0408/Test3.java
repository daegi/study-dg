package com.test0408;

public class Test3 {
	public static void main(String[] args) {
		Demo4 o1 = new Demo4();
		o1.print();
		o1.write();

		Demo4 o2 = new Demo4(33, 55);
		o2.print();
		o2.write();
	}
}

class Ex3 {
	int a, b;

	public Ex3() {
		a = 10;
		b = 20;
		System.out.println("슈퍼 인자 없는 생성자..");
	}

	public Ex3(int a, int b) {
		this.a = a;
		this.b = b;
		System.out.println("슈퍼 인자 있는 생성자..");
	}

	public void print() {
		System.out.println(a + ":" + b);
	}
}

class Demo3 extends Ex3 {
	// super(); 가 생략되어 있음(슈퍼클래스의 생성자를 부름)
	int b, c;

	public Demo3() {
		
		//spuer(); 가 생략되어 있음(슈퍼클래스의 생성자를 부름)
		b = 100;
		c = 200;
		System.out.println("인자없는생성자...");
	}

	public Demo3(int b, int c) {
		super(777, 888); //슈퍼클래스 생성자를 명시적으로 호출
		//단한번만 최상위에서 호출할수 있음
		
		// super(); 가 생략되어 있음(슈퍼클래스의 생성자를 부름)
		this.b = b;
		this.c = c;
		System.out.println("인자있는생성자...");
	}

	public void write() {
		System.out.println(a + ":" + b + ":" + c);
		System.out.println(super.b);
	}
}
