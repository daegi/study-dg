package ch14;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class StandardIOEx3 {

	public static void main(String[] args) {

		
		try {
			FileOutputStream fos = new FileOutputStream("test.txt");
			PrintStream ps = new PrintStream(fos);
			System.setOut(ps);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println("hello by System.out");
		System.err.println("Hello by System.err");

	}

}
