package com.test0327;

public class Test6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
/*		int s=0;
		for(int n=1;n<=10; n++){
			s+=n;
		}
		System.out.println(s);
*/
		
/*		int s=0;
		for(int n=1;n<=10; n+=2){
			s+=n;
		}
		System.out.println(s);
*/
/*		int n;
		for(int n=1;n<=10; n++){
			System.out.println("¾È"+n);
		}
		System.out.println("¹Ú"+n);
*/	
/*		
		for(int n=1;n<=10;n+=2){
			System.out.println(n);
		}

//		System.out.println("¹Û:"+n);
*/		
		int s=0;
		for(int n=1; n<=10; s+=n, n++);
		System.out.println(s);
		
	}

}
