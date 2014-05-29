package com.test0408;

import java.util.Scanner;

public class Test6_1 {
	public static void main(String[] args) {
		Demo6_1 ob = new Demo6_1();

		ob.input();
		int a = ob.area();
		int b = ob.len();
		ob.print("넓이", a);
		ob.print("둘레", b);
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
		System.out.print("가로?");
		w = sc.nextInt();
		System.out.print("세로?");
		h = sc.nextInt();
	}

	public void print(String title, int result) {
		System.out.println("가로:" + w + ", 세로:" + h);
		System.out.println(title + ":" + result);
	}
}
