package com.test0409;

public class Test2 {
	public static void main(String[] args) {
		Ex2 ob1=new Ex2();
		Ex2 ob2=new Ex2();
		
		ob1.name="홍길동";
		ob1.age=10;
		
		ob2.name="홍길동";
		ob2.age=10;
		
		System.out.println(ob1);
		//
		System.out.println(ob1.toString());
		System.out.println(ob1==ob2);  // 주소비교:false
		// 
		System.out.println(ob1.equals(ob2)); // 
	}
}

class Ex2 {
	String name;
	int age;
	public void print() {
		System.out.println(name+":"+age);
	}
	
	//Object 클래스의 equals()메소드를 재정의 
	//Object 클래스의 equals()는 주소를 비교함
	@Override
	public boolean equals(Object o) {
		// 이름이 같으면 true 리턴하도록 재정의
		Ex2 s=(Ex2)o; //Objet 객체를 Ex2객체로 다운 캐스팅
		if(name == null || s.name==null)
			return false;
		
		return name.equals(s.name);
	}
	//Object의 toString() 메소드를 재정의
	//Object의 toString()은 클래스명@해쉬코드로 리턴함
	@Override
	public String toString() {
		//이름과 나이를 출력하도록 재정의 함
		String s;
		if(name==null)
			return null;
		
		s=name+"님의 나잉"+age+"세입니다.";
		
		return s;
	}
	
}
