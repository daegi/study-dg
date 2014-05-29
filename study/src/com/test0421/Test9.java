package com.test0421;

public class Test9 {

	public static void main(String[] args) {
		String s = "우리나라 대한민국 KOREA";
		byte[] b = s.getBytes();

		for (int i = 0; i < b.length; i++) {
			System.out.println(b[i]);
			//System.out.println(Integer.toHexString(b[i]));
		}
		
		String s1= new String(b);
		System.out.println(s1);

	}

}
