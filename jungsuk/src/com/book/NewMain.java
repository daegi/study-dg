package com.book;

import java.util.Scanner;

public class NewMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ch;

		MemberIO mio = new MemberIO(); // 회원가입 및 회원리스트
		BookIO bi = new BookIO(); // 책등록 및 출력

		BookBorrow bb = new BookBorrow(); // 대여클래스
		BookBorrowPrint bbp = new BookBorrowPrint(); // 대여리스트 클래스
		BookReturn br = new BookReturn(); // 반납클래스

		while (true) {// 무한루프
			do {
				System.out
						.println("1.회원가입 2.모든회원보기 3.책등록 4.모든책보기 5.대여 6.대여리스트 7.반납 8.Exit => ");
				ch = sc.nextInt();
			} while (ch < 1 || ch > 8);

			if (ch == 1) {
				mio.join();
			}
			if (ch == 2) {
				mio.memberlist();
			}
			if (ch == 3) {
				bi.bookjoinregister();
			}
			if (ch == 4) {
				bi.booklist();
			}
			if (ch == 5) {
				bb.bookregister();
			}
			if (ch == 6) {
				bbp.bookregisterlist();
			}
			if (ch == 7) {
				br.bookdel();
			}
			if (ch == 8) {
				bi.saveFile();
				mio.saveFile();
				System.exit(0);
				break;
			}

		}
	}
}