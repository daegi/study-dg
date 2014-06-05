package com.test0425;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

public class Test11 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s;

		System.out.printf("홈피주소(http://www.naver.com):");
		s = sc.next();

		try {
			String str;
			URL url = new URL(s);
			InputStream is = url.openStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is,
					"UTF-8"));

			while ((str = br.readLine()) != null) {
				System.out.println(str);
			}
			br.close();

		} catch (Exception e) {
		}

	}

}
