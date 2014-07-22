package com.test5;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.stereotype.Component;

//->기본 id는 클래스 이름(단, 첫글자는 소문자)
// 따라서 빈 id는 userService가 됨
// 이름을 사용자가 지정할 경우는 @Component("babo") 처럼
@Component
public class UserService {

	// @Autowired
	// @Qualifier("user2")

	@Resource(name = "user")
	private User user;

	/*
	 * public void setUser(User user) { this.user = user; }
	 */

	public UserService() {

	}

	public UserService(User user) {
		this.user = user;
	}

	public void write() {
		System.out.println(user.result());
	}

	@PostConstruct
	public void init() {
		System.out.println("나는 왜 실행되지....");
		System.out.println("생성자 호출뒤에 실행된다며...");
	}

	@PreDestroy
	public void close() {
		System.out.println("나는 객체가 죽기 직전에 실행");
	}

}
