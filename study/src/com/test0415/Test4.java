package com.test0415;

import java.util.Scanner;

public class Test4 {

	public static void main(String[] args) {
		Ex4 ob= new Ex4();
		
		int n=ob.num();
		System.out.println(n);

	}

}

class Ex4{
	private Scanner sc= new Scanner(System.in);
	public int num(){
		int n = 0;
		
		try{
			System.out.println("정수?");
			n=sc.nextInt();
		}catch (Exception e){
			System.out.println("입력 오류");
		}
		return n;
	}
}
