package com.test0328;

public class Test1 {

	public static void main(String[] args) {
		/*
		 * int s;
		 * 
		 * for(int a=2; a<=9;a++){ System.out.println(a+"´Ü...");
		 * 
		 * for(int b=1; b<=9; b++){ s=a*b; System.out.println(a+"*"+b+"="+s); }
		 * System.out.println("-------------------"); }
		 */
		/*
		 * for(int a=1; a<=5; a++){ for(int b=1; b<5-a; b++){
		 * System.out.println(" "); }
		 * 
		 * for(int b=1; b<=a; b++){ System.out.print("*"); }
		 * 
		 * } System.out.println();
		 */

/*		for (int a = 1; a <= 5; a++) {
			for (int b = 1; b < 5 - a; b++) {
				System.out.print(" ");
			}

			for (int b = 1; b <= a*3; b++) {
				System.out.print("*");
			}
			
			System.out.println();

		}*/
		
		for (int a = 5; a >= 1; a--) {
			for (int b = 1; b <= 5 - a; b++) {
				System.out.print(" ");
			}

			for (int b = 1; b <= a*2-1; b++) {
				System.out.print("*");
			}
			
			System.out.println();

		}
		

	}

}
