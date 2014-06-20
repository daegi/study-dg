package ch14;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileEx4 {

	public static void main(String[] args) {
		String currDir = System.getProperty("user.dir");
		File dir = new File(currDir);

		File[] files = dir.listFiles();

		for (int i = 0; i < files.length; i++) {
			File f = files[i];
			String name = f.getName();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mma");
			String attribute = "";
			String size = "";

			if (files[i].isDirectory()) {
				attribute = "DIR";
			} else {
				size = f.length() + "";
				// canRead() 응용 프로그램이 추상 패스 명이 나타내는 파일을 읽을 수 있는지 여부를 테스트합니다.
				// canWrite() 응용 프로그램이 추상 패스 명이 나타내는 파일을 수정할 수 있는지 여부를 테스트합니다.
				// canExecute() 응용 프로그램이 추상 패스 명이 나타내는 파일을 실행할 수 있는지 여부를 테스트합니다.
				// isHidden() 이 추상 패스 명이 나타내는 파일이 숨겨진 파일인지 여부를 테스트합니다
				attribute = (f.canRead()) ? "R" : "";
				attribute += (f.canWrite()) ? "W" : "";
				attribute += (f.isHidden()) ? "H" : "";
			}
			//lastModified() 마지막 수정시간을 가져온다.
			System.out.printf("%s %3s %6s %s\n",df.format(new Date(f.lastModified())),attribute,size,name);
		}

	}

}
