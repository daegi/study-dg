package com.test0327;

import java.util.Scanner;

public class Teste5 {

	public static void main(String[] args) {
		// 정수와 연산자를 입력받아 사칙연산을 실행
		// 단, 연산자가 +-*/중 하나가 아니면 다시 입력 받는다.

		int a, b;
		char ch;
		Scanner sc = new Scanner(System.in);

		System.out.println("두수 : ");
		a = sc.nextInt();
		b = sc.nextInt();

		do {
			System.out.print("연산자[+-*/] : ");
			ch = sc.next().charAt(0);
		} while (ch != '+' && ch != '-' && ch != '*' && ch != '/');

		if (ch == '+')
			System.out.println(a + "+" + b + "=" + (a + b));
		else if (ch == '-')
			System.out.println(a + "+" + b + "=" + (a - b));
		else if (ch == '*')
			System.out.println(a + "+" + b + "=" + (a * b));
		else if (ch == '/')
			System.out.println(a + "+" + b + "=" + (a / b));
	}

}
