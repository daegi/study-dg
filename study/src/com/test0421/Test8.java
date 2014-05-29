package com.test0421;

//복사할 원본? test.txt
//복사할 복사본? ex.txt
//
//입력받은 뭊자의 아스키코드값을 저장할 정수형 변수
//	스캐너 객체
//try{
//	원폰파일명과 복사본 파일명을입력 받는다.
//	파일 입력객체와 파일 출력 객체 생성
//	파일 입력 객체에서 읽어서 파일 출력 객체에 저장-반복
//파일입력 객체와 파일입출력객체 담기
//}catch(....)

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Test8 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int data;
		String s1, s2;

		try {
			System.out.println("원본 입력?");
			s1 = sc.next();
			System.out.println("복사본 입력?");
			s2 = sc.next();
			FileInputStream fis = new FileInputStream(s1);
			FileOutputStream fos = new FileOutputStream(s2);

			while ((data = fis.read()) != -1) {
				fos.write(data);
			}
			fos.close();
			fis.close();
			System.out.println("복사 완료");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
