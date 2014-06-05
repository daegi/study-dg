package com.sist.first;

public class EmployeeDAO {

	private Employee[] emps;

	public EmployeeDAO() {
		emps = new Employee[10];
	}

	public void addEmployee(Employee emo) {

	}

	public void deleteEmployee(int empno) {
		EmployeeUI ui = new EmployeeUI();
		ui.showUsage();
	}

}
