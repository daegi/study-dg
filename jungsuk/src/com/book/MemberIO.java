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
	static Vector<BVO> PeopleVector = new Vector<BVO>();// 회원관리
	private String pathname = "d:" + File.separator + "data" + File.separator
			+ "member.txt";

	public MemberIO() {
		loadFile();
	}

	public void join() { // 1. 회원가입
		BVO vo = new BVO();
		System.out.print("아이디");
		vo.setId(sc.next());
		Iterator<BVO> it = PeopleVector.iterator();
		while (it.hasNext()) {
			BVO vv = it.next(); // v 백터 안에 있는 변수
			if (vv.getId().equals(vo.getId())) {
				System.out.println("등록된 아이디 입니다.");
				return;
			}
		}
		System.out.print("비밀번호");
		vo.setPassword(sc.next());
		System.out.print("이름");
		vo.setName(sc.next());
		System.out.print("나이");
		vo.setAge(sc.nextInt());
		System.out.print("전화번호");
		vo.setTel(sc.next());

		PeopleVector.add(vo);
	}

	public void memberlist() { // 2. 모든 회원 출력
		System.out.println("\n[회원 리스트]");// 회원 리스트 출력

		for (BVO bo : PeopleVector) {
			System.out.println("아이디:" + bo.getId() + "\t비밀번호:"
					+ bo.getPassword() + "\t이름:" + bo.getName() + "\t나이:"
					+ bo.getAge() + "\t전화번호" + bo.getTel());

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
			if (!f.exists()) // 파일이 존재하지 않으면
				return;

			fis = new FileInputStream(f);
			// 객체로 읽어 들이기 위해
			ois = new ObjectInputStream(fis);

			// ArrayList 객체가 저장된 경우
			// ArrayList list1=(ProductVO)ois.readObject();

			// 파일의 내용을 객체(ProductVO)로 읽어서 ArrayList에 저장
			while (true) {
				BVO vo = (BVO) ois.readObject();
				PeopleVector.add(vo);
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