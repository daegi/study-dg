package com.test1;

public class OracleDAO implements MyDAO {

	@Override
	public void insert() {
		System.out.println("����Ŭ insert");

	}

	@Override
	public void update() {
		System.out.println("����Ŭ update");

	}

	@Override
	public void delete() {
		System.out.println("����Ŭ delete");

	}

	@Override
	public void read() {
		System.out.println("����Ŭ read");
	}

}
