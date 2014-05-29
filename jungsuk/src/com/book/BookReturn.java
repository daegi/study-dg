package com.book;

import java.util.Scanner;
import java.util.Vector;

public class BookReturn {
	Vector<BOOKVO> BookVector;
	Vector<BVO> PeopleVector;

	public BookReturn() {
		this.BookVector = BookIO.BookVector;
		this.PeopleVector = MemberIO.PeopleVector;
	}

	public void bookdel() { // 7.�ݳ�
		Scanner sc = new Scanner(System.in);

		System.out.print("���̵� ? ");
		String fid = sc.next();

		System.out.print("��й�ȣ ? ");
		String fpw = sc.next();

		BVO b = null; // ���� �Է��� ��� ����
		for (BVO vi : PeopleVector) {// PeopleVector�� �ִ°��� �ϳ��� ������ �´� vi�� ����
			if (vi.getId().equals(fid) && vi.getPassword().equals(fpw)) {
				b = vi; // �׻�� Ȯ��
				break;
			}

		}

		if (b == null) {
			System.out.println("���̵� �н����尡 ���� �ʽ��ϴ�");
			return;
		} else {
			System.out.println("Ȯ�εǾ����ϴ�!");
		}

		System.out.print("å�̸� ? ");
		String Bookname = sc.next();

		BOOKVO bb = null;

		for (BOOKVO va : BookVector) {
			if (va.getBookname().equals(Bookname)) {
				bb = va;
				break;
			}
		}

		if (bb == null) {
			System.out.println("å�� �������� �ʽ��ϴ�...\n");
			return;
		}

		for (BOOKVO va : BookVector) {
			if (!va.getBookname().equals(Bookname)) {
				System.out.println("�뿩 �̷� ����");
				return;
			} else
				b.getBooklist().remove(Bookname);
			bb.setBorrowId(" ");
			System.out.println("�ݳ� �Ϸ�");
			break;

		}

	}
}