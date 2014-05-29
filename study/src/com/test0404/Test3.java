package com.test0404;

public class Test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Ex3 o1 = new Ex3();
		Ex3 o2 = new Ex3();
		
		System.out.println(o1==o2); //주소를 비교
		
		//object 의 equals()메소는 주소 비교
		System.out.println(o1.equals(o2)); //주소 비교
		
		//객체만 출력 하면 실제로 Object 클래스의 toString()
		//메소드를 출력 하면 클래스 이름@해쉬코드를 출력
		System.out.println(o1);
		System.out.println(o1.toString());

	}

}

//Ex3 super 클래스 : Object
class Ex3{
	int a, b;
}