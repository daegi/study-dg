package com.test0328;

import java.util.Random;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Random rnd= new Random();
		
		int n;
		
		for(int i=1; i<=10;i++){
			for(int j=1; j<=10; j++){
				n=rnd.nextInt(100)+1;
				System.out.printf("%5d",n);
			}
			System.out.println();
		}
		
		System.out.println("\n\n");
		for(int i=1; i<=10; i++){
			for(int j=1; j<=10;j++){
				n=(int)(Math.random()*100)+1;
				System.out.printf("%5d",n);
				
			}
			System.out.println();
		}
	}
}
