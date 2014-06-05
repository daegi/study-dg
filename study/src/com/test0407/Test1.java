package com.test0407;

import java.util.Calendar;

public class Test1 {
	public static void main(String[] args) {
		Calendar now = Calendar.getInstance();

		// Calendar Ŭ������ �߻� Ŭ������ ��ü�� �����Ҽ� ����.
		//    �߻� Ŭ���� : �̿ϼ��� Ŭ����
		/*
		    Calendar now = new Calendar(); // �Ұ�
			Calendar Ŭ���� ��ü�� �����Ҽ� �ִ� ���
			1. Calendar now = Calendar.getInstance();
			2. Calendar now = new GregorianCalendar();
			3. GregorianCalendar now = new GregorianCalendar();
			// GregorianCalendar : Calendar ���� Ŭ����
		*/

		String str1 = String.format("%1$tF %1$tA %1$tT",
				now);

		System.out.println(str1);

		int y = now.get(Calendar.YEAR);
		int m = now.get(Calendar.MONTH)+1;
		int d = now.get(Calendar.DATE);
		int w = now.get(Calendar.DAY_OF_WEEK); // 1~7
		String week="";

		switch(w) {
			case 1:week="��";break;
			case 2:week="��";break;
			case 3:week="ȭ";break;
			case 4:week="��";break;
			case 5:week="��";break;
			case Calendar.FRIDAY:week="��";break;
			case 7:week="��";break;
		}

		System.out.println(y+"-"+m+"-"+d+ " " + week);

		// ���� ��¥�� 1000�� ���Ѵٸ�
		now.add(Calendar.DATE, 1000);
		System.out.printf("%tF%n", now);

		// 2009�� 5�� 30�Ϸ� ����
		now.set(2009, 5-1, 30);  // ���� 0~11
		System.out.printf("%tF%n", now);

		// ���ڸ� 10�Ϸ� ����
		now.set(Calendar.DATE, 10);
		System.out.printf("%tF%n", now);

		// 2011�� 5�� 32�Ϸ� ����
		now.set(2011, 5-1, 32);
		System.out.printf("%tF%n", now);

		int end = now.getActualMaximum(Calendar.DATE);
		System.out.println("�ش� ���� ������ ���� : "  + end);
	}

}
