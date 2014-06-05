package com.test0408;

public class Test3 {
	public static void main(String[] args) {
		Demo4 o1 = new Demo4();
		o1.print();
		o1.write();

		Demo4 o2 = new Demo4(33, 55);
		o2.print();
		o2.write();
	}
}

class Ex3 {
	int a, b;

	public Ex3() {
		a = 10;
		b = 20;
		System.out.println("���� ���� ���� ������..");
	}

	public Ex3(int a, int b) {
		this.a = a;
		this.b = b;
		System.out.println("���� ���� �ִ� ������..");
	}

	public void print() {
		System.out.println(a + ":" + b);
	}
}

class Demo3 extends Ex3 {
	// super(); �� �����Ǿ� ����(����Ŭ������ �����ڸ� �θ�)
	int b, c;

	public Demo3() {
		
		//spuer(); �� �����Ǿ� ����(����Ŭ������ �����ڸ� �θ�)
		b = 100;
		c = 200;
		System.out.println("���ھ��»�����...");
	}

	public Demo3(int b, int c) {
		super(777, 888); //����Ŭ���� �����ڸ� ��������� ȣ��
		//���ѹ��� �ֻ������� ȣ���Ҽ� ����
		
		// super(); �� �����Ǿ� ����(����Ŭ������ �����ڸ� �θ�)
		this.b = b;
		this.c = c;
		System.out.println("�����ִ»�����...");
	}

	public void write() {
		System.out.println(a + ":" + b + ":" + c);
		System.out.println(super.b);
	}
}
