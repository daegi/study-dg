package com.test0422;

import java.io.File;
import java.util.Scanner;

public class Test5 {
	

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String pathname;
		
		System.out.print("������ ���� �Ǵ� ������(��:test.txt):");
		pathname=sc.next();
		
		try {
			File f= new File(pathname);
			if(! f.exists()){
				System.out.println("���� �Ǵ� ������ �������� ����");
				System.exit(0);
			}
			if(f.delete()){
				System.out.println("��������");
			}else{
				//������ ������� �ʰų� ������ ������϶� ��
				System.out.println("���� ����...");
			}
			
		} catch (Exception e) {
		}

	}

}
