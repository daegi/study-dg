package com.book;

import java.util.Calendar;
import java.util.Scanner;
import java.util.Vector;

public class BookBorrow {
	Vector<BOOKVO> BookVector; // å��
	Vector<BVO> PeopleVector; // ȸ������

	public BookBorrow() {
		this.BookVector = BookIO.BookVector;
		this.PeopleVector = MemberIO.PeopleVector;

	}

	public void bookregister() { // �뿩

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

		Calendar cal = Calendar.getInstance();
		String s = String.format("%tF %tT", cal, cal);

		bb.setBorrowDate(s);// �ð���
		bb.setBorrowId(fid);

		b.setBooklist(Bookname);

		System.out.println("�뿩 �Ϸ�");
	}

} // �޼ҵ�
// Ŭ����

