package com.test0416;

import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
/*		
		String s;
		System.out.println("문자열?");
		while(sc.hasNext()) {
			s=sc.next();
			System.out.println(s);
		}
*/
		
		int n=-1;
		while(true) {
			try {
				System.out.print("정수?");
				n=sc.nextInt();
			} catch (Exception e) {
				System.out.println("입력 오류...");
				sc.nextLine();
			}
			
			if(n==0)
				break;
			System.out.println("n:"+n);
		}

	}

}
