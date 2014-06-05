package com.test0415;

import java.util.Scanner;

public class Test5 {

	public static void main(String[] args) {
		Ex5 ob= new Ex5();
		
		int n;
		try {
			n = ob.num();
			System.out.println(n);
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}

class Ex5{
	private Scanner sc= new Scanner(System.in);
	public int num() throws Exception{
		int n = 0;
		
		try{
			System.out.println("정수?");
			n=sc.nextInt();
		}catch (Exception e){
			// 강제로 예외를 발생 시킴
			throw new Exception("입력 오류....");
		}
		return n;
	}
}
