package com.test0422;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Scanner;

//문자열을 입력 받아 입력받은 문자열을 저장하는 프로그램 작성

//<실행형식>
//파일명? a.txt
//문자열 입력...
//테스트
//테스트
//<ctrl+z>

//조건 : 입력 받은 파일이 존재하는 경우 다음과 같이 
//존재하는 파일이 있다는 메시지와 덮어쓸것인지를 물어본다.

//파일명?a.txt
//a.txt 파일이 존재합니다. 엎어쓰시겠습니까?[Y/N]
// system.in.read 로만 가능

public class Test2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String pathname;
		char ch;
		int data;

		try {
			// 파일명 입력 받는다.
			System.out.print("파일명?");
			pathname = sc.next();

			// 입력받은 파일명을 이용하여 File 객체를 생성한다
			File f1 = new File(pathname);

			// 파일이 존재하는지 확인 한다.
			if (f1.exists()) {
				System.out.print("파일이 존재합니다. 엎어쓰시겠습니까?[Y/N]");
				ch = (char) System.in.read();
				System.in.skip(2); // 엔터 버림
				// 파일이 존재하는 경우 덮어쓸것인지를 물어본다.
				if (ch != 'Y' && ch != 'y')
					// 덮어쓰지 않을 경우 프로그램을 종료한다.
					System.exit(0);

				// FileOutpuStream 객체를 생성한다.
				FileOutputStream fos = new FileOutputStream(pathname);

				System.out.println("문자열 입력...(ctrl+z: 종료)");

				// whiile 문을 이용하여 ctrl+z를 누루기 전가지의
				// 내용을 파일에 저장한다.
				while ((data = System.in.read()) != -1) {
					fos.write(data);
				}
				// FileOutputStream 객체를 colse 한다.
				fos.close();
			}

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}
}
