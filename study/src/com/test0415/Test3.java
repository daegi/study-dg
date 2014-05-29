package com.test0415;

import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name;
		int age;

		try {
			System.out.println("이름 :");
			name = sc.next();

			System.out.println("나이 :");
			age = sc.nextInt();

			System.out.println(name + ":" + age);
		} catch (Exception e) {
			System.out.println("입력오류..");
		}
		System.out.println("프로그램 종료");
	}
}
