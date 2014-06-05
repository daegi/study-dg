package com.test0403;

public class Test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
 * 생성자
 * - 객체의 메모리 할당(가장 중요)
 * - 필드의 초기화 가능
 * 
 * -클래스와 이름이 돌일해야 함
 * -생성자를 만들지 않으면(클래스에 없으면) 자바를 컴파일 시 컴파일러가 
 * 디폴트 생성자(아무런 코드도 없음)를 만듬
 * 
 * -생성자는 일반 메소드처럼 호출 될수 없으며 new를 통해 객체를 생성할 때만 가능
 * -생성자를 만들때는 return 타입이 존재하지 않음
 * 
 * 		
*/
	}

}

class Ex3{
	int a, b;
	public void print(){
		System.out.println(a+":"+b);
	}
	
	/*생성자가 존재하지 않는 Ex3 클래스는 컴파일시 다음과 같이 컴파일러가 디폴트 생성자를 만듬
	 * public EX3{        }
	 * 
	 * 
	
	*/
}
