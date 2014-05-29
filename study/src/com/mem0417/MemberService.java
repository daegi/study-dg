package com.mem0417;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

//Map인터페이스->구현클래스 : Hashtable, HashMap
public class MemberService {
	private Scanner sc = new Scanner(System.in);
	private HashMap<String, MemberVO> map = new HashMap<String, MemberVO>();

	// 가입
	public void join() {
		String id;
		System.out.print("아이디?");
		id = sc.next();
		if (map.containsKey(id)) { // 동일한 키가 있으면
			System.out.println("동일한 아이디가 존재합니다.\n");
			return;
		}

		MemberVO vo = new MemberVO();
		System.out.print("패스워드?");
		vo.setPwd(sc.next());
		System.out.print("이름?");
		vo.setName(sc.next());
		System.out.print("전화?");
		vo.setTel(sc.next());
		System.out.print("나이?");
		vo.setAge(sc.nextInt());

		map.put(id, vo); // Map에 저장

		System.out.println("입력 완료...\n");
	}

	// 수정
	public void update() {
		String id, pwd;
		System.out.print("아이디?");
		id = sc.next();
		System.out.print("패스워드?");
		pwd = sc.next();
		if (!map.containsKey(id)) { // 존재하지 않으면
			System.out.println("아이디 또는 패스워드가 틀려...\n");
			return;
		}

		// 해당 아이디의 데이터 가져오기
		MemberVO vo = map.get(id);

		if (!vo.getPwd().equals(pwd)) {
			System.out.println("아이디 또는 패스워드가 틀려...\n");
			return;
		}

		// vo에 수정할 데이터만 다시 입력해서 저장하면 수정됨
		System.out.print("수정할패스워드?");
		vo.setPwd(sc.next());
		System.out.print("수정할전화?");
		vo.setTel(sc.next());
		System.out.print("수정할나이?");
		vo.setAge(sc.nextInt());
	}

	// 탈퇴
	public void remove() {
		System.out.println("회원  탈퇴...");

		String id, pwd;
		System.out.print("아이디?");
		id = sc.next();
		System.out.print("패스워드?");
		pwd = sc.next();

		MemberVO vo = map.get(id);
		if (vo == null) { // 아이디검사
			System.out.println("아이디 또는 패스워드 틀려...");
			return;
		}

		if (!vo.getPwd().equals(pwd)) {
			System.out.println("아이디 또는 패스워드 틀려...");
			return;
		}

		map.remove(id);
		System.out.println("탈퇴했다...\n");
	}

	// 검색
	public void search() {
		System.out.println("회원 검색...");

		String name;
		System.out.print("검색할이름?");
		name = sc.next();

		Iterator<String> it = map.keySet().iterator();
		while (it.hasNext()) {
			String id = it.next();
			MemberVO vo = map.get(id);
			if (vo.getName().equals(name)) {
				System.out.println(id + ":" + vo.getName() + ":" + vo.getPwd()
						+ ":" + vo.getTel() + ":" + vo.getAge());
			}
		}
		System.out.println();
	}

	// 리스트
	public void list() {
		System.out.println("회원 전체리스트...");

		Iterator<String> it = map.keySet().iterator();
		while (it.hasNext()) {
			String id = it.next();
			MemberVO vo = map.get(id);
			System.out.println(id + ":" + vo.getName() + ":" + vo.getPwd()
					+ ":" + vo.getTel() + ":" + vo.getAge());
		}
		System.out.println();
	}
}
