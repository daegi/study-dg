package com.test0326;

import java.util.Scanner;

public class Test2 {
	public static void main(String[] args){
	Scanner sc=new Scanner(System.in);
	int n;
	String s;
	
	System.out.print("���� : ");
	n=sc.nextInt();
	if(n%4==0&&n%100!=0||n%400==0){
		s="����";
	}else{
		s="���";
	}
	System.out.println(n+":"+s);
	}
}
