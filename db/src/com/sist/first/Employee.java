package com.sist.first;

public class Employee {
	private String name;
	private int empno;
	
	public Employee(String name, int empno){
		this.name = name;
		this.empno = empno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}
	



}
