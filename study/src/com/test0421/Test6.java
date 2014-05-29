package com.test0421;

import java.io.FileOutputStream;

public class Test6 {

	public static void main(String[] args) {

		int data;

		try {
			// 파일 입력 바이트 스트림
			// 파일이 존재하면 지우고 파일을 다시 만들며 존재하지 않으면
			// 파일을 새로 만든다.
			FileOutputStream fos = new FileOutputStream("test.txt");

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
