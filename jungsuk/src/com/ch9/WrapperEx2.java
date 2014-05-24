package com.ch9;

public class WrapperEx2 {

	public static void main(String[] args) {
		
		int i = new Integer("100").intValue();
		int i2 = Integer.parseInt("100");
		int i3 = Integer.valueOf("100");
		
		int i4 = Integer.parseInt("100",2);
		int i5 = Integer.parseInt("100",8);
		int i6 = Integer.parseInt("100",16);
		int i7 = Integer.valueOf("FF",16);
		
		System.out.println(i4+":"+i5+":"+i6+":"+i7);

	}

}
