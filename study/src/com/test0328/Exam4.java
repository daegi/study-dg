package com.test0328;

import java.util.Scanner;

public class Exam4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc= new Scanner(System.in);
		
		int a;
		char ch='a';
		
		System.out.print("¼ö?");
		a=sc.nextInt();
		
		for(int i=1; i<=26; i++) {
			System.out.print(ch);
			ch++;
			if(i%a==0)
				System.out.println();
		}
	}
			
}
