package com.book;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

public class MemberIO {
	Scanner sc = new Scanner(System.in);
	static Vector<BVO> PeopleVector = new Vector<BVO>();// ȸ������
	private String pathname = "d:" + File.separator + "data" + File.separator
			+ "member.txt";

	public MemberIO() {
		loadFile();
	}

	public void join() { // 1. ȸ������
		BVO vo = new BVO();
		System.out.print("���̵�");
		vo.setId(sc.next());
		Iterator<BVO> it = PeopleVector.iterator();
		while (it.hasNext()) {
			BVO vv = it.next(); // v ���� �ȿ� �ִ� ����
			if (vv.getId().equals(vo.getId())) {
				System.out.println("��ϵ� ���̵� �Դϴ�.");
				return;
			}
		}
		System.out.print("��й�ȣ");
		vo.setPassword(sc.next());
		System.out.print("�̸�");
		vo.setName(sc.next());
		System.out.print("����");
		vo.setAge(sc.nextInt());
		System.out.print("��ȭ��ȣ");
		vo.setTel(sc.next());

		PeopleVector.add(vo);
	}

	public void memberlist() { // 2. ��� ȸ�� ���
		System.out.println("\n[ȸ�� ����Ʈ]");// ȸ�� ����Ʈ ���

		for (BVO bo : PeopleVector) {
			System.out.println("���̵�:" + bo.getId() + "\t��й�ȣ:"
					+ bo.getPassword() + "\t�̸�:" + bo.getName() + "\t����:"
					+ bo.getAge() + "\t��ȭ��ȣ" + bo.getTel());

		}

	}

	public void saveFile() {

		try {
			// ������ �����ϴ��� Ȯ��
			File f = new File(pathname);
			// ������ �������� ������ ������ ����
			if (!f.getParentFile().exists()) {
				f.getParentFile().mkdirs();
			}

			// ���Ͽ� �����ϱ�
			FileOutputStream fos = new FileOutputStream(f);
			// ��ü�� �����ϱ� ����
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			// ArrayList ��ü�� ������ ���
			// oos.writeObject(list);

			// ArrayList�� ����� ProductVO ��ü�� ���Ͽ� ����
			for (BVO vo : PeopleVector) {
				oos.writeObject(vo);
			}
			oos.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	private void loadFile() {
		FileInputStream fis = null;
		ObjectInputStream ois = null;

		try {
			File f = new File(pathname);
			if (!f.exists()) // ������ �������� ������
				return;

			fis = new FileInputStream(f);
			// ��ü�� �о� ���̱� ����
			ois = new ObjectInputStream(fis);

			// ArrayList ��ü�� ����� ���
			// ArrayList list1=(ProductVO)ois.readObject();

			// ������ ������ ��ü(ProductVO)�� �о ArrayList�� ����
			while (true) {
				BVO vo = (BVO) ois.readObject();
				PeopleVector.add(vo);
			}

		} catch (EOFException e) {
			// ObjectInputStream�� ������ ������ �� �о� ���̸�
			// EOFException �� �߻��ϹǷ� �ٸ� ó���� ����
			// �ʾƵ� �ȴ�.

		} catch (Exception e) {
			System.out.println(e.toString());

		} finally { // ���ܰ� �߻��ϰų� ���� ���� ���
			if (ois != null) {
				try {
					ois.close();
				} catch (Exception e2) {
				}
			}
		}
	}
}