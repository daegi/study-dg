package com.score1;

import java.util.Scanner;

public class ScoreService {
	// 50명의 데이터를 저장할 Score형 배열 선언
	private ScoreVO []ss=new ScoreVO[50];
	// private Score s1, s2, s3, ....; 처럼 Score형 밴수 50개선언
	
	// 인원수
	private int count;
	
	private Scanner sc=new Scanner(System.in);
	
	// 입력
	public void input() {
		if(count>=50) {
			System.out.println("\n입력 초과....\n");
			return;
		}
		
		System.out.println("\n자료 입력...");
		
		String[] title={"국어?","영어?","수학?"};
		
		// 윗부분의 Score []ss=new Score[50];는 객체에 대한
		//    메모리 할당이 아니므로 반드시 
		//   ss[0]=new Score(); 식으로 객체를 생성해야함
		
		ss[count]=new ScoreVO();
		
		System.out.print("이름?");
		ss[count].name=sc.next();
		// 3과목 점수 입력 받고 총점 구하기
		for(int i=0; i<ss[count].score.length; i++) {
			System.out.print(title[i]);
			ss[count].score[i]=sc.nextInt();
			ss[count].tot+=ss[count].score[i]; // 총점구하기
		}
		ss[count].ave=ss[count].tot/3;
		count++; // 인원수 증가하기
		
		System.out.println();
	}
	
	// 출력
	public void write() {
		System.out.println("\n전체 출력...");
		
		ranking() ;
		
		for(int i=0; i<count; i++) {
			System.out.print(ss[i].name+"\t\t");
			for(int j=0; j<ss[i].score.length; j++) {
				System.out.printf("%5d", ss[i].score[j]);
			}
			System.out.printf("%5d%5d%5d\n", ss[i].tot, ss[i].ave, ss[i].rank);
			
			// 학점출력
			System.out.print("\t\t");
			for(int j=0; j<ss[i].score.length; j++) {
				System.out.printf("%5c", grade(ss[i].score[j]));
			}
			System.out.println();
	
		}
	}
	
	// 석차구하기
	public void ranking() {
		for(int i=0; i<count; i++)
			ss[i].rank=1;
		
		for(int i=0; i<count-1; i++) {
			for(int j=i+1;j<count; j++) {
				if(ss[i].tot>ss[j].tot)
					ss[j].rank++;
				else if(ss[i].tot<ss[j].tot)
					ss[i].rank++;
			}
		}
	}
	
	public char grade(int s) {
		char c;
		
		switch(s/10) {
		case 10:
		case 9:c='A';break;
		case 8:c='B';break;
		case 7:c='C';break;
		case 6:c='D';break;
		default:c='F';break;
		}
		
		return c;
	}
	
	// 검색
	public void search() {
		System.out.println("\n자료 검색...");
	}
	
}
