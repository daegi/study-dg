package com.test0414;

public class Test3 {

	public static void main(String[] args) throws Exception{
		//class Ŭ���� : Ŭ������ ���� ����
		Class<?> cls = Class.forName("com.test0414.Ex3");
				
		//��ü����
		
		Object ob=cls.newInstance();
		
		//�ٿ�ĳ����
		Ex3 ee=(Ex3)ob;
		ee.write();
	}
}


class Ex3 {
	private int a, b;
	public void write(){
		System.out.println("�׽�Ʈ....");
	}
}
