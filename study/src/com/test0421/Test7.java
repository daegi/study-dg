package com.test0421;







import java.io.FileInputStream;

public class Test7 {

	public static void main(String[] args) {
		int data;

		try {
			// ������ �������� ������ FileNoFoundException�� �߻�
			FileInputStream fis = new FileInputStream("test.txt");
			
			while ((data = fis.read()) != -1) {
				System.out.write(data);
			}
			System.out.flush(); //��� ��Ʈ���� close�ϰų�
			//��½�Ʈ������ flush() ���� ������
			//������ ���� ����� �ݿ����� �ʴ´�.
			//������ ��� ���۰� �����ʴ� ���¿���
			//������ ������ ��� ��ġ�� ������ �ʱ⶧���̴�.
			//�̷���� flush() �� ȣ���Ͽ� ������ ������
			//��� ��ġ�� ������ �����ϰ� �ذ��Ѵ�. �Ǵ�
			//�����ġ��close()�Ѵ�
			
			fis.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}
