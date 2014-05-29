package com.score2;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JOptionPane;

// ���� Ŭ����
public class Score {
	private Scanner sc = new Scanner(System.in);

	// �л������� �����ϱ� ���� Vector Ŭ���� ��ü
	private Vector<ScoreVO> list = new Vector<>();

	
	// ������ �Է�
	public void input() {
		// �й� �̸� ���� ���� ������ �Է� �޾� list���߰�
		ScoreVO vo = new ScoreVO();

		System.out.print("�й�");
		vo.setHak(sc.next());

		/*Iterator<ScoreVO> it = list.iterator();
		while (it.hasNext()) {
			ScoreVO v = it.next();
			if (v.getHak().equals(vo.getHak())) {
				System.out.println("��ϵ� �й��Դϴ�.");
				return;
			}
		}*/

		System.out.print("�̸�");
		vo.setName(sc.next());
		System.out.print("����");
		vo.setKor(sc.nextInt());
		System.out.print("����");
		vo.setEng(sc.nextInt());
		System.out.print("����");
		vo.setMat(sc.nextInt());

		list.add(vo);

	}

	// ��� ������ ���
	public void print() {
		String s;
		System.out.println("\n����ó�� ���α׷�...");
		for (ScoreVO vo : list) {
			s = String.format("%s\t%s\t%5d%5d%5d%5d%6.1f", vo.getHak(),
					vo.getName(), vo.getKor(), vo.getEng(), vo.getMat(),
					vo.getTot(), (float) vo.getTot() / 3);
			System.out.println(s);
		}
		System.out.println();

	}

	// ������ �˻�
	public void search() {
		String name, s;
		// �˻��� �̸��Է�
		name = JOptionPane.showInputDialog("�˻��� �̸��� �Է� �ϼ���");
		if (name == null || name.length() == 0)
			return;

		// ������ �̸��� �ִ��� ó������ �˻��Ѵ�.
		System.out.println("\n �˻� ���...");
		System.out.println("�й� �̸�");
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

	// ������ ����
	public void remove() {
		// ������ �й��� �Է¹޴´�.
		// ó������ ������ �˻��ؼ� ������ ���� �Ѵ�.

		String hak;
		// �˻��� �̸��Է�
		Scanner sc = new Scanner(System.in);

		System.out.print("�й�");
		hak = sc.next();

		for (ScoreVO vo : list) {
			if (vo.getHak().equals(hak)) {
				list.remove(vo);
				break;

			}
		}

	}

}
