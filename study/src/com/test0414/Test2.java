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
			System.out.println(s + ":�ùٸ� ��ȭ��ȣ");
		} else {
			System.out.println(s + ":�ùٸ� ��ȭ��ȣ�� �ƴմϴ�.");
		}

		s = "900101-1000000";
		// s="011-333-9999";

		p = "\\d{2}[01]\\d-[0-3]\\d[1234]\\d{6}}";

		pt = Pattern.compile(p);
		m = pt.matcher(s);

		if (m.matches()) {
			System.out.println(s + ": �ùٸ� �ֹι�ȣ");
		} else {
			System.out.println(s + ": �ùٸ� �ֹι�ȣ �ƴմϴ�.");
		}

		s = "abc@test.com";
		p = "[\\w\\_\\-]+@[\\w\\_\\-]+(\\.[\\w\\_\\-]+)+";

		boolean b = Pattern.matches(p, s);
		if (b)
			System.out.println(s + ": �ùٸ� �̸���");
		else
			System.out.println(s + ": �߸��� �̸���");
		
		
		
		s="�츮���� ���ѹα� ���ѵ��� ���� ���";
		s=replaceAll(s, "����", "����");
		System.out.println(s);
				

	}

	public static String replaceAll(String str, String oldStr, String newStr) {
		if (str == null || str.length() == 0)
			return str;

		Pattern p = Pattern.compile(oldStr);
		Matcher m = p.matcher(str);
		
		
		//s="�츮���� ���ѹα� ���ѵ��� ���� ���";
		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			m.appendReplacement(sb, newStr);
		}
		m.appendTail(sb);

		return sb.toString();

	}

}
