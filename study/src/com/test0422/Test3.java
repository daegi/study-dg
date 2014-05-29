package com.test0422;

import java.io.File;
import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		String pathname;
		
		try {
			System.out.print("파일 도는 폴더명(예: c:\\windows)?");
			pathname=sc.next();
			
			File f= new File(pathname);
			if(! f.exists()){
				System.out.println("존재하지 않은 파일 또는 경로입니다");
				System.exit(0);
			}
			if(f.isFile()){
				//파일인 경우
				System.out.println(f.getName()+":"+f.length()+"Bytes.");
			}else if(f.isDirectory()){
				//폴더인 경우
				//폴더안의 모든 폴더 및 파일 리스트 얻기
				File[] fs=f.listFiles();
				for(int i=0; i<fs.length;i++){
					File ff=fs[i];
					if(ff.isFile()){
						System.out.println(ff.getName()+":"+ff.length()+"Bytes.");
					}else if (ff.isDirectory()){
						System.out.println("폴더명:"+ff.getName());
					}
				}
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}
