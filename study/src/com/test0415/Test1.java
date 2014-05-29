package com.test0415;

import java.io.IOException;

public class Test1 {

	public static void main(String[] args) {
		int data;
		
		try{
		System.out.println("ÇÑ¹®ÀÚ?");
		data=System.in.read();
		System.out.println((char)data);
		}catch(IOException e){
			System.out.println(e.toString());
		}
	}
}
