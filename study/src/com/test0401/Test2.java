package com.test0401;

public class Test2 {

	public static void main(String[] args) {
		
		// ��ü�����ϱ�
		Rect ob = new Rect(); //Rect() "������" = �ʱ�ȭ, �޸��Ҵ�

		// �ʵ忡 ���� �Ҵ�
		ob.width = 10;
		ob.height = 50;

		// ���̿� �ѷ� ���ϱ�
		System.out.println("����: " + ob.area());
		System.out.println("����: " + ob.len());

	}

}

// Ŭ���� �����

class Rect {
	// �ʵ�(���μ���)
	int width, height;

	// ���� ���ϱ�
	public int area() {
		return width * height;
	}

	// �ѷ� ���ϱ�
	public int len() {
		return (width + height) * 2;
	}
}