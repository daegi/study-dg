package com.ex0403;

import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc =new Scanner(System.in);
		
		String name;
		
		int age;
		char gender;
		double height;
		
		System.out.println("이름");
		name=sc.next();
		
		System.out.println("나이");
		age = sc.nextInt();
		
		System.out.println("성별");
		gender =sc.next().charAt(0);
		
		System.out.println("키");
		height = sc.nextDouble();
		
		

	}

}
