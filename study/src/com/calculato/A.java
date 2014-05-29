package com.calculato;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class A {
	protected Scanner scanner; // Scanner �غ�
	protected ArrayList<Member1> list = new ArrayList<Member1>(); // Member
																	// ArrayList
																	// ����
	private int no; // Ŭ���� ���ο��� ����� ��ȣ �̸� �غ�

	public A() { // �����ڿ� �߰��� �� �غ�
		scanner = new Scanner(System.in);
		/* * ����ó�� �Ź� ��ο� ';'�� �Է����� �ʰ� �����ؼ� �� ���� ���� �Է¹��� �� �ֽ��ϴ�. */
		list.add(new Member1().setName("ȫ�浿").setPhone("111-2222")
				.setEmail("hong@test.com").setBlog("hong.blogspot.com")
				.setAge(20).setRegDate(new Date()));
		list.add(new Member1().setName("�Ӳ���").setPhone("111-3333")
				.setEmail("leem@test.com").setBlog("leem.blogspot.com")
				.setAge(30).setRegDate(new Date()));
		list.add(new Member1().setName("������").setPhone("111-4444")
				.setEmail("ill@test.com").setBlog("ill.blogspot.com")
				.setAge(40).setRegDate(new Date()));

	}

	private void add() { // ���� ���ϴ� �ν��Ͻ� �޼���
		Member1 m = new Member1(); // Member ��ü�� �����մϴ�.

		System.out.print("�̸� : "); // ��¹�
		m.setName(scanner.nextLine()); // �Է¹��� ���� MemberŬ������ name������ �����մϴ�.

		System.out.print("��ȭ��ȣ : "); // ��¹�
		m.setPhone(scanner.nextLine()); // �Է¹��� ���� MemberŬ������ phone������ �����մϴ�.

		System.out.print("�̸��� : "); // ��¹�
		m.setEmail(scanner.nextLine()); // �Է¹��� ���� MemberŬ������ email������ �����մϴ�.

		System.out.print("��α� : "); // ��¹�
		m.setBlog(scanner.nextLine()); // �Է¹��� ���� MemberŬ������ blog������ �����մϴ�.

		System.out.print("���� : "); // ��¹�
		m.setAge(Integer.parseInt(scanner.nextLine())); // ���̴� int���� �����ؾ��ϱ� ������
														// �Է¹��� ���ڸ� int�� ����ȯ.

		System.out.print("����Ͻðڽ��ϱ�?(y/n)");
		if (scanner.nextLine().toLowerCase().equals("y")) { // (�Է¹��� ���� �ҹ��ڷ�
															// �νĵ˴ϴ�. �� ����
															// "y")�̸�
			m.setRegDate(new Date()); // ���� ��¥, �ð��� Member Ŭ������ RegDate�� ����
			list.add(m); // �迭�� m�� ������ �߰�
			System.out.println("��ϵǾ����ϴ�!"); // ��¹�
		} else {
			System.out.println("��� ����Ͽ����ϴ�!"); // ��¹�
		}
	}

	private void list() { // list �ν��Ͻ� �޼��� ����
		System.out.printf("%1$3s %2$10s %3$15s %4$30s\n", "��ȣ", "�̸�", "��ȭ",
				"�̸���"); // printf���� %s = ������

		for (int i = 0; i < list.size(); i++) {
			Member1 m = list.get(i);
		} // ���� for�� ���� ������ ǥ����
		int no = 1;
		for (Member1 m : list) {
			System.out.printf("%1$3d %2$10s %3$15s %4$30s\n", no++,
					m.getName(), m.getPhone(), m.getEmail()); // %d = ������, no��
																// 1�� ����
		}
	}

	public void execute() { // ���ο��� ȣ���ϴ� �ν��Ͻ� �޼���
		while (true) { // while���� ����ؼ� ���ϴ� ������ �� �� ���� �ݺ��ϵ��� �մϴ�.
			System.out.print("���>");
			String command = scanner.nextLine(); // command�� �Է¹��� ���� �����մϴ�.

			if (command.equals("add")) { // command���� "add"�� ������
				no = 0;
				add();
			} else if (command.equals("list")) { // �Ǵ�, command���� "list"�� ������
				no = 0;
				list();
			} else if (command.startsWith("view")) { // �Ǵ�, command���� "view"��
														// ������
				String[] values = command.split(" ");
				no = Integer.parseInt(values[1]);
				view(no);
			} else if (command.equals("update")) { // �Ǵ�, command���� "update"��
													// ������
				if (no > 0) {
					update();
				} else {
					System.out.println("���� ����� ��ȸ�ϼ���!");
				}
			} else if (command.equals("delete")) { // �Ǵ�, command���� "delete"��
													// ������
				if (no > 0) {
					detele();
				} else {
					System.out.println("���� ����� ��ȸ�ϼ���!");
				}
			} else if (command.equals("quit")) { // �Ǵ�, command���� "quit"�� ������
				System.out.println("�ȳ�!"); // "�ȳ�!"�� ����ϰ�
				break; // break�� while���� �������� ���α׷��� ����
			}
		}
	}

	private void detele() {
		list.remove(no - 1);
		no = 0;
		System.out.println("�����Ǿ����ϴ�!");
	}

	private void update() { // ������Ʈ �ν��Ͻ� �޼��� ����
		Member1 m = list.get(no - 1); // �ε�����ȣ�� 0���� ���۵Ǳ� ������ ���޹��� no���� 1�������Դϴ�.
										// �� �ε��� ��ȣ�� list������ Member�� �غ��մϴ�.
		Member1 copy = m.clone(); // Member�� clone�� copy�մϴ�. clone�� MemberŬ������
									// �����մϴ�.
		System.out.printf("��ȣ(%1$d):", no); // �ش� ��ȣ�� ����մϴ�.
		System.out.printf("�̸�(%1$s):", m.getName()); // �ش� �̸��� ����մϴ�.

		String value = scanner.nextLine(); // �Է¹��� ���� value�� �����մϴ�.
		if (value.length() > 0) { // value�� ���̰� 0���� ũ�� ��ɹ� ����. value�� ���� ������ ���ǿ�
									// �������� ���� ��ɹ��� �ǳʶݴϴ�.
			copy.setName(value); // �Է¹��� ���� copy�� name������ �����մϴ�.
		}
		System.out.printf("��ȭ(%1$s):", m.getPhone()); // �ش� ��ȭ��ȣ�� ����մϴ�.
		value = scanner.nextLine(); // �Է¹��� ���� value�� �����մϴ�.
		if (value.length() > 0) { // value�� ���̰� 0���� ũ�� ��ɹ� ����. value�� ���� ������ ���ǿ�
									// �������� ���� ��ɹ��� �ǳʶݴϴ�.
			copy.setPhone(value); // �Է¹��� ���� copy�� phone������ �����մϴ�.
		}
		System.out.printf("�̸���(%1$s):", m.getEmail()); // �ش� �̸����� ����մϴ�.
		value = scanner.nextLine(); // �Է¹��� ���� value�� �����մϴ�.
		if (value.length() > 0) { // value�� ���̰� 0���� ũ�� ��ɹ� ����. value�� ���� ������ ���ǿ�
									// �������� ���� ��ɹ��� �ǳʶݴϴ�.
			copy.setEmail(value);
		}
		System.out.printf("��α�(%1$s):", m.getBlog()); // �ش� ��α׸� ����մϴ�.
		value = scanner.nextLine(); // �Է¹��� ���� value�� �����մϴ�.
		if (value.length() > 0) { // value�� ���̰� 0���� ũ�� ��ɹ� ����. value�� ���� ������ ���ǿ�
									// �������� ���� ��ɹ��� �ǳʶݴϴ�.
			copy.setBlog(value); // �Է¹��� ���� copy�� blog������ �����մϴ�.
		}
		System.out.printf("����(%1$d):", m.getAge()); // �ش� ���̸� ����մϴ�.
		value = scanner.nextLine(); // �Է¹��� ���� value�� �����մϴ�.
		if (value.length() > 0) { // value�� ���̰� 0���� ũ�� ��ɹ� ����. value�� ���� ������ ���ǿ�
									// �������� ���� ��ɹ��� �ǳʶݴϴ�.
			copy.setAge(Integer.parseInt(value)); // �Է¹��� ���� copy�� age������ �����մϴ�.
		}

		System.out.print("�����Ͻðڽ��ϱ�?(y/n)"); // ��¹�
		if (scanner.nextLine().toLowerCase().equals("y")) { // �Է��� ���� ������ �ҹ��ڷ�
															// �ν�(toLowerCase()),
															// �Է��� ���� "y"�� ������
															// ����
															// ����(equals("y"))
			copy.setRegDate(new Date()); // ���� �ð�, ��¥������ copy�� RegDate�� �ݿ��մϴ�.
			list.set(no - 1, copy); // no���� 1 �������� �ε����� copy�� ���� list�� �������մϴ�.
			System.out.println("����Ǿ����ϴ�!"); // ��¹�
		} else { // ���� ������ �������� ������ ����
			System.out.println("���� ����Ͽ����ϴ�!"); // ��¹�
		}
	}

	private void view(int no) { // �������� �� �� ���޹޴´�. ���� ���� ���ú��� int no�� �����Ѵ�.
		// �Ϻ� ������ �����ִ� �ν��Ͻ� �޼���
		if (no > 0 && no <= list.size()) { // ���޹��� no�� 0���� ũ�ų�, ����Ʈ���̺��� ������
			Member1 m = list.get(no - 1); // �ε�����ȣ�� 0���� �����ϹǷ� -1
			System.out.println("��ȣ:" + no);
			System.out.println("�̸�:" + m.getName());
			System.out.println("��ȭ:" + m.getPhone());
			System.out.println("�̸���:" + m.getEmail());
			System.out.println("��α�:" + m.getBlog());
			System.out.println("����:" + m.getAge());
			System.out.printf("�����:%1$tY-%1$tm-%1$td \n", m.getRegDate()); // printf��
																			// �����
																			// �ѱ�������
																			// ��¥
																			// ǥ�⸦
																			// ����
																			// ��
																			// ��
																			// �ֽ��ϴ�.
																			// ��¿�)
																			// 1989-12-18
		} else {
			System.out.println("�������� �ʴ� ����� ��ȣ�Դϴ�."); // ��¹�
		}
	}

	public static void main(String[] args) { // ���� �޼���
		A app = new A(); // �ش� Ŭ������ ��ü�� ����ϴ�.
		app.execute(); // �ش� Ŭ������ execute�޼��带 ȣ��
	}
}

class Member1 {

	private String name;
	private String phone;
	private String email;
	private String blog;
	private int age;
	private Date regDate;

	// �ش� Ŭ������ �������� ����� ������ �� ������Ÿ���� ����Ͽ� ����. Date�� import java.util.Date;�� �ؾ�
	// ����� �� �ִ� Ÿ���Դϴ�.
	// * �ҽ� �Է�â���� ���콺 �������� Ŭ���Ͽ�
	// [Source] - [Generate Getters and Setters]�� �� get, set�� ���ϴ� �������� �����ϸ�
	// �Ʒ��� ���� ����� ���� �� �ֽ��ϴ�.
	public String getName() {
		return name;
	}

	public Member1 setName(String name) {
		this.name = name;
		return this;
	}

	public String getPhone() {
		return phone;
	}

	public Member1 setPhone(String phone) {
		this.phone = phone;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public Member1 setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getBlog() {
		return blog;
	}

	public Member1 setBlog(String blog) {
		this.blog = blog;
		return this;
	}

	public int getAge() {
		return age;
	}

	public Member1 setAge(int age) { // Member�� �޼����� ������ Ÿ������ ������ �����ڸ� ����µ� ������
										// �ݴϴ�.
		if (age > 0 && age < 120) { // ���̴� ��� ������ ������ �ְ�, ����ó�� ȸ���� ���̿� ������ ��ġ�°���
									// ���� ������ �κ��̱� ������ ���� ������ ���� ���� ������ �����Ͽ����ϴ�.
			this.age = age; // ���޹��� age���� �ش� Ŭ������ age������ �����մϴ�.
		}
		return this; // ���� �����մϴ�.
	}

	public Date getRegDate() {
		return regDate;
	}

	public Member1 setRegDate(Date regDate) {
		this.regDate = regDate;
		return this;
	}

	public Member1 clone() { // clone�޼��带 Member Ÿ������ �����մϴ�.
		Member1 m = new Member1();
		m.name = this.name; // ���޹��� ���� name�� m.name�� �����մϴ�.
		m.phone = this.phone;
		m.email = this.email;
		m.blog = this.blog;
		m.age = this.age;
		m.regDate = this.regDate;

		return m; // m���� �����մϴ�.
	}
}
