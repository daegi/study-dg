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
			temp = JOptionPane.showInputDialog("1~100사이 숫자 입력"+"끝내려면 -1");
			
			if(temp==null ||temp.equals("-1"))break;
			
			System.out.println("입력값 : "+temp);
			input = Integer.parseInt(temp);
			
			if(anser >input){
				System.out.println("더 큰수 입력");
			}else if(anser<input){
				System.out.println("더 작은수 입력");
			}else{ 
				System.out.println("맞췄습니다.");
				System.out.println("시도횟수는 "+count+"번입니다.");
				break;
			
			}

		}while(true);

	}

}
