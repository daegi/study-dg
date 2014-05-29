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
	static Vector<BOOKVO> BookVector = new Vector<BOOKVO>();// 책
	private String pathname = "d:" + File.separator + "data" + File.separator
			+ "book.txt";

	public BookIO() {
		loadFile();
	}

	public void bookjoinregister() { // 3.책등록
		BOOKVO bo = new BOOKVO();
		System.out.print("책 이름");
		bo.setBookname(sc.next());
		Iterator<BOOKVO> item = BookVector.iterator();
		while (item.hasNext()) {
			BOOKVO bb = item.next(); // v 백터 안에 있는 변수
			if (bb.getBookname().equals(bo.getBookname())) {// 백터안에있는 변수와 내가 입력한
															// 변수가 같니??
				System.out.println("등록된 책입니다..");
				return;
			}
		}
		System.out.print("책 넘버");
		bo.setBooknumber(sc.next());
		bo.setBorrowId(" ");
		BookVector.add(bo);
	}

	public void booklist() { // 4. 모든 책보기

		System.out.println("[책 리스트]");
		for (BOOKVO bo : BookVector) {
			System.out.println("책이름:" + bo.getBookname() + "\t책번호:"
					+ bo.getBooknumber() + "\t대여ID:" + bo.getBorrowId());
		}
	}

	public void saveFile() {

		try {
			// 폴더가 존재하는지 확인
			File f = new File(pathname);
			// 폴더가 존재하지 않으면 폴더를 만듬
			if (!f.getParentFile().exists()) {
				f.getParentFile().mkdirs();
			}

			// 파일에 저장하기
			FileOutputStream fos = new FileOutputStream(f);
			// 객체로 저장하기 위해
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			// ArrayList 객체를 저장할 경우
			// oos.writeObject(list);

			// ArrayList에 저장된 ProductVO 객체를 파일에 저장
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
			if (!f.exists()) // 파일이 존재하지 않으면
				return;

			fis = new FileInputStream(f);
			// 객체로 읽어 들이기 위해
			ois = new ObjectInputStream(fis);

			// ArrayList 객체가 저장된 경우
			// ArrayList list1=(ProductVO)ois.readObject();

			// 파일의 내용을 객체(ProductVO)로 읽어서 ArrayList에 저장
			while (true) {
				BOOKVO vo = (BOOKVO) ois.readObject();
				BookVector.add(vo);
			}

		} catch (EOFException e) {
			// ObjectInputStream은 파일의 내용을 다 읽어 들이면
			// EOFException 이 발생하므로 다른 처리를 하지
			// 않아도 된다.

		} catch (Exception e) {
			System.out.println(e.toString());

		} finally { // 예외가 발생하거나 하지 않은 경우
			if (ois != null) {
				try {
					ois.close();
				} catch (Exception e2) {
				}
			}
		}
	}

}