package com.test0404;

import java.util.Calendar;

public class Test9 {

	public static void main(String[] args) {
		//��¥�� ó���ϴ� Ŭ����
		//calendar�� �߻� Ŭ������ ��ü�� �ٷ� ���� �� �� ����.
		// Calendar cc= new Calendar(); ����
		
		Calendar now  = Calendar.getInstance();
		
		System.out.printf("%tF %n", now);
		
		//2014�� 7�� 3�Ϸ� ����
		now.set(2014, 7-1,4); //���� 0~11�� ǥ��
		System.out.printf("%tF %n",now);
		
		System.out.println(now.getActualMaximum(Calendar.DAY_OF_MONTH));
		
		System.out.println(now.get(Calendar.DAY_OF_WEEK));
	}

}



/*
�� ���� �Է� �޾� �ش� ���� �޷� ���ϱ�
-calendar Ŭ���� �̿�
*/