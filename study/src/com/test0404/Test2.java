package com.test0404;

public class Test2 {

	public static void main(String[] args) {

	}
}

class Ex2 {

	int a, b = 10, c;
	// a=10;// ���� ���๮�� �ü� ����

	{
		// �ʱ�ȭ ��
		// 1. ������ ȣ�� ->�޸� �Ҵ�->�ʱ�ȭ�� ����-> ������ ���� �ڵ� ����

		System.out.println("����� �ɱ�..");
		a = 5;
	}

	public Ex2() {
		System.out.println("������");
		c = 100;
	}

	public void print() {

		System.out.println(a + ":" + b + ":" + c);

	}
}
