package com.test0421;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test12 {

	public static void main(String[] args) {

		try {
			// 파일에 대한 정보를 구하거나, 파일(폴더)리스트,
			// 폴더 생성 파일 및 폴더 제거, 파일또는 폴더명 변경

			String s = "test.txt"; // 파일
			// 폴더와 파일의 구분자 :File separator
			// String s = "c:" + File.separator + "windows"; // 폴더
			File f = new File(s);

			if (f.exists()) // 파일 또는 폴더가 존재하는지 확인
				System.out.println(s + "는 존재합니다.");
			else
				System.out.println(s + "는 존재하지 않습니다.");

			System.out.println("파일명:" + f.getName());
			System.out.println("절대경로:" + f.getAbsolutePath());
			// System.out.println("경로:"+f.getPath());
			System.out.println("길이:" + f.length()); // long형

			Date dd = new Date(f.lastModified());
			System.out.println("만든날짜:" + dd);

			SimpleDateFormat ff = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

			String ss = ff.format(dd);
			System.out.println("만든날짜" + dd);
			System.out.println("만들날짜" + ss);

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}
