package ch14;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileConversion {

	public static void main(String[] args) {
		
		String filename = "test.txt";
		String fileoutput = "test1.txt";

		try {
			FileReader fir = new FileReader(filename);
			FileWriter fow = new FileWriter(fileoutput);

			int data = 0;

			while ((data = fir.read()) != -1) {
				if (data != '\t' && data != '\n' && data != ' ' && data != '\r')
					fow.write(data);
			}

			fir.close();
			fow.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
