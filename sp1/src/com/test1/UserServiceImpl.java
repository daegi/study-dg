package com.test1;

public class UserServiceImpl implements UserService {

	private MyDAO dao;
	

	public void setDao(MyDAO dao) {
		this.dao = dao;
	}

	@Override
	public void insertDate() {
		System.out.println("서비스 클래스 입니다.");
		
		dao.insert();
	}
}
