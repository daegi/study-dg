package com.test0423;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Test2 {

	public static void main(String[] args) {
		String s;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			
			//���ڿ� ������ ����Ʈ �迭���� �ٲ�()
			FileOutputStream fos = new FileOutputStream("ex.txt"); 
			System.out.println("���ڿ� �Է�...");
			while ((s = br.readLine()) != null) {
				byte[] b = s.getBytes();
				fos.write(b);
			}
			fos.close();
		}catch(Exception e){
			
		
		}

	}

}
