package com.score2;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JOptionPane;

// 서비스 클래스
public class Score {
	private Scanner sc = new Scanner(System.in);

	// 학생정보를 저장하기 위한 Vector 클래스 객체
	private Vector<ScoreVO> list = new Vector<>();

	
	// 데이터 입력
	public void input() {
		// 학번 이름 국어 영어 수학을 입력 받아 list에추가
		ScoreVO vo = new ScoreVO();

		System.out.print("학번");
		vo.setHak(sc.next());

		/*Iterator<ScoreVO> it = list.iterator();
		while (it.hasNext()) {
			ScoreVO v = it.next();
			if (v.getHak().equals(vo.getHak())) {
				System.out.println("등록된 학번입니다.");
				return;
			}
		}*/

		System.out.print("이름");
		vo.setName(sc.next());
		System.out.print("국어");
		vo.setKor(sc.nextInt());
		System.out.print("영어");
		vo.setEng(sc.nextInt());
		System.out.print("수학");
		vo.setMat(sc.nextInt());

		list.add(vo);

	}

	// 모든 데이터 출력
	public void print() {
		String s;
		System.out.println("\n성적처리 프로그램...");
		for (ScoreVO vo : list) {
			s = String.format("%s\t%s\t%5d%5d%5d%5d%6.1f", vo.getHak(),
					vo.getName(), vo.getKor(), vo.getEng(), vo.getMat(),
					vo.getTot(), (float) vo.getTot() / 3);
			System.out.println(s);
		}
		System.out.println();

	}

	// 데이터 검색
	public void search() {
		String name, s;
		// 검색할 이름입력
		name = JOptionPane.showInputDialog("검색할 이름을 입력 하세요");
		if (name == null || name.length() == 0)
			return;

		// 동일한 이름이 있는지 처음부터 검색한다.
		System.out.println("\n 검색 결과...");
		System.out.println("학번 이름");
		for (ScoreVO vo : list) {
			if (vo.getName().startsWith(name)) {
				s = String.format("%s\t%s\t%5d%5d%5d%5d%6.1f", vo.getHak(),
						vo.getName(), vo.getKor(), vo.getEng(), vo.getMat(),
						vo.getTot(), (float) vo.getTot() / 3);
				System.out.println(s);
			}
		}
		System.out.println();

	}

	// 데이터 삭제
	public void remove() {
		// 삭제할 학번을 입력받는다.
		// 처음부터 끝가지 검사해서 있으면 삭제 한다.

		String hak;
		// 검색할 이름입력
		Scanner sc = new Scanner(System.in);

		System.out.print("학번");
		hak = sc.next();

		for (ScoreVO vo : list) {
			if (vo.getHak().equals(hak)) {
				list.remove(vo);
				break;

			}
		}

	}

}
