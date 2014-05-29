package com.ex0401;

public class ArrayEx12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char[] abc = { 'A', 'B', 'C', 'D'};
		char[] number = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		
		System.out.println(new String(abc));
		System.out.print(new String(number));
		
		char[] result = new char[abc.length+number.length];
		
		
		
		System.arraycopy(abc,0, result,0,abc.length);
		System.arraycopy(number, 0, result, 0, abc.length);
		System.out.println(new String(result));
		
		System.arraycopy(abc,0,number,0,abc.length);
		System.out.println(new String(number));
		
		System.arraycopy(abc, 0, number,6,3);
		System.out.println(new String(number));
	}

}
