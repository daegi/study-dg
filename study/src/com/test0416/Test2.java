package com.test0416;

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String name, tel;
		int age;

		System.out.println("이름?");
		name = sc.nextLine();
		System.out.println("나이?");
		age = sc.nextInt();
		sc.nextLine(); //엔터를 버리기 위한..
		System.out.println("전화?");
		tel = sc.nextLine();

		System.out.println(name + ":" + age + ":" + tel);

	}

}
