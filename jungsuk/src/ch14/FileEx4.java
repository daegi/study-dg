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
				// canRead() ���� ���α׷��� �߻� �н� ���� ��Ÿ���� ������ ���� �� �ִ��� ���θ� �׽�Ʈ�մϴ�.
				// canWrite() ���� ���α׷��� �߻� �н� ���� ��Ÿ���� ������ ������ �� �ִ��� ���θ� �׽�Ʈ�մϴ�.
				// canExecute() ���� ���α׷��� �߻� �н� ���� ��Ÿ���� ������ ������ �� �ִ��� ���θ� �׽�Ʈ�մϴ�.
				// isHidden() �� �߻� �н� ���� ��Ÿ���� ������ ������ �������� ���θ� �׽�Ʈ�մϴ�
				attribute = (f.canRead()) ? "R" : "";
				attribute += (f.canWrite()) ? "W" : "";
				attribute += (f.isHidden()) ? "H" : "";
			}
			//lastModified() ������ �����ð��� �����´�.
			System.out.printf("%s %3s %6s %s\n",df.format(new Date(f.lastModified())),attribute,size,name);
		}

	}

}
