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

public class BookIO {
	Scanner sc = new Scanner(System.in);
	static Vector<BOOKVO> BookVector = new Vector<BOOKVO>();// å
	private String pathname = "d:" + File.separator + "data" + File.separator
			+ "book.txt";

	public BookIO() {
		loadFile();
	}

	public void bookjoinregister() { // 3.å���
		BOOKVO bo = new BOOKVO();
		System.out.print("å �̸�");
		bo.setBookname(sc.next());
		Iterator<BOOKVO> item = BookVector.iterator();
		while (item.hasNext()) {
			BOOKVO bb = item.next(); // v ���� �ȿ� �ִ� ����
			if (bb.getBookname().equals(bo.getBookname())) {// ���;ȿ��ִ� ������ ���� �Է���
															// ������ ����??
				System.out.println("��ϵ� å�Դϴ�..");
				return;
			}
		}
		System.out.print("å �ѹ�");
		bo.setBooknumber(sc.next());
		bo.setBorrowId(" ");
		BookVector.add(bo);
	}

	public void booklist() { // 4. ��� å����

		System.out.println("[å ����Ʈ]");
		for (BOOKVO bo : BookVector) {
			System.out.println("å�̸�:" + bo.getBookname() + "\tå��ȣ:"
					+ bo.getBooknumber() + "\t�뿩ID:" + bo.getBorrowId());
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
			for (BOOKVO vo : BookVector) {
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
				BOOKVO vo = (BOOKVO) ois.readObject();
				BookVector.add(vo);
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