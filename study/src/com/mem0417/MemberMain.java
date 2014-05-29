package com.mem0417;

import java.util.Scanner;

public class MemberMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n;
		MemberService ss = new MemberService();

		while (true) {
			do {
				System.out.print("1.가입  2.수정 3.탈퇴 4.검색 5.전체리스트 6.종료 =>");
				n = sc.nextInt();
				sc.nextLine();
			} while (n < 1 || n > 5);

			switch (n) {
			case 1:
				ss.join();
				break;
			case 2:
				ss.update();
				break;
			case 3:
				ss.remove();
				break;
			case 4:
				ss.search();
				break;
			case 5:
				ss.list();
				break;
			case 6:
				System.exit(0);
				break;

			}
		}

	}

}
