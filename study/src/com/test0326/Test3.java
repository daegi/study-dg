package com.test0326;

import java.util.Scanner;

public class Test3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a, b;
		char ch;

		System.out.print("두수와연산자 ?");
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
			System.out.print("입력오류");
		}

	}

}
