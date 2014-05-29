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

	public void bookregisterlist() { // 6.대여리스트
		System.out.print("아이디 ? ");
		String fid = sc.next();

		System.out.print("비밀번호 ? ");
		String fpw = sc.next();

		BOOKVO cc = null;
		BVO b = null; // 지금 입력한 사람 없고
		for (BVO vi : PeopleVector) {// PeopleVector에 있는것을 하나씩 가지고 온다 vi로 잡음
			if (vi.getId().equals(fid) && vi.getPassword().equals(fpw)) {
				b = vi; // 그사람 확신
				break;
			}

		}

		if (b == null) {
			System.out.println("아이디나 패스워드가 맞지 않습니다");
			return;
		} else {
			System.out.println("확인되었습니다!");
		}

		System.out.println("[대여 리스트]");

		System.out.println(b.getBooklist());
	}

}
