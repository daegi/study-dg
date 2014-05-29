package com.test0410;

public class Test5 {

	public static void main(String[] args) {

	}

}

class Ex5{
	int a=10;
	static int b=20;
	
	public void print(){
		System.out.println(a+":"+b);
	}
	
	//static 중첩 클래스(중첩 클래스인 경우만 클래스앞에 static가능)
	static class Demo5{
		int c=30;
		public void write(){
			//static 중첩클래스는 인스턴스 변수 접근 불가
			//static 중첩클래스는 단독으로 객체 생성이 가능 하므로]
			// System.out.println(a);<--에러  
			System.out.println(b+":"+c);
		}
	}
}
