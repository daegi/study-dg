package com.ex0401;

import javax.swing.JOptionPane;

public class ArrayEx16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int anser = (int)(Math.random()*100)+1;
		int input =0;
		String temp ="";
		int count =0;
		
		do{
			count++;
			temp = JOptionPane.showInputDialog("1~100���� ���� �Է�"+"�������� -1");
			
			if(temp==null ||temp.equals("-1"))break;
			
			System.out.println("�Է°� : "+temp);
			input = Integer.parseInt(temp);
			
			if(anser >input){
				System.out.println("�� ū�� �Է�");
			}else if(anser<input){
				System.out.println("�� ������ �Է�");
			}else{ 
				System.out.println("������ϴ�.");
				System.out.println("�õ�Ƚ���� "+count+"���Դϴ�.");
				break;
			
			}

		}while(true);

	}

}
