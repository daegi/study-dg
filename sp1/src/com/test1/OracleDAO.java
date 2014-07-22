package com.test1;

public class OracleDAO implements MyDAO {

	@Override
	public void insert() {
		System.out.println("오라클 insert");

	}

	@Override
	public void update() {
		System.out.println("오라클 update");

	}

	@Override
	public void delete() {
		System.out.println("오라클 delete");

	}

	@Override
	public void read() {
		System.out.println("오라클 read");
	}

}
