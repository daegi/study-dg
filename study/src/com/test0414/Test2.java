package com.test0414;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import sun.nio.cs.ext.MacHebrew;

public class Test2 {

	public static void main(String[] args) {

		String s, p;

		s = "010-9999-9999";
		// s="011-333-9999";

		p = "01[01679]-\\d{3,4}-\\d{4}";

		Pattern pt = Pattern.compile(p);
		Matcher m = pt.matcher(s);

		if (m.matches()) {
			System.out.println(s + ":올바른 전화번호");
		} else {
			System.out.println(s + ":올바른 전화번호가 아닙니다.");
		}

		s = "900101-1000000";
		// s="011-333-9999";

		p = "\\d{2}[01]\\d-[0-3]\\d[1234]\\d{6}}";

		pt = Pattern.compile(p);
		m = pt.matcher(s);

		if (m.matches()) {
			System.out.println(s + ": 올바른 주민번호");
		} else {
			System.out.println(s + ": 올바른 주민번호 아닙니다.");
		}

		s = "abc@test.com";
		p = "[\\w\\_\\-]+@[\\w\\_\\-]+(\\.[\\w\\_\\-]+)+";

		boolean b = Pattern.matches(p, s);
		if (b)
			System.out.println(s + ": 올바른 이메일");
		else
			System.out.println(s + ": 잘못된 이메일");
		
		
		
		s="우리나라 대한민국 대한독립 대한 사람";
		s=replaceAll(s, "대한", "大韓");
		System.out.println(s);
				

	}

	public static String replaceAll(String str, String oldStr, String newStr) {
		if (str == null || str.length() == 0)
			return str;

		Pattern p = Pattern.compile(oldStr);
		Matcher m = p.matcher(str);
		
		
		//s="우리나라 대한민국 대한독립 대한 사람";
		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			m.appendReplacement(sb, newStr);
		}
		m.appendTail(sb);

		return sb.toString();

	}

}
