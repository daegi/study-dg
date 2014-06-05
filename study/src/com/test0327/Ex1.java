package com.test0327;

import java.util.Scanner;

public class Ex1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a;

		System.out.print("¼ºÀû : ");
		a = sc.nextInt();
		switch (a) {

		case 90:
			System.out.println(a + ":A");
			break;
		case 80:
			System.out.println(a + ":B");
			break;
		case 70:
			System.out.println(a + ":C");
			break;
		case 60:
			System.out.println(a + ":D");
			break;
		case 50:
			System.out.println(a + ":E");
			break;
		case 40:
			System.out.println(a + ":F");
			break;
		}
	}
}
