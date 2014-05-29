package com.test0414;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class Test5 {

	public static void main(String[] args) {

		Locale list[] = SimpleDateFormat.getAvailableLocales();

		for (int i = 0; i < list.length; i++)
			System.out.println(list[i].getDisplayName() + "\t\t"
					+ list[i].toString());
	}
}
