package com.test0408;

public class Test4 {
	public static void main(String[] args) {
		Demo4 o1=new Demo4();
		o1.print();
		o1.write();
		
		Demo4 o2=new Demo4(33, 55);
		o2.print();
		o2.write();
	}
}

class Ex4{
	int a, b;
	// 인자가 있는 생성자만 슈퍼클래스에 존재
	public Ex4(int a, int b) {
		this.a=a; this.b=b;
		System.out.println("슈퍼 인자 있는 생성자..");
	}
	public void print() {
		System.out.println(a+":"+b);
	}
}

class Demo4 extends Ex4 {
	int b, c;
	public Demo4() {
		super(1,2); 
		// 호출하지 않으면 super(); 가 생략되어 
		//  슈퍼클래스의 인자가 없는 생성자를 호출하지만
		//  슈퍼클래스에는 인자가 없는 생성자가 없으므로 오류
		b=100; c=200;
		System.out.println("인자없는생성자...");
	}
	public Demo4(int b, int c) {
		super(777, 888); // 슈퍼클래스생성자를 명시적으로 호출
		                // 단한번만 최상위에서 호출할수있음
		// 호출하지 않으면 super(); 가 생략되어 있음(슈퍼클래스의 생성자를 부름)
		this.b=b;  this.c=c;
		System.out.println("인자있는생성자...");
	}
	public void write() {
		System.out.println(a+":"+b+":"+c);
		System.out.println(super.b);
	}
}

