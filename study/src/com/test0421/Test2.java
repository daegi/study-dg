package com.test0421;

public class Test2 {

	public static void main(String[] args) {
		int data;

		try {
			//abc : while은 3번(엔터제외)
			//대한민국 : while은 8번(엔터제외) -->byte 스트림
			System.out.print("입력?");
			while ((data = System.in.read()) != -1) {
				char ch = (char) data;
				//System.out.print(ch); // 한글깨짐
				System.out.write(ch);
			}

		} catch (Exception e) {
		}

	}

}
