package com.test0409;

public class Test5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

// final 필드: 값을 한번만 초기화 할수 잇다.
// 일반적으로 final 필드는 static과 같이 사용하면
// 필드 명은 대문자로 만든다.
// final 메소드 : 메소드를 재정의(Override)할 수 없다.
// final 클래스 : 하위 클래스(서브 클래스)를 가질 수 없다.
// 대표적인 final 클래스 : String 
class Ex5{
	final int a=10, b; 
	public Ex5(){
		b=20;  //final 변수 초기화는 생성자 또는 초기화 블럭에서
	}
	public final void print(){
		System.out.println(a+":"+b);
	}
	public void fun(){
		// a=30; -> 에러
		
	}
}