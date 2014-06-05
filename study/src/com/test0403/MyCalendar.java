package com.test0403;

import java.util.Calendar;

public class MyCalendar {

	private int year, month, day;
	private int[] days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public MyCalendar() {
		int y, m, d;
		// 컴퓨터 시스템의 날짜로 설정
		Calendar cal = Calendar.getInstance();
		y = cal.get(Calendar.YEAR);
		m = cal.get(Calendar.MONTH) + 1;
		d = cal.get(Calendar.DATE);

		// 필드에 설정 및 2월 날수 구하기
		set(y, m, d);

	}

	public MyCalendar(int year, int month, int day) {

	}

	// 윤년인지 판별하는 메소드

	public boolean isLeapYear() {
		boolean b = false;

		return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0);
	}

	// year, month, day 필드에 날짜 설정
	public void set(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;

		// 2월 날수 처리
		if (isLeapYear())
			days[1] = 29;
		else
			days[1] = 28;

	}

	// 날자가 올바른지 판별
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

		// 날짜가 형식이 틀린 경우 -1을 리턴

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
		// 날짜 형식이 틀린경우

		if (!isDate())
			return null;

		String[] w = { "일", "월", "화", "수", "목", "금", "토" };

		int n = getTotalDays() % 7;

		return w[n];
		// 날짜 출력하기
	}

	public String getDate() {
		if (!isDate())
			return null;

		String s = year + "년" + month + "월" + day + "일" + getWeek() + "요일";

		return s;
	}

	public void datePrint() {
		if (!isDate())
			return;

		int total = getTotalDays() - day + 1;
		int w = total % 7;

		System.out.println("\t" + year + "년" + month + "월");
		// 나머지 알아서

	}

}
