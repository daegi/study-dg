package com.test0415;

import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name;
		int age;

		try {
			System.out.println("�̸� :");
			name = sc.next();

			System.out.println("���� :");
			age = sc.nextInt();

			System.out.println(name + ":" + age);
		} catch (Exception e) {
			System.out.println("�Է¿���..");
		}
		System.out.println("���α׷� ����");
	}
}
