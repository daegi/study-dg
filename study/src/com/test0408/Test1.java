package com.test0408;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo1 ob1 =new Demo1();
		
				
		ob1.print(); //슈퍼글래스의 메소드 호출
		ob1.write(); //
		//System.out.println(e); <--sub 클래스 멤버는 접근불가
		
		// ob.a= 300; <--에러(엄마가 private)
		
		ob1.b=200;
		ob1.e=500;
		ob1.print();
		ob1.write();
		
		//상위 클래스 객체가 하위 클래스를 가르키는 것을 upcasting이라 함
		//upcasting은 언제나 가능
		Ex1 ob2=new Demo1();

	}

}

// super클래스
class Ex1 {
	private int a = 10;
	int b = 20;
	protected int c = 30, d = 40;

	public void print() {
		
		///System.out.println(a); <- 에러
		System.out.println(a + ":" + b + ":" + c + ":" + d);
	}
}

// Demo1은 super클래스 Ex1의 b, c, print()를 상속받음
// sub 클래스.(단일 상속만 가능)
class Demo1 extends Ex1 {
	int d = 50, e = 60;

	public void write() {
		System.out.println(b + ":" + c + ":" + d + ":" + e);
	}
}