package com.book;

import java.util.Scanner;
import java.util.Vector;

public class BookBorrowPrint {
	Scanner sc = new Scanner(System.in);
	Vector<BOOKVO> BookVector;
	Vector<BVO> PeopleVector;

	public BookBorrowPrint() {
		this.BookVector = BookIO.BookVector;
		this.PeopleVector = MemberIO.PeopleVector;
	}

	public void bookregisterlist() { // 6.�뿩����Ʈ
		System.out.print("���̵� ? ");
		String fid = sc.next();

		System.out.print("��й�ȣ ? ");
		String fpw = sc.next();

		BOOKVO cc = null;
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

		System.out.println("[�뿩 ����Ʈ]");

		System.out.println(b.getBooklist());
	}

}
