package com.test0407;

import java.text.SimpleDateFormat;

import java.util.Date;

/*
 * SimpleDateFormat Ŭ����
 * DateFormat Ŭ������ ��ӹ��� Ŭ������
 * DATE ��ü�� String�� ��ȯ�ϰų�
 * String ��ü�� Date�� ��ȯ�ϱ� ���� ���
 * 
 * 
 */

public class Test5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Date date = new Date();

		// Date -> �ؽ�Ʈ��
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd��");
		String s = sdf.format(date);
		System.out.println(s);
		
		//�ؽ�Ʈ�� -> Date�� ��ȯ
		try {
			//���ܰ� �߻��� ��ɼ��� �ִ� �ڵ带 �ۼ�
			//���ܰ� �߻��ϸ� catch()������ ���� ��� �ű�
			
			SimpleDateFormat format =new SimpleDateFormat("yyyy-MM-dd");
			String ss="2014-03-03";
			
			// ���ڿ��� Date�� ��ȯ
			Date date1=format.parse(ss);  //����ó���� �ʿ�
			System.out.println(date1);
			//1970�� 1�� 1���� �������� �и��� ������ ���
			System.out.println(date1.getTime());
			
			Date eDay=format.parse("2014-04-07");
			Date sDay=format.parse("1982-07-03");
			
			long a=(eDay.getTime()-sDay.getTime())/(24*60*60*1000);
			System.out.println("��ƿ³���:"+a);
			
			
			
		} catch (Exception e) {
			// ���ܰ� �߻��Ҷ� ������ �ڵ� �ۼ�
			
			
		}

	}

}
