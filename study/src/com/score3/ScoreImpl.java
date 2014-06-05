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
			System.out.print("학번?");
			vo.setHak(sc.next());
			System.out.print("이름?");
			vo.setName(sc.next());
			System.out.print("국어?");
			vo.setKor(sc.nextInt());
			System.out.print("영어?");
			vo.setEng(sc.nextInt());
			System.out.print("수학?");
			vo.setMat(sc.nextInt());

			list.add(vo);
			System.out.println("추가완료...\n");
		} catch (Exception e) {
			System.out.println("입력 오류...");
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

		System.out.println("\n이름순.....");
		for (ScoreVO vo : list)
			System.out.println(vo);
		System.out.println();
	}

	@Override
	public void totOrder() {
		System.out.println("\n총점순.....");
		for (ScoreVO vo : list)
			System.out.println(vo);
		System.out.println();
	}

	@Override
	public void saveFile() {
		try {
			// 폴더가 존재하는지 확인
			File f = new File(pathname);
			// 폴더가 존재하지 않으면 폴더를 만듬
			// pathname에는 파일염이 있으므로 폴더만 나타내기 위해
			// getParentFile() 메소드로 파일위의 폴더를 구함
			if (!f.getParentFile().exists()) {
				f.getParentFile().mkdirs();
			}

			// 파일에 저장하기
			FileOutputStream fos = new FileOutputStream(f);
			// 자료형별 저장하기 위해
			DataOutputStream dos = new DataOutputStream(fos);

			// ArrayList에 저장된 자료를 파일에 저장
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
			if (!f.exists()) // 파일이 존재하지 않으면
				return;

			fis = new FileInputStream(f);
			dis = new DataInputStream(fis);

			// 파일의 내용을 읽어서 ArrayList에 저장
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
			// DataInputStream은 파일의 내용을 다 읽어 들이면
			// EOFException 이 발생하므로 다른 처리를 하지
			// 않아도 된다.
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
 * ss[count].name=sc.next(); // 3과목 점수 입력 받고 총점 구하기 for(int i=0;
 * i<ss[count].score.length; i++) { System.out.print(title[i]);
 * ss[count].score[i]=sc.nextInt(); ss[count].tot+=ss[count].score[i]; // 총점구하기
 * } ss[count].ave=ss[count].tot/3; count++; // 인원수 증가하기
 * 
 * System.out.println(); }
 */