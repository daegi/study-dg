package com.test0404;

import java.util.Calendar;
import java.util.Scanner;

public class Ex {

	public static void main(String[] args) {

		
		Calendar now  = Calendar.getInstance();
		Scanner sc = new Scanner(System.in);
		
		String ss;

		System.out.println("입력 : ");
		ss = sc.nextLine();
		//ss = ss.replaceAll("\\s", ""); //공백제거
		
		now.getCalendarType();
		
		
		
		System.out.println("\n\t" + Calendar.YEAR + "년도" + Calendar.MONTH + "월");
		System.out.println("   일  월  화  수  목  금  토");
		System.out.println("=============================");

		for (int i = 1; i <= Calendar.DAY_OF_WEEK; i++)
			System.out.print("    "); //공백 4칸
		
		for (int i = 1; i <= Calendar.DAY_OF_MONTH-1 ; i++) {
			System.out.printf("%4d", i);

			if (Calendar.DAY_OF_WEEK % 7 == 0)
				System.out.println();
		}
		System.out.println();
	}

}
