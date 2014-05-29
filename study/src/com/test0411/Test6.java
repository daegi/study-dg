package com.test0411;

import java.text.NumberFormat;



public class Test6 {
	
	

	public static void main(String[] args) throws Exception {
		
		//NumberFormat : 숫자를 서식에 맞추어 처리
		//일반적인 수치
		NumberFormat nf=NumberFormat.getInstance();
		nf.setMaximumFractionDigits(4);  
		nf.setMinimumFractionDigits(2);	
		
		String a;
		a=nf.format(3.141592);
		System.out.println(a);
		
		a=nf.format(2);
		System.out.println(a);
		
		a=String.format("%.2f", 3.141592);
		System.out.println(a);
		/*
		a="123,456,789";
		double d= Double.parseDouble(d);    //런타임 오류
		System.out.println(d);
		*/
		
		
		a=nf.format(12345678.12345);
		System.out.println(a);
		
		Number nn=nf.parse(a);
		System.out.println(nn);
		
		Double d=(Double)nn;
		System.out.println(d);
		
		
		// 통화기호 처리
		NumberFormat nf1=
				NumberFormat.getCurrencyInstance();
		a=nf1.format(12346578.12345);
		System.out.println(a);
		Number nn1=nf1.parse(a);
		System.out.println(nn1);
		

	}

}
