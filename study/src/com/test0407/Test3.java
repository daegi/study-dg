package com.test0407;

import java.util.Calendar;

public class Test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Ư�� ��¥�� �� ���۰� �� ���ϱ�
		Calendar cal = Calendar.getInstance();
		String week[] = { "��", "��", "ȭ", "��", "��", "��", "��" };

		// 2014�� 4�� 3�Ϸ� ����

		cal.set(2014, 4 -1, 6);

		int y = cal.get(Calendar.YEAR);
		int m = cal.get(Calendar.MONTH)+1;
		int d = cal.get(Calendar.DATE);
		int w = cal.get(Calendar.DAY_OF_WEEK);
		
		System.out.println(w);
		
		System.out.printf("%4d-%02d-%02d %s���� %n", y, m, d, week[w-1]);

		// System.out.printf("%tF %tA %n",cal,cal);

		// ���� ������(�Ͽ���)��?
		Calendar sday = (Calendar) cal.clone();
		int _w = cal.get(Calendar.DAY_OF_WEEK) - 1;
		sday.add(Calendar.DAY_OF_MONTH, _w * -1);
		System.out.printf("����:%tF%n", sday);

		// ���� ��������(�����)��?
		Calendar eday = (Calendar) cal.clone();
		_w = 7 - cal.get(Calendar.DAY_OF_WEEK);
		eday.add(Calendar.DAY_OF_MONTH, _w);
		System.out.printf("��:%tF%n", eday);

	}

}
