package com.test0326;

import java.util.Scanner;

public class Test4 {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		int a;
		
		System.out.print("���� :");
		a = sc.nextInt();
		
		if(a >= 90){
			System.out.println(a+":��");
		}else if (a >=80){
			System.out.println(a+":��");
		}else if (a >=70){
			System.out.println(a+":��");
		}else if (a >=60){
			System.out.println(a+":��");
		}else if (a >=50){
			System.out.println(a+":��");
		}else{
			System.out.println("�׿�");
		}
	}
}

