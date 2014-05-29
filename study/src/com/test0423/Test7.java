package com.test0423;

import java.io.InputStreamReader;
import java.io.LineNumberReader;

public class Test7 {

	public static void main(String[] args) {
		LineNumberReader br = new LineNumberReader(new InputStreamReader(
				System.in));

		String s;

		try {
			while ((s = br.readLine()) != null) {
				System.out.println(br.getLineNumber() + ":" + s);
			}

		} catch (Exception e) {
		}

	}

}
