package com.test0407;

import java.math.BigInteger;

public class Test6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Wrapper Ŭ����: �⺻�ڷ����� ����Ǿ����� Ŭ����
		// Byte, Character, Short, Long, Float, Double, boolean

		int a = 10, b;
		Integer ob;

		// �⺻�ڷ����� Integer������ ��ȯ
		// �����Ͻ� ������ ���� �ڵ尡 �����
		// ob=new integer(a);
		// �̸� autoboxing�̶� �ϸ� JDK 5.0���� ����

		ob = a;

		// Integer�� int�� ��ȯ
		// �����Ͻ� ������ ���� �ڵ� �����
		// b=ob.intValue();
		// �̸� Auto-unboxing�̶���
		b = ob;

		System.out.println(a + ":" + b + ":" + ob);

		// ���ڿ��� ������
		String s;
		s = "1234";
		a = Integer.parseInt(s);
		System.out.println(a);

		/*
		 * //������ ���� �Ұ���->��Ÿ�� ���� s = "123.5"; a = Integer.parseInt(s);
		 * System.out.println(a);
		 */

		a = Integer.parseInt("ab122", 16);
		System.out.println(a);
		/*
		 * //��Ÿ�� ���� s = "1,234,123"; a = Integer.parseInt(s);
		 * System.out.println(a);
		 */

		s = "1,234,123";
		s = s.replaceAll(",", "");
		a = Integer.parseInt(s);
		System.out.println(a);

		// ����->���ڿ�
		s = Integer.toString(a);
		System.out.println(s);

		s = String.format("%d,d", a);
		System.out.println(s);

		// ������ 2������
		s = Integer.toBinaryString(512);
		System.out.println(s);

		// ���ڿ��� �Ǽ���
		s = "123.45";
		double dd = Double.parseDouble(s);
		System.out.println(s);

		// ����ū��
		BigInteger bi1 = new BigInteger("12321211111145664");
		BigInteger bi2 = new BigInteger("1232124511111111111111664");

		BigInteger bi3;
		bi3 = bi1.add(bi2);
		System.out.println(bi3);

		// ���а� ����
		System.out.println(Math.PI);

		double d1;
		d1 = Math.sin(30 * Math.PI / 180); // ����
		System.out.println(d1);
		
		d1=Math.pow(2,10);
		System.out.println(d1);

		int i1 = (int)Math.random() * 100;
		System.out.println(i1);
		
		d1=Math.sqrt(d1);
		System.out.println(d1);

	}

}
