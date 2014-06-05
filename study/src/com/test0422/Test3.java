package com.test0422;

import java.io.File;
import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		String pathname;
		
		try {
			System.out.print("���� ���� ������(��: c:\\windows)?");
			pathname=sc.next();
			
			File f= new File(pathname);
			if(! f.exists()){
				System.out.println("�������� ���� ���� �Ǵ� ����Դϴ�");
				System.exit(0);
			}
			if(f.isFile()){
				//������ ���
				System.out.println(f.getName()+":"+f.length()+"Bytes.");
			}else if(f.isDirectory()){
				//������ ���
				//�������� ��� ���� �� ���� ����Ʈ ���
				File[] fs=f.listFiles();
				for(int i=0; i<fs.length;i++){
					File ff=fs[i];
					if(ff.isFile()){
						System.out.println(ff.getName()+":"+ff.length()+"Bytes.");
					}else if (ff.isDirectory()){
						System.out.println("������:"+ff.getName());
					}
				}
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}
