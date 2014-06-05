package com.test0421;

import java.io.InputStreamReader;
import java.io.Reader;

public class Test4 {

	public static void main(String[] args) {
		
		

		int data;
		// Stystem.in: 바이트 스트림(InputStream)
		// Reader : 문자 스트림(추상 클래스)
		// InputStreamReader : 바이트 스트림을 문자 스트림
		// 으로 변환하는 bridge 스트림

		Reader rd = new InputStreamReader(System.in);

		try {
			System.out.print("문자열?");
			// 대한민국을 입력한 경우
			// InputStream:while 8번 실행
			// Reader : while문을 4번 실행

			while ((data = rd.read()) != -1) {
				char ch=(char) data;
				System.out.print(ch);  //출력단위가 문자이므로 한글이 깨지지 않음
				//System.out.write(ch);  <---출력단위가 바이트이므로 한글 깨짐

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
