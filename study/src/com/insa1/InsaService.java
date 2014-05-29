package com.insa1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

//List �������̽�->����Ŭ���� : Vector, ArrayList
public class InsaService {
	private Scanner sc = new Scanner(System.in);
	private ArrayList<InsaVO> list;

	public InsaService() {
		list = new ArrayList<InsaVO>();
	}

	// �Է�
	// ���,�̸�, �޿��� �Է� �޾� ArrayList�� �߰�
	// try~catch�� �̿��Ͽ� �޿� �Է¿� ������ �߻��ϸ�
	// �Է� ���� �޽����� ����Ѵ�.
	public void input() {
		try {
			InsaVO vo = new InsaVO();

			System.out.print("���?");
			vo.setSabun(sc.next());
			System.out.print("�̸�?");
			vo.setName(sc.next());
			System.out.print("�޿�?");
			vo.setPay(sc.nextInt());

			list.add(vo);
			System.out.println("�Է� �Ϸ�...\n");
		} catch (Exception e) {
			System.out.println("�Է� ����...");
			sc.nextLine();
		}
	}

	// ����
	public void update() {
		InsaVO vo = null;
		String sabun;

		System.out.print("������ ���?");
		sabun = sc.next();

		for (InsaVO vv : list) {
			if (vv.getSabun().equals(sabun)) {
				vo = vv;
				break;
			}
		}

		if (vo == null) {
			System.out.println(sabun + " �ڷ�� ��ϵ� �ڷᰡ �ƴմϴ�.");
			return;
		}

		System.out.println("�̸�:" + vo.getName() + ", �޿�:" + vo.getPay());
		System.out.print("�����ұ޿�?");
		vo.setPay(sc.nextInt());
		System.out.println("���� �Ϸ�...\n");
	}

	// �˻�
	public void search() {
		String name;

		System.out.print("�˻��� �̸�?");
		name = sc.next();
		for (InsaVO vv : list) {
			if (vv.getName().equals(name)) {
				System.out.println(vv.getSabun() + ":" + vv.getName() + ":"
						+ vv.getPay() + ":" + ":" + vv.getTax() + ":"
						+ vv.getSilpay());
			}
		}
		System.out.println();
	}

	// ����
	public void remove() {
		String sabun;

		System.out.print("������ ���?");
		sabun = sc.next();
		for (InsaVO vv : list) {
			if (vv.getSabun().equals(sabun)) {
				list.remove(vv);
				break;
			}
		}
		System.out.println("�����Ϸ� !!!\n");
	}

	// �̸���

	public void printNameOrder() {
		Comparator<InsaVO> comp = new Comparator<InsaVO>() {

			@Override
			public int compare(InsaVO o1, InsaVO o2) {
				return o1.getName().compareTo(o2.getName());
			}
		};
		Collections.sort(list, comp);

		System.out.println("�̸��� ����....");
		for (InsaVO vv : list) {
			System.out.println(vv.getSabun() + ":" + vv.getName() + ":"
					+ vv.getPay() + ":" + ":" + vv.getTax() + ":"
					+ vv.getSilpay());
		}
		System.out.println();
	}

	// �޿���
	public void printPayOrder() {
		// �޿��� ��
		// Collections.sort(list); <---����
		// ArrayList�� ����� InsaVOŬ������ � �÷��� ������
		// ������ �������� ��Ÿ���� Comparable �������̽���
		// �����Ǿ� ���� �ʱ� �빮�� ������ �߻��Ѵ�.
		// ���� ������ �ϱ� ���ؼ��� InsaVOŬ������
		// Comparable �������̽��� �����ϰų� � �÷�����
		// ��� ������ �������� ��Ÿ���� Comparator ��
		// sort()�޼ҵ忡 ���ڷ� �Ѱܾ� �Ѵ�.

		// ������ �÷� �� ��� �����
		Comparator<InsaVO> comp = new Comparator<InsaVO>() {

			@Override
			public int compare(InsaVO o1, InsaVO o2) {
				// return o1.getPay()-o2.getPay(); // ��������
				return -(o1.getPay() - o2.getPay());// ��������
			}
		};
		Collections.sort(list, comp);

		System.out.println("�޿��� ����....");
		for (InsaVO vv : list) {
			System.out.println(vv.getSabun() + ":" + vv.getName() + ":"
					+ vv.getPay() + ":" + ":" + vv.getTax() + ":"
					+ vv.getSilpay());
		}
		System.out.println();

	}
}
