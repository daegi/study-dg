package com.test0403;

import java.util.Calendar;

public class Test6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Calendar cal=Calendar.getInstance();
		
		System.out.printf("%tF %tA %tT\n", cal, cal,cal);
		
		int y=cal.get(Calendar.YEAR);
		int m=cal.get(Calendar.MONTH)+1;
		int d=cal.get(Calendar.DATE);
		int w=cal.get(Calendar.DAY_OF_WEEK);
		System.out.println(y+":"+m+":"+d+":"+w);
		
		

	}

}
