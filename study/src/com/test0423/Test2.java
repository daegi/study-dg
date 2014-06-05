package com.test0423;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Test2 {

	public static void main(String[] args) {
		String s;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			
			//문자열 사용못함 바이트 배열으로 바꿈()
			FileOutputStream fos = new FileOutputStream("ex.txt"); 
			System.out.println("문자열 입력...");
			while ((s = br.readLine()) != null) {
				byte[] b = s.getBytes();
				fos.write(b);
			}
			fos.close();
		}catch(Exception e){
			
		
		}

	}

}
