package com.test0424;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Test3 {
	public static void main(String[] args) {
		ObjectInputStream ois = null;

		try {
			// ObjectoutputStream �� �����͸� �����Ҵ� ���� ����� �����ϸ� �߰���
			// FileOutputStream ��ü�� �����ϸ� �����Ҷ����� ����� ����ǹǷ� �ҷ��� ���
			// ��Ÿ�� ������ �߻�
			// FileOutputStream fos = new FileOutputStream("ex.txt", true);<--�ι�° ���� ��Ÿ�� ����
	
			FileOutputStream fos = new FileOutputStream("ex.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(new MyRec3("ȫ�浿", "111-1111", 10));
			oos.writeObject(new MyRec3("�ڹ�", "222-2222", 15));
			oos.writeObject(new MyRec3("������", "333-3333", 20));
			oos.writeObject(new MyRec3("���̹�Ƽ��", "444-4444", 25));
			oos.close();

			FileInputStream fis = new FileInputStream("ex.txt");
			ois = new ObjectInputStream(fis);

			// ObjectInputStream�� ������ ���� �����ϸ� EOFException �߻�
			while (true) {
				MyRec3 ob = (MyRec3) ois.readObject();
				System.out.println(ob.getName() + ":" + ob.getTel() + ":"
						+ ob.getAge());
			}

		} catch (EOFException e) {
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			if (ois != null) {
				try {
					ois.close();
				} catch (Exception e2) {
				}
			}
		}

	}
}

// - Serializable �������̽� : ��ü ����ȭ
// ��ü�� ������ ���Ͽ� �����ϰų� ��Ʈ��ũ ������ �����ϵ���
// byte������ ��ȯ�ϴ� �۾��� �Ѵ�.
// - ����ȭ�� ��ü�� ����ϱ��� ������ȭ������ ��ģ��.
// - ����ȭ ��󿡼� ����
// �޼ҵ�, Ŭ��������, transient Ű���带 ���� �ʵ�
// ��, ����ȭ�� transient Ű���尡 ���� �ν��Ͻ������� �ȴ�.
class MyRec3 implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;
	private transient String tel;
	private int age;

	public MyRec3() {
	}

	public MyRec3(String name, String tel, int age) {
		this.name = name;
		this.tel = tel;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
