package com.insa1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

//List 인터페이스->구현클래스 : Vector, ArrayList
public class InsaService {
	private Scanner sc = new Scanner(System.in);
	private ArrayList<InsaVO> list;

	public InsaService() {
		list = new ArrayList<InsaVO>();
	}

	// 입력
	// 사번,이름, 급여를 입력 받아 ArrayList에 추가
	// try~catch를 이용하여 급여 입력에 문제가 발생하면
	// 입력 오류 메시지를 출력한다.
	public void input() {
		try {
			InsaVO vo = new InsaVO();

			System.out.print("사번?");
			vo.setSabun(sc.next());
			System.out.print("이름?");
			vo.setName(sc.next());
			System.out.print("급여?");
			vo.setPay(sc.nextInt());

			list.add(vo);
			System.out.println("입력 완료...\n");
		} catch (Exception e) {
			System.out.println("입력 오류...");
			sc.nextLine();
		}
	}

	// 수정
	public void update() {
		InsaVO vo = null;
		String sabun;

		System.out.print("수정할 사번?");
		sabun = sc.next();

		for (InsaVO vv : list) {
			if (vv.getSabun().equals(sabun)) {
				vo = vv;
				break;
			}
		}

		if (vo == null) {
			System.out.println(sabun + " 자료는 등록된 자료가 아닙니다.");
			return;
		}

		System.out.println("이름:" + vo.getName() + ", 급여:" + vo.getPay());
		System.out.print("수정할급여?");
		vo.setPay(sc.nextInt());
		System.out.println("수정 완료...\n");
	}

	// 검색
	public void search() {
		String name;

		System.out.print("검색할 이름?");
		name = sc.next();
		for (InsaVO vv : list) {
			if (vv.getName().equals(name)) {
				System.out.println(vv.getSabun() + ":" + vv.getName() + ":"
						+ vv.getPay() + ":" + ":" + vv.getTax() + ":"
						+ vv.getSilpay());
			}
		}
		System.out.println();
	}

	// 삭제
	public void remove() {
		String sabun;

		System.out.print("삭제할 사번?");
		sabun = sc.next();
		for (InsaVO vv : list) {
			if (vv.getSabun().equals(sabun)) {
				list.remove(vv);
				break;
			}
		}
		System.out.println("삭제완료 !!!\n");
	}

	// 이름순

	public void printNameOrder() {
		Comparator<InsaVO> comp = new Comparator<InsaVO>() {

			@Override
			public int compare(InsaVO o1, InsaVO o2) {
				return o1.getName().compareTo(o2.getName());
			}
		};
		Collections.sort(list, comp);

		System.out.println("이름순 정렬....");
		for (InsaVO vv : list) {
			System.out.println(vv.getSabun() + ":" + vv.getName() + ":"
					+ vv.getPay() + ":" + ":" + vv.getTax() + ":"
					+ vv.getSilpay());
		}
		System.out.println();
	}

	// 급여순
	public void printPayOrder() {
		// 급여순 정
		// Collections.sort(list); <---에러
		// ArrayList에 저장된 InsaVO클래스는 어떤 컬럼을 가지고
		// 정렬할 것인지를 나타내는 Comparable 인터페이스가
		// 구현되어 있지 않기 대문에 오류가 발생한다.
		// 따라서 정렬을 하기 위해서는 InsaVO클래스에
		// Comparable 인터페이스를 구현하거나 어떤 컬럼으로
		// 어떻게 정렬할 것인지를 나타내는 Comparator 를
		// sort()메소드에 인자로 넘겨야 한다.

		// 정렬할 컬럼 및 방법 만들기
		Comparator<InsaVO> comp = new Comparator<InsaVO>() {

			@Override
			public int compare(InsaVO o1, InsaVO o2) {
				// return o1.getPay()-o2.getPay(); // 오름차순
				return -(o1.getPay() - o2.getPay());// 내림차순
			}
		};
		Collections.sort(list, comp);

		System.out.println("급여순 정렬....");
		for (InsaVO vv : list) {
			System.out.println(vv.getSabun() + ":" + vv.getName() + ":"
					+ vv.getPay() + ":" + ":" + vv.getTax() + ":"
					+ vv.getSilpay());
		}
		System.out.println();

	}
}
