package com.test0409;

public class Test1 {
	public static void main(String[] args) {
		Ex2 ob1=new Ex2();
		Ex2 ob2=new Ex2();
		
		ob1.name="홍길동";
		ob1.age=10;
		
		ob2.name="홍길동";
		ob2.age=10;
		
		System.out.println(ob1);
		// Object toString() : 클래스이름@해쉬코드
		System.out.println(ob1.toString());
		System.out.println(ob1==ob2);  // 주소비교:false
		// Object equals() : 주소비교
		System.out.println(ob1.equals(ob2)); // false
	}
}

class Ex1 {
	String name;
	int age;
	public void print() {
		System.out.println(name+":"+age);
	}
}
