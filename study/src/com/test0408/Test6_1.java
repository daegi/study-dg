package com.test0408;

import java.util.Scanner;

public class Test6_1 {
	public static void main(String[] args) {
		Demo6_1 ob = new Demo6_1();

		ob.input();
		int a = ob.area();
		int b = ob.len();
		ob.print("����", a);
		ob.print("�ѷ�", b);
	}
}

class Ex6_1 {
	protected int h, w;

	public int area() {
		return h * w;
	}

	public int len() {
		return (h + w) * 2;
	}
}

class Demo6_1 extends Ex6_1 {
	private Scanner sc = new Scanner(System.in);

	public void input() {
		System.out.print("����?");
		w = sc.nextInt();
		System.out.print("����?");
		h = sc.nextInt();
	}

	public void print(String title, int result) {
		System.out.println("����:" + w + ", ����:" + h);
		System.out.println(title + ":" + result);
	}
}
