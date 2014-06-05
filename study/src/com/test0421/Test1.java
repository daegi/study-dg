package com.test0421;

public class Test1 {

	public static void main(String[] args) {
		int data;

		try {
			// read() : 한문자를 입력받아 입력 받은 문자의 ASCII코드 를 리턴
			
			// ctrl+z : -1
			// 13하고 10은 엔터 의미 
			System.out.println("입력? ");
			while ((data = System.in.read()) != -1) {
				System.out.print("\n" + data + "->"+(char)data+":");
				System.out.write((char) data);
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
