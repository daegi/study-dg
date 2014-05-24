package com.ch11;

import java.util.ArrayList;
import java.util.List;

public class ArrayListEx2 {

	public static void main(String[] args) {
		final int LIMIT = 10;
		String source = "0123456789abcdefghijABCDEFGHIJ!@#$%^&*()ZZZ";  
		int length = source.length();

		List list = new ArrayList(length / LIMIT + 10);
		
		//for문은 10 20 30 40 50 마지막 반복에서 거짓이므로 40~
		for (int i = 0; i < length; i += LIMIT) {
			if (i + LIMIT < length)
				list.add(source.substring(i, i + LIMIT));
			else
				list.add(source.substring(i));

		}

		for (int i = 0; i < list.size(); i++)
			System.out.println(list.get(i));

	}

}
