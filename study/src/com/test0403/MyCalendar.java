package com.test0403;

import java.util.Calendar;

public class MyCalendar {

	private int year, month, day;
	private int[] days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public MyCalendar() {
		int y, m, d;
		// ��ǻ�� �ý����� ��¥�� ����
		Calendar cal = Calendar.getInstance();
		y = cal.get(Calendar.YEAR);
		m = cal.get(Calendar.MONTH) + 1;
		d = cal.get(Calendar.DATE);

		// �ʵ忡 ���� �� 2�� ���� ���ϱ�
		set(y, m, d);

	}

	public MyCalendar(int year, int month, int day) {

	}

	// �������� �Ǻ��ϴ� �޼ҵ�

	public boolean isLeapYear() {
		boolean b = false;

		return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0);
	}

	// year, month, day �ʵ忡 ��¥ ����
	public void set(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;

		// 2�� ���� ó��
		if (isLeapYear())
			days[1] = 29;
		else
			days[1] = 28;

	}

	// ���ڰ� �ùٸ��� �Ǻ�
	public boolean isDate() {
		if (year < 1)
			return false;
		if (month < 1 || month > 12)
			return false;
		if (day < 1 || day > days[month - 1])
			return false;

		return true;
	}

	public int getTotalDays() {
		int total;

		// ��¥�� ������ Ʋ�� ��� -1�� ����

		if (!isDate())
			return -1;
		total = (year - 1) * 365 + (year - 1) / 4 - (year - 1) / 100
				+ (year - 1) / 400;

		for (int i = 0; i < month - 1; i++)
			total += days[i];

		total += day;
		return total;
	}

	public String getWeek() {
		// ��¥ ������ Ʋ�����

		if (!isDate())
			return null;

		String[] w = { "��", "��", "ȭ", "��", "��", "��", "��" };

		int n = getTotalDays() % 7;

		return w[n];
		// ��¥ ����ϱ�
	}

	public String getDate() {
		if (!isDate())
			return null;

		String s = year + "��" + month + "��" + day + "��" + getWeek() + "����";

		return s;
	}

	public void datePrint() {
		if (!isDate())
			return;

		int total = getTotalDays() - day + 1;
		int w = total % 7;

		System.out.println("\t" + year + "��" + month + "��");
		// ������ �˾Ƽ�

	}

}
