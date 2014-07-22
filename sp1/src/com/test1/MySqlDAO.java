package com.test1;

public class MySqlDAO implements MyDAO {

	@Override
	public void insert() {
		System.out.println("MySql insert");

	}

	@Override
	public void update() {
		System.out.println("MySql update");

	}

	@Override
	public void delete() {
		System.out.println("MySql delete");

	}

	@Override
	public void read() {
		System.out.println("MySql read");
	}

}
