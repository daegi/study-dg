package com.test4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ResultMain {

	public static void main(String[] args) {
		String p = "com/test4/applicationContext.xml";

		ApplicationContext context = new ClassPathXmlApplicationContext(p);

		UserService service = (UserService) context.getBean("service");

		UserService service1 = (UserService) context.getBean("service");

		// 스프링은 기본적으로 singleton 패턴으로
		// 객체를 여러번 호출해도 한번만 객체가 만들어짐

		System.out.println(service == service1);

		// prototype은 호출할때마다 객체생성
		UserService s1 = (UserService) context.getBean("service1");
		UserService s2 = (UserService) context.getBean("service1");

		System.out.println(s1 == s2);

	}

}
