package com.test0408;

public class Test4 {
	public static void main(String[] args) {
		Demo4 o1=new Demo4();
		o1.print();
		o1.write();
		
		Demo4 o2=new Demo4(33, 55);
		o2.print();
		o2.write();
	}
}

class Ex4{
	int a, b;
	// ���ڰ� �ִ� �����ڸ� ����Ŭ������ ����
	public Ex4(int a, int b) {
		this.a=a; this.b=b;
		System.out.println("���� ���� �ִ� ������..");
	}
	public void print() {
		System.out.println(a+":"+b);
	}
}

class Demo4 extends Ex4 {
	int b, c;
	public Demo4() {
		super(1,2); 
		// ȣ������ ������ super(); �� �����Ǿ� 
		//  ����Ŭ������ ���ڰ� ���� �����ڸ� ȣ��������
		//  ����Ŭ�������� ���ڰ� ���� �����ڰ� �����Ƿ� ����
		b=100; c=200;
		System.out.println("���ھ��»�����...");
	}
	public Demo4(int b, int c) {
		super(777, 888); // ����Ŭ���������ڸ� ��������� ȣ��
		                // ���ѹ��� �ֻ������� ȣ���Ҽ�����
		// ȣ������ ������ super(); �� �����Ǿ� ����(����Ŭ������ �����ڸ� �θ�)
		this.b=b;  this.c=c;
		System.out.println("�����ִ»�����...");
	}
	public void write() {
		System.out.println(a+":"+b+":"+c);
		System.out.println(super.b);
	}
}

