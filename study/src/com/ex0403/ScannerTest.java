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
		
		System.out.println("�̸�");
		name=sc.next();
		
		System.out.println("����");
		age = sc.nextInt();
		
		System.out.println("����");
		gender =sc.next().charAt(0);
		
		System.out.println("Ű");
		height = sc.nextDouble();
		
		

	}

}
