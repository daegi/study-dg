package com.test0331;

import java.util.Scanner;

public class CalenderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int days[]={31,28,31,30,31,30,31,31,30,31,30,31};
		int year, month, w;
		int total;
		
		Scanner sc= new Scanner(System.in);
		//�⵵�� ���� �Է� �޴´�.
		
		do{
			System.out.println("�⵵ :");
			year=sc.nextInt();
		}while(year<1);
		
		do{
			System.out.println("�� :");
			month=sc.nextInt();
		}while(month<1|month>12);
		
		
		
		if(year%4==0 && year%100 !=0 ||year %400==0)  //���� ���
			days[1]=29;
		else
			days[1]=28;
		
		// 1/1/1 ���� �������� ��¥.
		
		total=(year-1)*365+(year-1)/4-(year-1)/100+(year-1)/400;
		
		for(int i= 0; i < month-1; i++ )
			total+= days[i];
		total+=1;
		
		w=total%7;
		
		System.out.println("\n\t" + year + "�⵵" + month + "��");
		System.out.println("   ��  ��  ȭ  ��  ��  ��  ��");
		System.out.println("=============================");


		for (int i = 1; i <= w; i++)
			System.out.print("    "); //���� 4ĭ
		
		for (int i = 1; i <= days[month-1] ; i++) {
			System.out.printf("%4d", i);

			if (++w % 7 == 0)
				System.out.println();
		}
		System.out.println();

	}

}

