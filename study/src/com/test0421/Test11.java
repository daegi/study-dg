package com.test0421;

import java.io.FileOutputStream;

public class Test11 {

	public static void main(String[] args) {
		int data;

		try {

			// 기본 : false ->파일이 있으면 지우고 다시 만듬
			// true : 파일이 있으면 지우지 않고 추가함
			FileOutputStream fos = new FileOutputStream("test.txt", true);

			System.out.println("문자열 입력...(ctrl+z: 종료)");

			while ((data = System.in.read()) != -1) {
				fos.write(data);
			}
			fos.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}
