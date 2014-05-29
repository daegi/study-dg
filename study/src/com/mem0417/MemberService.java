package com.mem0417;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

//Map�������̽�->����Ŭ���� : Hashtable, HashMap
public class MemberService {
	private Scanner sc = new Scanner(System.in);
	private HashMap<String, MemberVO> map = new HashMap<String, MemberVO>();

	// ����
	public void join() {
		String id;
		System.out.print("���̵�?");
		id = sc.next();
		if (map.containsKey(id)) { // ������ Ű�� ������
			System.out.println("������ ���̵� �����մϴ�.\n");
			return;
		}

		MemberVO vo = new MemberVO();
		System.out.print("�н�����?");
		vo.setPwd(sc.next());
		System.out.print("�̸�?");
		vo.setName(sc.next());
		System.out.print("��ȭ?");
		vo.setTel(sc.next());
		System.out.print("����?");
		vo.setAge(sc.nextInt());

		map.put(id, vo); // Map�� ����

		System.out.println("�Է� �Ϸ�...\n");
	}

	// ����
	public void update() {
		String id, pwd;
		System.out.print("���̵�?");
		id = sc.next();
		System.out.print("�н�����?");
		pwd = sc.next();
		if (!map.containsKey(id)) { // �������� ������
			System.out.println("���̵� �Ǵ� �н����尡 Ʋ��...\n");
			return;
		}

		// �ش� ���̵��� ������ ��������
		MemberVO vo = map.get(id);

		if (!vo.getPwd().equals(pwd)) {
			System.out.println("���̵� �Ǵ� �н����尡 Ʋ��...\n");
			return;
		}

		// vo�� ������ �����͸� �ٽ� �Է��ؼ� �����ϸ� ������
		System.out.print("�������н�����?");
		vo.setPwd(sc.next());
		System.out.print("��������ȭ?");
		vo.setTel(sc.next());
		System.out.print("�����ҳ���?");
		vo.setAge(sc.nextInt());
	}

	// Ż��
	public void remove() {
		System.out.println("ȸ��  Ż��...");

		String id, pwd;
		System.out.print("���̵�?");
		id = sc.next();
		System.out.print("�н�����?");
		pwd = sc.next();

		MemberVO vo = map.get(id);
		if (vo == null) { // ���̵�˻�
			System.out.println("���̵� �Ǵ� �н����� Ʋ��...");
			return;
		}

		if (!vo.getPwd().equals(pwd)) {
			System.out.println("���̵� �Ǵ� �н����� Ʋ��...");
			return;
		}

		map.remove(id);
		System.out.println("Ż���ߴ�...\n");
	}

	// �˻�
	public void search() {
		System.out.println("ȸ�� �˻�...");

		String name;
		System.out.print("�˻����̸�?");
		name = sc.next();

		Iterator<String> it = map.keySet().iterator();
		while (it.hasNext()) {
			String id = it.next();
			MemberVO vo = map.get(id);
			if (vo.getName().equals(name)) {
				System.out.println(id + ":" + vo.getName() + ":" + vo.getPwd()
						+ ":" + vo.getTel() + ":" + vo.getAge());
			}
		}
		System.out.println();
	}

	// ����Ʈ
	public void list() {
		System.out.println("ȸ�� ��ü����Ʈ...");

		Iterator<String> it = map.keySet().iterator();
		while (it.hasNext()) {
			String id = it.next();
			MemberVO vo = map.get(id);
			System.out.println(id + ":" + vo.getName() + ":" + vo.getPwd()
					+ ":" + vo.getTel() + ":" + vo.getAge());
		}
		System.out.println();
	}
}
