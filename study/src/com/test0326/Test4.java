package com.test0326;

import java.util.Scanner;

public class Test4 {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		int a;
		
		System.out.print("점수 :");
		a = sc.nextInt();
		
		if(a >= 90){
			System.out.println(a+":수");
		}else if (a >=80){
			System.out.println(a+":우");
		}else if (a >=70){
			System.out.println(a+":미");
		}else if (a >=60){
			System.out.println(a+":양");
		}else if (a >=50){
			System.out.println(a+":가");
		}else{
			System.out.println("그외");
		}
	}
}

