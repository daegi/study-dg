package com.test0422;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Scanner;

//���ڿ��� �Է� �޾� �Է¹��� ���ڿ��� �����ϴ� ���α׷� �ۼ�

//<��������>
//���ϸ�? a.txt
//���ڿ� �Է�...
//�׽�Ʈ
//�׽�Ʈ
//<ctrl+z>

//���� : �Է� ���� ������ �����ϴ� ��� ������ ���� 
//�����ϴ� ������ �ִٴ� �޽����� ����������� �����.

//���ϸ�?a.txt
//a.txt ������ �����մϴ�. ����ðڽ��ϱ�?[Y/N]
// system.in.read �θ� ����

public class Test2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String pathname;
		char ch;
		int data;

		try {
			// ���ϸ� �Է� �޴´�.
			System.out.print("���ϸ�?");
			pathname = sc.next();

			// �Է¹��� ���ϸ��� �̿��Ͽ� File ��ü�� �����Ѵ�
			File f1 = new File(pathname);

			// ������ �����ϴ��� Ȯ�� �Ѵ�.
			if (f1.exists()) {
				System.out.print("������ �����մϴ�. ����ðڽ��ϱ�?[Y/N]");
				ch = (char) System.in.read();
				System.in.skip(2); // ���� ����
				// ������ �����ϴ� ��� ����������� �����.
				if (ch != 'Y' && ch != 'y')
					// ����� ���� ��� ���α׷��� �����Ѵ�.
					System.exit(0);

				// FileOutpuStream ��ü�� �����Ѵ�.
				FileOutputStream fos = new FileOutputStream(pathname);

				System.out.println("���ڿ� �Է�...(ctrl+z: ����)");

				// whiile ���� �̿��Ͽ� ctrl+z�� ����� ��������
				// ������ ���Ͽ� �����Ѵ�.
				while ((data = System.in.read()) != -1) {
					fos.write(data);
				}
				// FileOutputStream ��ü�� colse �Ѵ�.
				fos.close();
			}

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}
}
