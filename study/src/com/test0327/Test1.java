package com.test0327;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n, s;
		/*
		 * n = s = 0; while (n < 100) { n++; s += n; } System.out.println(s);
		 */
		/*
		 * n=0; while(n<10){ n++; System.out.print(n); }
		 * System.out.println("¹Û:"+n);
		 */
		/*
		 * n = 0; while (n++ < 10) {
		 * 
		 * System.out.print(n); } System.out.println("¹Û:" + n);
		 */
		/*
		n=0;
		s=0;
		while(n<100){
			n+=2;
			s+=n;
		}
		System.out.println(s);
		*/
/*		
		n=1;
		s=0;
		while(n<100){
			s+=n;
			n+=2;
			
		}
		System.out.println(s);
	*/
		
		n =10;
		s=0;
		while(n<10){
			n++;
			s+=n;
		}
		System.out.println(n+":"+s);

	}
}
