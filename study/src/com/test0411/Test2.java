package com.test0411;

public class Test2 {

	public static void main(String[] args) {
		
		Ex2 ee=new Ex2();
		ee.print();
		
		// 다른 클래스에서 중첩 클래스 객체 생성
		// 단독으로는 객체를 생성 할 수 없다.
		//Ex2.Demo2 dd= new Ex2.Demo2(); <-->에러
		
		
		//외부클래스 객체를 이용하여 객체를 생성해야 함
		Ex2.Demo2 dd= ee.new Demo2();
		dd.write();

	}

}

class Ex2 {
	int a = 10;
	static int b = 20;

	public void print() {
		System.out.println(a + ":" + b);
		
		Demo2 dd= new Demo2();
		dd.write();
	}

	// 중첩클래스
	class Demo2 {
		int c = 30;
		public void write() {
			System.out.println(a);
			System.out.println(b);
			System.out.println(c);

		}
	}
}
