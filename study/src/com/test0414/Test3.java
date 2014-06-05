package com.test0414;

public class Test3 {

	public static void main(String[] args) throws Exception{
		//class 클래스 : 클래스에 대한 정보
		Class<?> cls = Class.forName("com.test0414.Ex3");
				
		//객체생성
		
		Object ob=cls.newInstance();
		
		//다운캐스팅
		Ex3 ee=(Ex3)ob;
		ee.write();
	}
}


class Ex3 {
	private int a, b;
	public void write(){
		System.out.println("테스트....");
	}
}
