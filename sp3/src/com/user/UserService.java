package com.user;

import org.springframework.stereotype.Service;

/*
 * 클래스의 객체를 생성하기 위해 환경설정에서
 * bean 태그를 이용하여 객체를 생성 했는데  이를
 * @Service 어노테이션이 한다. 일반적으로 비지니스
 * 로직을 처리하는 클래스에서 사용한다. 
 */

@Service
public class UserService {

	public String result(User u) {
		String s = null;

		if (u.getAge() >= 19) {
			s = "당신은 성인입니다.";
		} else if (u.getAge() >= 14)
			s = "당신은 아동입니다.";

		return s;
	}

}
