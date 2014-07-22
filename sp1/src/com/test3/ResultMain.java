package com.test3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ResultMain {

	public static void main(String[] args) {
		String p = "com/test3/applicationContext.xml";

		ApplicationContext context = new ClassPathXmlApplicationContext(p);

		UserService service = context.getBean(UserService.class);

		service.write();

	}

}
