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

		// �ϳ��� ��ü
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = cal1;
		System.out.println(cal1 == cal2);

		// �ΰ��� ��ü
		Calendar cal3 = Calendar.getInstance();
		Calendar cal4 = Calendar.getInstance();
		System.out.println(cal3 == cal4);

		// �ΰ��� ��ü(��ü�� �����ؼ�)
		Calendar cal5 = Calendar.getInstance();
		Calendar cal6 = (Calendar) cal5.clone();// ��ü����(���� ����)
		System.out.println(cal5 == cal6);

	}

}
