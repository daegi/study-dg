package com.test0423;

public class Test3 {

	public static void main(String[] args) {
		byte[] b;

		String name = new String("���ѹα�"), s;

		try {
			// ����Ʈ ĳ���� ��
			s = System.getProperty("file. encoding");
			System.out.println("����Ʈ ĳ���ͼ� : " + s + "\n");

			// ����Ʈ ĳ���ͼ����� ����Ʈ �迭 ����
			b = name.getBytes();
			System.out.println("����Ʈ ���� : " + b.length + "\n");
			for (byte bb : b) {
				String ss = Integer.toHexString(bb);
				ss = ss.substring(ss.length() - 2);
				System.out.print(ss + "  ");
			}
			System.out.println();

			// utf-8�� ��ȯ

			b = name.getBytes("utf-8");
			System.out.println("UTF-8 ���� : " + b.length);
			for (byte bb : b) {
				String ss = Integer.toHexString(bb);
				ss = ss.substring(ss.length() - 2);
				System.out.println(ss + " ");
			}

			System.out.println();
			// utf-8�� ����� ����Ʈ �迭�� String ��ü��
			// �Ķ���� ������ "utf-8" �� �ְ� ����
			// utf-8�� ���� ������ ���ڰ� ����
			System.out.println("val1:" + new String(b, "utf-8"));
			System.out.println("vaa2" + new String(b));
			System.out.println();

			/*
			 * euc-kr�� utf-8�� ��ȯ�Ѵٰ� �Ʒ��� ���� �ڵ��ϸ� �̷��� ��ȯ ������ ����Ʈ �迭�� ������ euc-kr�̵�
			 * utf-8�̵� ��� ����Ʈ �迭�� �о���� �����ִ� ���� Ȯ���� �� �ִ�. �̹� ������ ������ String ��ü��
			 * ����Ʈ �迭�� ��Ե� ������ �Ұ��� �ϴ�.
			 */
			String con = new String(s.getBytes("euc-kr"), "utf-8");
			System.out.println(con);
			b = con.getBytes();
			System.out.println("Length : " + b.length);
			b = con.getBytes("utf-8");
			System.out.println("Length : " + b.length);
			System.out.println();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
