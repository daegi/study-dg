package com.test0423;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Test1 {

	public static void main(String[] args) {
		String s;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		////////////////////////////////////////////////////////////////////////////////////////
		try {
			FileOutputStream fos = new FileOutputStream("ex.txt"); 
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos)); 
			
			System.out.println("문자열 입력...");
			while ((s = br.readLine()) != null) {
				bw.write(s);
				bw.newLine();
			}
			bw.close();

		////////////////////////////////////////////////////////////////////////////////////////
			
			
			BufferedReader br1 = new BufferedReader(new InputStreamReader(
					new FileInputStream("ex.txt"), "MS949"));
			BufferedWriter bw1 = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream("ex1.txt"), "UTF-8"));

			while ((s = br1.readLine()) != null) {
				bw1.write(s);
				bw1.newLine();
			}
			br1.close();
			bw1.close();

		} catch (Exception e) {
		}
		
		try {
			
		} catch (Exception e) {
		}

	}

}
