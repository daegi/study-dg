package com.test0416;

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String name, tel;
		int age;

		System.out.println("�̸�?");
		name = sc.nextLine();
		System.out.println("����?");
		age = sc.nextInt();
		sc.nextLine(); //���͸� ������ ����..
		System.out.println("��ȭ?");
		tel = sc.nextLine();

		System.out.println(name + ":" + age + ":" + tel);

	}

}
