package com.test0423;
//�޸� ��Ʈ�� �� (���� ������)


import java.io.StringReader;
import java.io.StringWriter;

public class Test6 {

	public static void main(String[] args) {
		int data;
		String s = "Hello JAVA";

		try {
			StringReader sr = new StringReader(s);
			StringWriter sw = new StringWriter();

			while ((data = sr.read()) != -1) {
				sw.write(data);
			}
			String ss = sw.toString();
			System.out.println(ss);

			StringBuffer sb = sw.getBuffer();
			System.out.println(sb.toString());

		} catch (Exception e) {
		}

	}

}
