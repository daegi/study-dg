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
			System.out.print("�̸�?");
			name=sc.next();
			System.out.print("����");
			age=sc.nextInt();
			if(age<0)
				throw new Exception("���̴� 0�̻�...");
			System.out.print("����[M/F]?");
			gender=sc.next().charAt(0);
			if(gender!='M'&&gender!='F')
				throw new Exception("��������...");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		System.out.println(result());
	}
	
	public String result() {
		String s=gender=='M'?"����":"����";
		return name+":"+age+":"+s;
	}
	
	
	
	
}
