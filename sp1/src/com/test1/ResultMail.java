package com.test1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ResultMail {
	public static void main(String[] args) {
		String p = "com/test1/applicationContext.xml";
		// ClassPathXmlApplicationContext : Ŭ���� �н���
		// ��ġ�� xml ���Ϸ� ���� xml�� �о� �鸲
		// ApplicationContext : BeanFactory�� ��ӹ���
		// �������̽��� ��������, ��ü ������ ����Ŭ
		// �޽����� ����ȭ����, �̺�Ʈó������ ��� �߰�

		// ������ �����̳� ����
		ApplicationContext context = new ClassPathXmlApplicationContext(p);

		// ������ �����̳ʿ��� �ش� �� ��ü�� ������
		UserService s = (UserService) context.getBean("service");

		// �޼ҵ� ����
		s.insertDate();

	}
}
