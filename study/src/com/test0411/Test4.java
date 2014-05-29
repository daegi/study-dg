package com.test0411;

public class Test4 {
	public static void main(String[] args) {
		Ex4 ee=new Ex4();
		ee.fun();
		
		ee.write();
		
	}
}

interface Inter4 {
	public void print();
}

class Ex4 {
	public void fun() {
		// Inter4 ob=new Inter4(); // 에러(인터페이스는객체생성불가)
		
		// 인터페이스를 이용한 익명 클래스 예제
		Inter4 ob=new Inter4() {
			@Override
			public void print() {
				System.out.println("익명(무명) 클래스 예제 입니다.");
			}
		};
		
		ob.print();
	}
	
	public void write() {
		//  익명의 클래스 작성 방법
		/*
		 상위클래스이름 객체명=new 상위클래스() {
		      // 해당메소드 재정의
		 };
		 */
		Object ob=new Object() {
			@Override
			public String toString() {
				return "예제................";
			}
		};
		
		System.out.println(ob.toString());
		
		
	}
}


