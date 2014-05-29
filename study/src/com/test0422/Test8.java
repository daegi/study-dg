package com.test0422;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test8 {

	// System.in : byte 스트림
	// InputStreamReader: 바이트 스트림을 문자스트림으로변환
	// BufferedReader: 필터스트림

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s;
		
		System.out.println("문자열?");
		try {
			s=br.readLine();
			System.out.println(s);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
