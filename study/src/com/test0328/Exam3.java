package com.test0328;

public class Exam3 {
	public static void main(String[] args) {
	
		for(int a=1; a<=5; a++) {
			for(int b=1; b<=5-a; b++) {
				System.out.print(" "); 
			}
			
			for(int b=1; b<=a*2-1; b++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int a=4; a>=1; a--) {
			for(int b=1; b<=5-a; b++) {
				System.out.print(" "); 
			}
			
			for(int b=1; b<=a*2-1; b++) {
				System.out.print("*");
			}
			System.out.println();
		}

		}
}