package com.test0326;

import java.util.Scanner;

public class test1 {

	public static void main(String[] args) {
	
	Scanner sc=new Scanner(System.in);
	int n;
	String s;
	
	System.out.print("Á¤¼ö :");
	n=sc.nextInt();
	
	s="È¦¼ö";
	if(n%2==0){
		s="Â¦¼ö";
	}
	System.out.println(s);

	}

}
