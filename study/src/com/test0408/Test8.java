package com.test0408;

public class Test8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Ex8 oo = new Ex8();

		oo.print();
		oo.sub();

	}

}

class Ex8 {
	private int a = 10, b = 20;

	public void print() {
		System.out.println("super:" + a + ":" + b);
	}

	public void sub() {
		System.out.println("super sub()");
	}
}

/*
 * 
 * ������? 
 * 
 * - Override(������) ���� Ŭ������ �޼ҵ带 ������ �޼ҵ� 
 * �̸�, ����Ÿ��, �μ��� �ڷ��� �� ������ �����ϸ� ���������ڴ� ũ�ų�
 * ���ƾ� �Ѵ�. (������)
 * --���� Ŭ���� print() �޼ҵ带 ���� Ŭ�������� ������ ���
 * 
 * public void print(){} -> ������ 
 * public int print(){return 0} -> ����(����Ÿ���̴ٸ�) 
 * void print(){}//����(���������ڴ� ũ�ų� ���ƾ���) 
 * public void print(int a){}
 */

class Demo8 extends Ex8 {
	private int b = 200, c = 300;

	public void print() {
		System.out.println("����Ŭ����:" + b + ":" + c);
	}

	public void fun() {
		System.out.println("sub class");
	}
}
