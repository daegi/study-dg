package ch14;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderEx1 {

	public static void main(String[] args) {

		String fileName = "test.txt";

		try {
			FileInputStream fis = new FileInputStream(fileName);
			FileReader fr = new FileReader(fileName);
			
			int data = 0;

			// FileInputStream 을 이용하여 파일 내용 읽어 화면에 출력
			while ((data = fis.read()) != -1) {
				System.out.print((char) data);
			}
			System.out.println();
			fis.close();

			// FileReader를 이용해서 파일 내용을 읽어 화면에 출력
			while ((data = fr.read()) != -1) {
				System.out.print((char) data);
			}
			System.out.println();
			fis.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
