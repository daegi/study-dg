package com.test0403;

public class Test7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MyCalendar oo1= new MyCalendar();
		MyCalendar oo2= new MyCalendar();
		
		oo2.set(1987, 7, 3);
		int n=oo1.getTotalDays() -oo2.getTotalDays();
		System.out.println("��ƿ� ���� : "+n);
		System.out.println(oo2.getDate());
		
		if(oo1.isLeapYear())
			System.out.println("����");
		else
			System.out.println("���");
			

	}

}
