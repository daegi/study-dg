package com.test0421;

//InputStream�� read() �޼ҵ�� IOException��
// checked exception�� �߻��ϹǷ� ����ó���� ���� IOExcoption
// IOExcepiton �� import
import java.io.IOException;

//�ϳ��� java ���Ͽ��� public class�� �ϳ��� �����ؾ� ��
public class Test3 {

	public static void main(String[] args) {
		int n, s, data; // �⺻ �ڷ����� int���� ����
						// n: �Է��� ���� ����
						// s: ������
						// data : Ű����� �Է��� ������ ASCII�ڵ� ����

		try { // ����ó�� : read()�޼ҵ�� �ݵ�� ���߸� ó���ؾ���
				// ���ܰ� �߻��� ���ɼ��� �ִ� �ڵ带 ���

			// ������ �Է��ؾ� �ϴ����� ȭ�鿡 ��
			System.out.print("����?");

			// ���� �Է�
			n = 0; // �Է¹��� ������ �����ϱ� ���� 0���� �ʱ�ȭ

			// ���͸� ���� ������ �Է�(����:ASCII�ڵ� 13)
			while ((data = System.in.read()) != -13) {
				// ���� 0�� ASCII�ڵ�� 48�̸� ���ڷ� �ٲٱ� ���� 48�� ����
				// �տ� �Էµ� ���ڸ� ó���ϱ� ���� 10�� ������
				n = n * 10 + (data - 48);
			}

			// �հ��
			s = 0;// ���� �����ϱ� ���� 0���� �ʱ�ȭ
			// �ݺ���: for(�ʱ�ȭ:����:���ʱ�)
			// ������ �����ϸ� �ݺ� �����ϸ� �ݺ�Ƚ���� ���������
			// for���� �ݺ�Ƚ���� �������� ���� ��� while�� ���
			for (int i = 1; i <= n; i++) {
				s += i; // 1~�Է¹��� �������� ���� s������ ����
			}

			// ���
			System.out.println(s); // ���� ���

		} catch (IOException e) { // IOException ó��
			// IOException�� �߻��� ��� ����
			// ���� �޽����� �ֿܼ� ���
			System.out.println(e.toString());
		} // chatch ��

	}

}
