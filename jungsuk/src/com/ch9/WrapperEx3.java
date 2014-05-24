package com.ch9;

public class WrapperEx3 {

	public static void main(String[] args) {
		
		int i = 10;
		Number iNu= (Integer)i;
		Integer intg = (Integer)i;
		Object obj = (Object)i;
		
		Long lng = 100L;
		
		int i2 = intg+10;
		long l = intg +lng;
		
		Integer intg2 = new Integer(20);
		int i3= (int)intg2;
		
		System.out.println(i);  // 10
		System.out.println(intg);	//10
		System.out.println(obj);
		System.out.println(lng);
		System.out.println(i2);
		System.out.println(l);
		System.out.println(intg2);
		System.out.println(i3);
		System.out.println(iNu);
		
		

	}

}
