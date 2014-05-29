package com.test0327;



public class Ex2 {

	public static void main(String[] args) {

		int a=1;
		int b, m = 0;
		while (a <= 100) {
			b = a;
			m = m + b;
			System.out.print(" "+b++);
			a += 2;
			
			if (b % 10 == 0) {
				System.out.println();
			}
			if (b >= 100) {
				System.out.println(m);

			}

		}

	}

}
