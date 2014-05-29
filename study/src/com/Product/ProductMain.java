package com.Product;

import java.util.Scanner;


public class ProductMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		
		Product ss= new ProductImpl();//업캐스팅
		
		
		while(true){
			
			do{
				System.out.print("1.추가 2. 출고 3.검색 4.삭제 5.리스트 6.종료=>");
				n=sc.nextInt();
				
			}while(n<1 || n>6);
			
			switch(n){
			case 1: ss.input();break;
			case 2: ss.updata();break;
			case 3: ss.search();break;
			case 4: ss.remove();break;
			case 5: ss.list();break;
			//case 6: ss.loadFile();break;
			case 6: ss.saveFile(); System.exit(0);	break;
			
			}
			
		}

	}

}
