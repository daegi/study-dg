package com.test0327;

import java.util.Scanner;

public class Teste5 {

	public static void main(String[] args) {
		// ������ �����ڸ� �Է¹޾� ��Ģ������ ����
		// ��, �����ڰ� +-*/�� �ϳ��� �ƴϸ� �ٽ� �Է� �޴´�.

		int a, b;
		char ch;
		Scanner sc = new Scanner(System.in);

		System.out.println("�μ� : ");
		a = sc.nextInt();
		b = sc.nextInt();

		do {
			System.out.print("������[+-*/] : ");
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
