package ch7;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ImportTest {

	public static void main(String[] args) {

		Date today = new Date();

		SimpleDateFormat date = new SimpleDateFormat("yyyy:MM:dd");
		SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss a");

		System.out.println("¿À´Ã ³¯Â¥´Â" + date.format(today));
		System.out.println("¿À´Ã ³¯Â¥´Â" + time.format(today));

	}

}
