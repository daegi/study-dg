package com.book;

import java.util.Calendar;
import java.util.Scanner;
import java.util.Vector;

public class BookBorrow {
	Vector<BOOKVO> BookVector; // 책쪽
	Vector<BVO> PeopleVector; // 회원관리

	public BookBorrow() {
		this.BookVector = BookIO.BookVector;
		this.PeopleVector = MemberIO.PeopleVector;

	}

	public void bookregister() { // 대여

		Scanner sc = new Scanner(System.in);

		System.out.print("아이디 ? ");
		String fid = sc.next();

		System.out.print("비밀번호 ? ");
		String fpw = sc.next();

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
		

		System.out.print("책이름 ? ");
		String Bookname = sc.next();

		BOOKVO bb = null;

		for (BOOKVO va : BookVector) {
			if (va.getBookname().equals(Bookname)) {
				bb = va;
				break;
			}
		}

		if (bb == null) {
			System.out.println("책이 존재하지 않습니다...\n");
			return;
		}

		Calendar cal = Calendar.getInstance();
		String s = String.format("%tF %tT", cal, cal);

		bb.setBorrowDate(s);// 시간아
		bb.setBorrowId(fid);

		b.setBooklist(Bookname);

		System.out.println("대여 완료");
	}

} // 메소드
// 클래스

