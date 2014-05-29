package com.score3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ScoreImpl implements Score {
	private String pathname = "c:" + File.separator + "data" + File.separator
			+ "sung.dat";
	private List<ScoreVO> list = new ArrayList<ScoreVO>();
	private Scanner sc = new Scanner(System.in);

	public ScoreImpl() {
		loadFile();
	}

	@Override
	public void input() {
		try {
			ScoreVO vo = new ScoreVO();
			System.out.print("�й�?");
			vo.setHak(sc.next());
			System.out.print("�̸�?");
			vo.setName(sc.next());
			System.out.print("����?");
			vo.setKor(sc.nextInt());
			System.out.print("����?");
			vo.setEng(sc.nextInt());
			System.out.print("����?");
			vo.setMat(sc.nextInt());

			list.add(vo);
			System.out.println("�߰��Ϸ�...\n");
		} catch (Exception e) {
			System.out.println("�Է� ����...");
		}
	}

	@Override
	public void update() {
		ScoreVO vo =null;
		
		
		
	}

	@Override
	public void remove() {
	}

	@Override
	public void search() {
	}

	@Override
	public void nameOrder() {

		Comparator<ScoreVO> comp = new Comparator<ScoreVO>() {
			@Override
			public int compare(ScoreVO s1, ScoreVO s2) {
				return s1.getName().compareTo(s2.getName());
			}
		};
		Collections.sort(list, comp);

		System.out.println("\n�̸���.....");
		for (ScoreVO vo : list)
			System.out.println(vo);
		System.out.println();
	}

	@Override
	public void totOrder() {
		System.out.println("\n������.....");
		for (ScoreVO vo : list)
			System.out.println(vo);
		System.out.println();
	}

	@Override
	public void saveFile() {
		try {
			// ������ �����ϴ��� Ȯ��
			File f = new File(pathname);
			// ������ �������� ������ ������ ����
			// pathname���� ���Ͽ��� �����Ƿ� ������ ��Ÿ���� ����
			// getParentFile() �޼ҵ�� �������� ������ ����
			if (!f.getParentFile().exists()) {
				f.getParentFile().mkdirs();
			}

			// ���Ͽ� �����ϱ�
			FileOutputStream fos = new FileOutputStream(f);
			// �ڷ����� �����ϱ� ����
			DataOutputStream dos = new DataOutputStream(fos);

			// ArrayList�� ����� �ڷḦ ���Ͽ� ����
			for (ScoreVO vo : list) {
				dos.writeUTF(vo.getHak());
				dos.writeUTF(vo.getName());
				dos.writeInt(vo.getKor());
				dos.writeInt(vo.getEng());
				dos.writeInt(vo.getMat());
			}
			dos.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	private void loadFile() {
		FileInputStream fis = null;
		DataInputStream dis = null;

		try {
			File f = new File(pathname);
			if (!f.exists()) // ������ �������� ������
				return;

			fis = new FileInputStream(f);
			dis = new DataInputStream(fis);

			// ������ ������ �о ArrayList�� ����
			while (true) {
				ScoreVO vo = new ScoreVO();
				vo.setHak(dis.readUTF());
				vo.setName(dis.readUTF());
				vo.setKor(dis.readInt());
				vo.setEng(dis.readInt());
				vo.setMat(dis.readInt());

				list.add(vo);
			}

		} catch (EOFException e) {
			// DataInputStream�� ������ ������ �� �о� ���̸�
			// EOFException �� �߻��ϹǷ� �ٸ� ó���� ����
			// �ʾƵ� �ȴ�.
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			if (dis != null) {
				try {
					dis.close();
				} catch (Exception e2) {
				}
			}
		}

	}

}

/*
 * 
 * ss[count].name=sc.next(); // 3���� ���� �Է� �ް� ���� ���ϱ� for(int i=0;
 * i<ss[count].score.length; i++) { System.out.print(title[i]);
 * ss[count].score[i]=sc.nextInt(); ss[count].tot+=ss[count].score[i]; // �������ϱ�
 * } ss[count].ave=ss[count].tot/3; count++; // �ο��� �����ϱ�
 * 
 * System.out.println(); }
 */