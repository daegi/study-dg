package com.test1;

public class UserServiceImpl implements UserService {

	private MyDAO dao;
	

	public void setDao(MyDAO dao) {
		this.dao = dao;
	}

	@Override
	public void insertDate() {
		System.out.println("���� Ŭ���� �Դϴ�.");
		
		dao.insert();
	}
}
