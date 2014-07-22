package com.test5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ResultMain {

	public static void main(String[] args) {
		String p = "com/test5/applicationContext.xml";

		ApplicationContext context = new ClassPathXmlApplicationContext(p);

		UserService service = (UserService) context.getBean("userService");
		
		service.write();

	}

}
