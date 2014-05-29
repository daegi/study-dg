package com.test0410;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex2 ob = new Ex2();
		ob.print(10);
		ob.write();
		
		
		Inter1 ii=ob; //업캐스팅
		ii.write();

	}
}
/*
 * interface는 선언만 있고 정의가 없는 추상클래스의 일종이다.
 * -필드는 final 변수만 가능하며 final을 붙이지 않아도 final
 * -접근제어자를 붙이지 않아도 public 
 * -메소드는 선언만 가능.(abstract 메소드임)
 * -인터페이스는 다중 상속이 가능하다.
 * -인터페이스를 구현한 클래스는 반드시 인터페이스의 모든
 * 메소드를 재정의 해야 한다.(단, 추상 클래스는 예외)
 * -자바의 다중 상속이 지원되지 않는 것을 인터페이스로
 * 해결할 수 있다.
*/

interface Inter1{
	int a=10;

	// public int c;  <오류(flnal 변수만 가능하며 반드시 초기화)
	public int b=20;
	
	public void print(int n);
	public abstract void write(); //abstract 생략해도 abstract 	
}

// 인터페이스 구현(2개이상 구현 가능)
// 추상클래스가 아닌경우 인터페이스의 모든 메소드를 재정의 해야함
class Ex2 implements Inter1{

	@Override
	public void print(int n) {
		// TODO Auto-generated method stub
		System.out.println(n);
		
	}

	@Override
	public void write() {
		// TODO Auto-generated method stub
		System.out.println("출력...");
		
	}
}
		