package com.test0407;

import java.util.Date;

public class Test4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 현재 시스템 날짜
		Date date = new Date();
		System.out.println(date);

		// 사용을 권장하지 않음
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
