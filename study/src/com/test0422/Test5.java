package com.test0422;

import java.io.File;
import java.util.Scanner;

public class Test5 {
	

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String pathname;
		
		System.out.print("삭제할 파일 또는 폴더명(예:test.txt):");
		pathname=sc.next();
		
		try {
			File f= new File(pathname);
			if(! f.exists()){
				System.out.println("파일 또는 폴더가 존재하지 않음");
				System.exit(0);
			}
			if(f.delete()){
				System.out.println("삭제성공");
			}else{
				//폴더가 비어있지 않거나 파일이 사용중일때 등
				System.out.println("삭제 실패...");
			}
			
		} catch (Exception e) {
		}

	}

}
