package com.test0414;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Test4 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String s;
		System.out.print("��Ű������ ������ Ŭ������ : ");
		s = sc.next();

		Class<?> cls = Class.forName(s);
		System.out.println("�޼ҵ�");
		Method[] mm = cls.getMethods();
		for (Method m : mm)
			System.out.println(m);
		
		System.out.println("������\n");
		Constructor<?>[] cc = cls.getConstructors();
		for (Constructor<?> c : cc)
			System.out.println(c);

		System.out.println("\n�ʵ�");
		Field[] ff = cls.getFields();
		for (Field f : ff)
			System.out.println(f);

	}

}
