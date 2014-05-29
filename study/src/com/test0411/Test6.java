package com.test0411;

import java.text.NumberFormat;



public class Test6 {
	
	

	public static void main(String[] args) throws Exception {
		
		//NumberFormat : ���ڸ� ���Ŀ� ���߾� ó��
		//�Ϲ����� ��ġ
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
		double d= Double.parseDouble(d);    //��Ÿ�� ����
		System.out.println(d);
		*/
		
		
		a=nf.format(12345678.12345);
		System.out.println(a);
		
		Number nn=nf.parse(a);
		System.out.println(nn);
		
		Double d=(Double)nn;
		System.out.println(d);
		
		
		// ��ȭ��ȣ ó��
		NumberFormat nf1=
				NumberFormat.getCurrencyInstance();
		a=nf1.format(12346578.12345);
		System.out.println(a);
		Number nn1=nf1.parse(a);
		System.out.println(nn1);
		

	}

}
