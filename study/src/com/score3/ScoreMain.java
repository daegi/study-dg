package com.score3;

import java.util.Scanner;

public class ScoreMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		
		Score ss= new ScoreImpl();//업캐스팅
		
		
		while(true){
			
			do{
				System.out.print("1.입력 2.수정 3.삭제 4.검색 5.이름순 6.총점순 7.종료=>");
				n=sc.nextInt();
				
			}while(n<1 || n>7);
			
			switch(n){
			case 1: ss.input();break;
			case 2: ss.update();break;
			case 3: ss.remove();break;
			case 4: ss.search();break;
			case 5: ss.nameOrder();break;
			//case 6: ss.loadFile();break;
			case 7: ss.saveFile(); System.exit(0);	break;
			
			}
			
		}

	}

}
