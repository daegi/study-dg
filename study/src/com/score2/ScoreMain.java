package com.score2;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class ScoreMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		Score ss = new Score();
		
		JOptionPane.showMessageDialog(null, "성적처리");
		while (true) {
			do {
				System.out.print("1.입력 2.검색.3.삭제.4.출력.5.종료 :");
				n = sc.nextInt();
			} while (n < 1 || n > 5);

			switch (n) {
			case 1:
				ss.input();
				break;
			case 2:
				ss.search();
				break;
			case 3:
				ss.remove();
				break;
			case 4:
				ss.print();
				break;
			case 5:
				System.exit(0);
				break;

			}
		}

	}

}
