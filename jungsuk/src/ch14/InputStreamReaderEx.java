package ch14;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InputStreamReaderEx {

	public static void main(String[] args) {

		String line = "";

		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);

			System.out.println("������� OS�� ���ڵ�:" + isr.getEncoding());

			do {
				System.out.print("������ �Է��ϼ���. ���� �Ϸ��� q�� �Է��ϼ���.");
				line = br.readLine();
				System.out.println("�Է��Ͻ� ���� : " + line);

			} while (!line.equalsIgnoreCase("q"));
			System.out.println("���α׷��� �����մϴ�.");

		} catch (Exception e) {
		}

	}

}
