package com.test0328;

import java.util.Scanner;

public class Exam1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a;
		int sum=0;
		
		Scanner sc=new Scanner(System.in);
		
		System.out.print("입력 : ");
		a=sc.nextInt();
		
		for(int i=1;i<= a; i++){
			
			sum+=i;
			
		}			
			System.out.println("1부터" +a+ "합은"+sum);
	}

}
