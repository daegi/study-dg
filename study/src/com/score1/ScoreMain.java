package com.score1;

import java.util.Scanner;

public class ScoreMain {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int ch;
		
		ScoreService service=new ScoreService();
		
		while(true) { // ���ѷ���
			do{
				System.out.print("1.�Է� 2.�˻� 3.��� 4.���� => ");
				ch=sc.nextInt();
			}while(ch<1||ch>4);
			
			switch (ch) {
			case 1:	service.input(); break;
			case 2:	service.search(); break;
			case 3:service.write(); break;
			case 4:	System.exit(0); break; // ���α׷���������
			}
		}
		

	}

}
