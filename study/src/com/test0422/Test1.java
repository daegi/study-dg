package com.test0422;

import java.io.File;

public class Test1 {

	public static void main(String[] args) {

		// \\대신 실무에서는 +File.separator+를 사용해야함
		String s1 = "c:"+File.separator+"data\\test\\a.txt";
		String s2 = s1.substring(0, s1.lastIndexOf("\\"));
/*
		// 폴더가 존재하지 않으면 폴더를 생성
		File f1 = new File(s1);
		if (!f1.getParentFile().exists()) {  //!존재하지 않으면
			f1.getParentFile().mkdirs();
		}
*/
		File f1 = new File(s2);
		//폴더만 있는 경우
		if (!f1.exists()) {
			f1.mkdirs();	//뒤의 s는 모든 폴더를 만듬
			System.out.println("폴더가 만들어짐....");
		}else{
			System.out.println("이미 폴더가 존재함...");
		}
		
		String s3 = System.getProperty("user.dir");
		System.out.println("현작업경로:"+s3);
				

	}

}
