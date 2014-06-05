package com.test0409;

public class Test3 {

	public static void main(String[] args) {
		// 클래스 변수나 클래스 메소드 접근은 개체를 생성하지 않아도 클래스 이름으로 접근 가능하다.
		//클래스 변수는 메모리 해제를 프로그램 종료시
		
		System.out.println(Ex3.b); 
		Ex3.fun();
		
		//인스턴스 변수나 메소드는 반드시 객체를 생성후에 접근
		Ex3 ob =new Ex3();
		System.out.println(ob.a);
		ob.print();	

	}

}

class Ex3 {
	//필드
	int a = 10; // 인스턴스 변수(객체가 생성되어야 사용 가능)
	static int b, c = 30; /* 
							*클래스 변수(클래스가 메모리에 로딩시 메모리할당
							* 객체가 생성되지 않아도 사용가능)
							* 객체의 생성 개수와는 무관하게 한번만 메모리 할당
							*/
	
	static { // static 초기화 블럭(static 변수 초기화)
		c = 20;
	}

	// 클래스 메소드(객체가 생성되지 않아도 바로 사용가능)
	public static void fun() {
		// System.out.println(a); -> 에러(인스턴수변수는 접근불가)
		System.out.println(b + ":" + c);
		//System.out.println(this.b); <-에러(sataic 내에선 this, super 사용불가)
		// print(); -> 에러(인스턴스메소드 접근 불가"객체가 생성되야만")
		
		Ex3 oo=new Ex3();
			oo.print();
	}

	// 인스턴스 메소드(객체가 생성되야 사용가능)
	public void print() {
		System.out.println(a + ":" + b + ":" + c);
	}
}
