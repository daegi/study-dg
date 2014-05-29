package com.sist.first;

public class EmployeeService {
	private EmployeeDAO dao;

	public EmployeeService() {
		dao = new EmployeeDAO();
	}

	public void regist(Employee newEmployee) {
		System.out.println("서비스가 새로운 직원을 등록");
		System.out.println(newEmployee.getName());
		System.out.println(newEmployee.getEmpno());
	}

}
