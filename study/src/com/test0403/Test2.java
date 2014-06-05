package com.test0403;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Ex2 e= new Ex2();
		
		e.print();

	}

}

/*
 * 오버로딩(중복정의) 메소드의 인수의 개수가 다르거나 자료형이 다른경우
 * 메소드의 이름을 같게 줄수 있다.
 * 
 * public void write(){}
 * public void write(int a){}
 * public void write(float a){}
 * public void write(int a, int b){}
 * public int write(int a){} //에러(리턴타입)
 * 
 * 
*/

class Ex2{
	public void print(){
		System.out.println("출력...");
	}
}
