package com.sist.first;

public class EmployeeService {
	private EmployeeDAO dao;

	public EmployeeService() {
		dao = new EmployeeDAO();
	}

	public void regist(Employee newEmployee) {
		System.out.println("���񽺰� ���ο� ������ ���");
		System.out.println(newEmployee.getName());
		System.out.println(newEmployee.getEmpno());
	}

}
