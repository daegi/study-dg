package com.test0410;

public class Test4 {

	public static void main(String[] args) {
		/*
		 * 인터페이스는추상클래스의 일종으로 객체 생성 불가능 
		 * Inter4 x=new Inter4(); <-오류
		 * 
		 */

		// 업캐스팅 함(인터페이스는 상위 클래스와 같이 아버지)
		Inter4 ob = new Ex4();
		ob.write(); // Ex4 클래스의 메소드 실행

		// ob.print(); <-에러. Inter4에 print() 메소드가 없으므로
		// 컴파일 오류. 이런 경우에는 반드시 다운 캐스팅
		((Ex4) ob).print();// 다운 캐스팅해서 메소드 호출

		Ex4 ee = (Ex4) ob; 
		ee.print();
		
		/*
		Demo4 dd=(Demo4)ob; //런타임 오류
		dd.print();
		*/
		
		//ob는 Demo4의 객체가 아니므로 if안을 실행하지 않음
		if(ob instanceof Demo4){
			Demo4 dd=(Demo4)ob;
			dd.print();
		}
		
		
	}

}

interface Inter4 {
	public void write();
}

class Ex4 implements Inter4 {

	@Override
	public void write() {
		System.out.println("write...");

	}

	public void print() {
		System.out.println("print...");
	}
}

class Demo4 implements Inter4{

	@Override
	public void write() {
		System.out.println("Demo write....");
	}
	
	public void print(){
		System.out.println("Demo print.....");
	}
	
}
