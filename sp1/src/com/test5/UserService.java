package com.test5;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.stereotype.Component;

//->�⺻ id�� Ŭ���� �̸�(��, ù���ڴ� �ҹ���)
// ���� �� id�� userService�� ��
// �̸��� ����ڰ� ������ ���� @Component("babo") ó��
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
		System.out.println("���� �� �������....");
		System.out.println("������ ȣ��ڿ� ����ȴٸ�...");
	}

	@PreDestroy
	public void close() {
		System.out.println("���� ��ü�� �ױ� ������ ����");
	}

}
