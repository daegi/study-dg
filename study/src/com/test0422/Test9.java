package com.test0422;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test9 {

	public static void main(String[] args) {
		try {
			FileOutputStream fos = new FileOutputStream("ex.txt");
			int data;

			System.out.println("문자열(종료:ctrl+z)?");
			while ((data = System.in.read()) != -1) {
				fos.write(data);
			}
			fos.close();

			String s;
			FileInputStream fis = new FileInputStream("ex.txt");

			// 파일의 내용을 한줄씩 입력 받기 위해 사용
			// 텍스트 문서가 아닌경우 사용 하면 안됨
			// -- 바이트스트림을 문자스트립으로 변환하므로
			// 이진파일(gif, exe 등)파일의 내용이 바뀌어 버림
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			System.out.println("\n파일내용...");
			while ((s = br.readLine()) != null) {
				System.out.println(s);
			}
			br.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
