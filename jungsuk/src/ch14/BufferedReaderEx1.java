package ch14;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderEx1 {

	public static void main(String[] args) {

		BufferedReader br;

		try {
			FileReader fr = new FileReader("BufferedReaderEx1.java");
			br = new BufferedReader(fr);

			String line = "";
			for (int i = 1; (line = br.readLine()) != null; i++) {
				// ";"를 포함한 라인을 출력한다.
				if (line.indexOf(";") != -1)
					System.out.println(i + ":" + line);
			}
		} catch (IOException e) {
		}
	} // main
}