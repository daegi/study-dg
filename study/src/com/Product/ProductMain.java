package com.Product;

import java.util.Scanner;


public class ProductMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		
		Product ss= new ProductImpl();//��ĳ����
		
		
		while(true){
			
			do{
				System.out.print("1.�߰� 2. ��� 3.�˻� 4.���� 5.����Ʈ 6.����=>");
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
