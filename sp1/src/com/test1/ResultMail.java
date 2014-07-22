package com.test1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ResultMail {
	public static void main(String[] args) {
		String p = "com/test1/applicationContext.xml";
		// ClassPathXmlApplicationContext : 클래스 패스에
		// 위치한 xml 파일로 부터 xml을 읽어 들림
		// ApplicationContext : BeanFactory를 상속받은
		// 인터페이스로 버전관리, 빈객체 라이프 사이클
		// 메시지및 국제화지원, 이벤트처리등의 기능 추가

		// 스프링 컨테이너 생성
		ApplicationContext context = new ClassPathXmlApplicationContext(p);

		// 스프링 컨테이너에서 해당 빈 객체를 가져옴
		UserService s = (UserService) context.getBean("service");

		// 메소드 실행
		s.insertDate();

	}
}
