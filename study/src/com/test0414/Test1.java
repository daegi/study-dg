package com.test0414;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test1 {

	public static void main(String[] args) {

		String[] data = { "bat", "baby", "bonus", "c", "cA", "ca", "co", "c",
				"c0", "c#", "car", "combat", "count", "date", "disc" };

		String[] p = { "c[a-z]", "c[a-z]*","c[a-z].*" };  //c를 포함한 a~z까지

		for (int i = 0; i < p.length; i++) {
			Pattern pt = Pattern.compile(p[i]);
			System.out.println(p[i] + "패턴결과...");
			
			for (int x = 0; x < data.length; x++) {
				Matcher m = pt.matcher(data[x]);
				if (m.matches())
					System.out.println(data[x]);
			}
			System.out.println();

		}

	}
}


/*
 * c[a-z] : c로 시작하는 2글자의 영어단어(소문자)
 * c[a-z]* : c로 시작하는 영어단어(소문자)
 * c[a-z].* : c로 시작하는 2글자 이상의 영어단어(소문자)
 * 
 * c[a-zA-Z]* : c로 시작하는 영어단어(대소문자를 구분하지 않음)
 * .* : 모든 문자
 * c.*t : c로 시작하고 t로 끝나는 문자열
 * [b|c].*: b나 c로 시작하는 문자열
 * [^b|c].*: b나 c로 시작하지 않는 문자열  
 * .*a.* : a를 포함하는 
 * * : 0문자이상
 * + : 1문자이상
 * . : 한문자 
 * 
 *  [b|c].{2} : b또는 c로 시작하는 세자리 문자열
 *  
 *  
*/
