package com.book;

import java.util.Scanner;

public class NewMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ch;

		MemberIO mio = new MemberIO(); // ȸ������ �� ȸ������Ʈ
		BookIO bi = new BookIO(); // å��� �� ���

		BookBorrow bb = new BookBorrow(); // �뿩Ŭ����
		BookBorrowPrint bbp = new BookBorrowPrint(); // �뿩����Ʈ Ŭ����
		BookReturn br = new BookReturn(); // �ݳ�Ŭ����

		while (true) {// ���ѷ���
			do {
				System.out
						.println("1.ȸ������ 2.���ȸ������ 3.å��� 4.���å���� 5.�뿩 6.�뿩����Ʈ 7.�ݳ� 8.Exit => ");
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