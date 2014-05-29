package com.test0407;

import java.util.Calendar;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Calendar now = Calendar.getInstance();
		
		;

		now.set(2013, 10 - 1, 10);

		now.add(Calendar.DATE, 500);
		String s = String.format("%tF", now);
		// System.out.printf("%tF%n", now);

		// 하나의 객체
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = cal1;
		System.out.println(cal1 == cal2);

		// 두개의 객체
		Calendar cal3 = Calendar.getInstance();
		Calendar cal4 = Calendar.getInstance();
		System.out.println(cal3 == cal4);

		// 두개의 객체(객체를 복사해서)
		Calendar cal5 = Calendar.getInstance();
		Calendar cal6 = (Calendar) cal5.clone();// 객체복사(값은 동일)
		System.out.println(cal5 == cal6);

	}

}
