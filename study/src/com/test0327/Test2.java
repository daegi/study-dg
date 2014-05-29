package com.test0327;

import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
	/*
		int n, s, ss;

		n = 0;
		s = 0;
		ss = 0 ;
		
		while (n < 10) {

			n = n+s;
			s = s+n;
			ss = ss + s;

		}
		System.out.println(ss);
		*/
		int dan;
		int n=0;
		
		System.out.print("±¸±¸´Ü :");
		dan = sc.nextInt();
		
		while(n<=9){
			n++;
			System.out.println(dan+"*"+n+"="+(dan*n));
			
		}
		
		
		
		

	}

}
