package com.test0415;

import java.util.Scanner;

public class Test7 {
	public static void main(String[] args) {
		Ex7 x=new Ex7();
		
		
		try{
		x.input();
		int n=x.getValue();
		System.out.println(n);
		}catch(Exception e){
			System.out.println(e.toString());
		}
	}
}

class Ex7 {
	private int value;
	private Scanner sc=new Scanner(System.in);
	
	public void setValue(int value) throws Exception {
		if(value<0)
			throw new Exception("���� 0���� ������ �����ϴ�.");
		this.value=value;
	}
	public int getValue() {
		return value;
	}
	
	public void input() throws Exception {
		int n;
		try {
			System.out.print("����?");
			n=sc.nextInt();
			setValue(n);
		} catch (Exception e) {
			// ���ܸ� �ٽ� ����
			throw e;
			// System.out.println(e.toString());
		}
	}
}
