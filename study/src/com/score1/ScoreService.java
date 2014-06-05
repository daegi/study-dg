package com.score1;

import java.util.Scanner;

public class ScoreService {
	// 50���� �����͸� ������ Score�� �迭 ����
	private ScoreVO []ss=new ScoreVO[50];
	// private Score s1, s2, s3, ....; ó�� Score�� ��� 50������
	
	// �ο���
	private int count;
	
	private Scanner sc=new Scanner(System.in);
	
	// �Է�
	public void input() {
		if(count>=50) {
			System.out.println("\n�Է� �ʰ�....\n");
			return;
		}
		
		System.out.println("\n�ڷ� �Է�...");
		
		String[] title={"����?","����?","����?"};
		
		// ���κ��� Score []ss=new Score[50];�� ��ü�� ����
		//    �޸� �Ҵ��� �ƴϹǷ� �ݵ�� 
		//   ss[0]=new Score(); ������ ��ü�� �����ؾ���
		
		ss[count]=new ScoreVO();
		
		System.out.print("�̸�?");
		ss[count].name=sc.next();
		// 3���� ���� �Է� �ް� ���� ���ϱ�
		for(int i=0; i<ss[count].score.length; i++) {
			System.out.print(title[i]);
			ss[count].score[i]=sc.nextInt();
			ss[count].tot+=ss[count].score[i]; // �������ϱ�
		}
		ss[count].ave=ss[count].tot/3;
		count++; // �ο��� �����ϱ�
		
		System.out.println();
	}
	
	// ���
	public void write() {
		System.out.println("\n��ü ���...");
		
		ranking() ;
		
		for(int i=0; i<count; i++) {
			System.out.print(ss[i].name+"\t\t");
			for(int j=0; j<ss[i].score.length; j++) {
				System.out.printf("%5d", ss[i].score[j]);
			}
			System.out.printf("%5d%5d%5d\n", ss[i].tot, ss[i].ave, ss[i].rank);
			
			// �������
			System.out.print("\t\t");
			for(int j=0; j<ss[i].score.length; j++) {
				System.out.printf("%5c", grade(ss[i].score[j]));
			}
			System.out.println();
	
		}
	}
	
	// �������ϱ�
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
	
	// �˻�
	public void search() {
		System.out.println("\n�ڷ� �˻�...");
	}
	
}
