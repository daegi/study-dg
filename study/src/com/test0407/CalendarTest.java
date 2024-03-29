package com.test0407;

import java.util.Scanner;
import java.util.Calendar;

public class CalendarTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Calendar cal = Calendar.getInstance();

		int y, m;
		int i;

		System.out.print("년도 ? ");
		y = sc.nextInt();

		do {
			System.out.print("월 ? ");
			m = sc.nextInt();
		} while (m < 1 || m > 12);

		cal.set(y, m - 1, 1);
		int w = cal.get(Calendar.DAY_OF_WEEK);

		System.out.println("\t" + y + "년 " + m + "월");
		System.out.println("  일  월  화  수  목  금  토");
		System.out.println("============================");

		for (i = 1; i < w; i++)
			System.out.print("    ");

		for (i = 1; i <= cal.getActualMaximum(Calendar.DATE); i++) {
			System.out.printf("%4d", i);
			w++;
			if (w % 7 == 1)
				System.out.println();
		}
		if (w % 7 != 1)
			System.out.println();
		System.out.println("============================\n");
	}
}
