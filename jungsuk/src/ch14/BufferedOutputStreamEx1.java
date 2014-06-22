package ch14;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamEx1 {

	public static void main(String[] args) {

		BufferedOutputStream bos = null;

		try {
			FileOutputStream fos = new FileOutputStream("test.txt");

			bos = new BufferedOutputStream(fos, 5);

			for (int i = '1'; i <= '9'; i++) {
				bos.write(i);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
