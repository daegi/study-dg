package com.score1;

import java.util.Scanner;

public class ScoreMain {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int ch;
		
		ScoreService service=new ScoreService();
		
		while(true) { // 무한루프
			do{
				System.out.print("1.입력 2.검색 3.출력 4.종료 => ");
				ch=sc.nextInt();
			}while(ch<1||ch>4);
			
			switch (ch) {
			case 1:	service.input(); break;
			case 2:	service.search(); break;
			case 3:service.write(); break;
			case 4:	System.exit(0); break; // 프로그램강제종료
			}
		}
		

	}

}
