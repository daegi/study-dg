package com.test4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ResultMain {

	public static void main(String[] args) {
		String p = "com/test4/applicationContext.xml";

		ApplicationContext context = new ClassPathXmlApplicationContext(p);

		UserService service = (UserService) context.getBean("service");

		UserService service1 = (UserService) context.getBean("service");

		// �������� �⺻������ singleton ��������
		// ��ü�� ������ ȣ���ص� �ѹ��� ��ü�� �������

		System.out.println(service == service1);

		// prototype�� ȣ���Ҷ����� ��ü����
		UserService s1 = (UserService) context.getBean("service1");
		UserService s2 = (UserService) context.getBean("service1");

		System.out.println(s1 == s2);

	}

}
