package com.test0326;

import java.util.Scanner;

public class Test5 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int a, b, c, temp;
		
		System.out.print("¼¼¼ö :");
		a=sc.nextInt();
		b=sc.nextInt();
		c=sc.nextInt();
		
		if (a > b){
			temp=a;
			b=a;
			b=temp;
		} 
		if (a > c){
			temp=a;
			a=c;
			c=temp;
		}
		if (b > c){
			temp=b;
			b=c;
			c=temp;
		}
		System.out.println(a+":"+b+":"+c);
	}
}
