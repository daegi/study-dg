package com.test0407;

import java.util.Date;

public class Test4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// ���� �ý��� ��¥
		Date date = new Date();
		System.out.println(date);

		// ����� �������� ����
		int y = date.getYear() + 1900;
		int m = date.getMonth() + 1;
		int d = date.getDate();
		int h = date.getHours();
		int mm = date.getMinutes();
		int s = date.getSeconds();

		System.out
				.println(y + ":" + m + ":" + d + ":" + h + ":" + mm + ":" + s);

	}

}
