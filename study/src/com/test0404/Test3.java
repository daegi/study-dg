package com.test0404;

public class Test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Ex3 o1 = new Ex3();
		Ex3 o2 = new Ex3();
		
		System.out.println(o1==o2); //�ּҸ� ��
		
		//object �� equals()�޼Ҵ� �ּ� ��
		System.out.println(o1.equals(o2)); //�ּ� ��
		
		//��ü�� ��� �ϸ� ������ Object Ŭ������ toString()
		//�޼ҵ带 ��� �ϸ� Ŭ���� �̸�@�ؽ��ڵ带 ���
		System.out.println(o1);
		System.out.println(o1.toString());

	}

}

//Ex3 super Ŭ���� : Object
class Ex3{
	int a, b;
}