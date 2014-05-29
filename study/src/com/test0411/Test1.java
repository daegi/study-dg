package com.test0411;

/*전시간 정링 * interface
 * 메소드가 선언만 하고 정의를 하지 안는 추상 메소드로 구성
 * static final 필드만 가능
 * interface는 다중 상속이 가능하다(클래스는 불가)
 * 
 *  -구현
 *  class 클래스명 implements 인터페이스명{
 *  }
 *  추상클래스가 아닌 경우 모든 메소드를 재정의 해야한다.
 */

public class Test1 {

	public static void main(String[] args) {
		
		Ex1 ee= new Ex1();
		ee.fun();
		
		// 다른 클래스에서 static 중첩 클래스의 객체를 생성
		// 단독으로 객체를 생성하여 사용 가능하다.
		 Ex1.Demo1 dd= new Ex1.Demo1();
		 dd.write();

	}

}



class Ex1 {
	int a = 10;
	static int b = 20;

	public void print() {
		System.out.println(a + ":" + b);
	}
	
	public void fun(){
		//static 정첩 클래스 객체 생성 및 접근
		Demo1 dd=new Demo1();
		dd.write();
	}

	// static 중첩 클래스(클래스 앞에 static 키워드는 중첩 클래스만 가능)
	static class Demo1 {
		int c = 30;

		public void write() {
			// static 중첩클래스 밖의 인스턴스 변수는 접근 불가
			// System.out.println(a); <--에러
			System.out.println(b);
			System.out.println(c);

			// 객체를 생성해서 중첩클래스 밖의 변수 및 메소드를 접근
			Ex1 oo = new Ex1();
			System.out.println(oo.a);
			oo.print();
		}
	}
}