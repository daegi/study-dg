package com.employee;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeService {
	private Scanner sc = new Scanner(System.in);
	private ArrayList<EmployeeDAO> list;

	public EmployeeService() {
		list = new ArrayList<>();
	}

	// ���
	public void input() {
		
		EmployeeDAO dao = new EmployeeDAO();
		System.out.println("Ű����� ������ �Է� �޴� �κ�");

		System.out.println("�̸��� �־��ּ���");
		dao.setName(sc.next());
		System.out.println("����� �־��ּ���");
		dao.setSabun(sc.next());
		System.out.println("���񽺰� ���ο� ������ ����� ���Դϴ�.");
		list.add(dao);
		
		
		for (EmployeeDAO vv : list) {
			if (dao.getName().equals(sc.next(dao.name))) {
				System.out.println(dao.getName()+"\n"+dao.getSabun());
			}
		}
				
		System.out.println("ȭ�鿡 ��� ���");
		
		

	}

	// ��ȸ
	public void search() {

	}

	// ����
	public void update() {

	}

	// ����
	public void remove() {

	}
	
	// ����
	public void exit() {
		
		System.out.println("�ý����� ���� �մϴ�");
		System.exit(0);

	}
	

}
