package com.test0327;

public class Test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n;
		char ch;
		
		n=0;
		ch='A';
		
		while(n<26){
			n++;
			System.out.print(ch++);
			if(n%10==0)
				System.out.println();
		}

	}

}
