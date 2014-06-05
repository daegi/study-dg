package com.test0414;

import java.util.Scanner;

public class Test13 {
	public static void main(String[] args) {
		Ex13 ob=new Ex13();
		
		
			ob.input();
		
	}
}

class Ex13 {
	private String name;
	private int age;
	private char gender;
	private Scanner sc=new Scanner(System.in);
	
	public void input(){
		try {
			System.out.print("이름?");
			name=sc.next();
			System.out.print("나이");
			age=sc.nextInt();
			if(age<0)
				throw new Exception("나이는 0이상...");
			System.out.print("성별[M/F]?");
			gender=sc.next().charAt(0);
			if(gender!='M'&&gender!='F')
				throw new Exception("성별오류...");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		System.out.println(result());
	}
	
	public String result() {
		String s=gender=='M'?"남자":"여자";
		return name+":"+age+":"+s;
	}
	
	
	
	
}
