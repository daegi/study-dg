package com.test0326;

import java.util.Scanner;

public class Test2 {
	public static void main(String[] args){
	Scanner sc=new Scanner(System.in);
	int n;
	String s;
	
	System.out.print("연도 : ");
	n=sc.nextInt();
	if(n%4==0&&n%100!=0||n%400==0){
		s="윤년";
	}else{
		s="평년";
	}
	System.out.println(n+":"+s);
	}
}
