package com.test0421;

public class Test5 {

	public static void main(String[] args) {
		int data;

		try {
			System.out.print("¹®ÀÚ¿­?");
			// abcdef -> ace
			while ((data = System.in.read()) != -1) {
				System.out.write((char) data);
				System.in.skip(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
