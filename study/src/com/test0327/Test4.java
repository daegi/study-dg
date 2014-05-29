package com.test0327;

public class Test4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n, s;
	/*	
		n=s=0;
		
		do{
			n++;
			s+=n;
		}while{n<100);
		System.out.print(s);
		}
	*/
		n=10;
		while(n<10){
			n++;
			System.out.println("while 안:"+n);
		}
		System.out.println("while 밖"+n);
		
		n=10;
		do{
			n++;
			System.out.println("do while안"+n);
		}while(n<10);
		System.out.println("do while밖"+n);
			
	}

}
