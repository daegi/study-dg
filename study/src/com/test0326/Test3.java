package com.test0326;

import java.util.Scanner;

public class Test3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a, b;
		char ch;

		System.out.print("�μ��Ϳ����� ?");
		a = sc.nextInt();
		b = sc.nextInt();
		ch = sc.next().charAt(0);

		if (ch == '+') {
			System.out.print(a + "+" + b + "=" + (a + b));
		} else if (ch == '-') {
			System.out.print(a + "+" + b + "=" + (a - b));
		} else if (ch == '*') {
			System.out.print(a + "+" + b + "=" + (a * b));
		} else if (ch == '/') {
			System.out.print(a + "+" + b + "=" + (a / b));
		} else {
			System.out.print("�Է¿���");
		}

	}

}
