package com.test0421;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Test10 {

	public static void main(String[] args) {
		

		int len;
		byte b[] = new byte[1024];
		
		Scanner sc = new Scanner(System.in);
		String s1, s2;

		try {
			System.out.println("원본 입력?");
			s1 = sc.next();
			System.out.println("복사본 입력?");
			s2 = sc.next();
			FileInputStream fis = new FileInputStream(s1);
			FileOutputStream fos = new FileOutputStream(s2);

			while ((len = fis.read(b, 0, 1024)) != -1) {
				fos.write(b,0,len);
			}
			fos.close();
			fis.close();
			System.out.println("복사 완료");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
