package com.test0326;

import java.util.Scanner;

public class test1 {

	public static void main(String[] args) {
	
	Scanner sc=new Scanner(System.in);
	int n;
	String s;
	
	System.out.print("���� :");
	n=sc.nextInt();
	
	s="Ȧ��";
	if(n%2==0){
		s="¦��";
	}
	System.out.println(s);

	}

}
