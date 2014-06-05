package com.test0331;

import java.util.Scanner;

public class CalenderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int days[]={31,28,31,30,31,30,31,31,30,31,30,31};
		int year, month, w;
		int total;
		
		Scanner sc= new Scanner(System.in);
		//년도와 월을 입력 받는다.
		
		do{
			System.out.println("년도 :");
			year=sc.nextInt();
		}while(year<1);
		
		do{
			System.out.println("월 :");
			month=sc.nextInt();
		}while(month<1|month>12);
		
		
		
		if(year%4==0 && year%100 !=0 ||year %400==0)  //윤년 평년
			days[1]=29;
		else
			days[1]=28;
		
		// 1/1/1 부터 현제까지 날짜.
		
		total=(year-1)*365+(year-1)/4-(year-1)/100+(year-1)/400;
		
		for(int i= 0; i < month-1; i++ )
			total+= days[i];
		total+=1;
		
		w=total%7;
		
		System.out.println("\n\t" + year + "년도" + month + "월");
		System.out.println("   일  월  화  수  목  금  토");
		System.out.println("=============================");


		for (int i = 1; i <= w; i++)
			System.out.print("    "); //공백 4칸
		
		for (int i = 1; i <= days[month-1] ; i++) {
			System.out.printf("%4d", i);

			if (++w % 7 == 0)
				System.out.println();
		}
		System.out.println();

	}

}

