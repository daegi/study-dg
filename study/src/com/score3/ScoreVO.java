package com.score3;

//1.�Է� 2.���� 3.���� 4.�˻� 5.�̸��� 6.������ 7.����=>

public class ScoreVO {
	private String hak, name;
	private int kor, eng, mat;
	private int tot;

	public String getHak() {
		return hak;
	}

	public void setHak(String hak) {
		this.hak = hak;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

	public int getTot() {
		tot = kor + eng + mat;
		return tot;
	}
	
	//����� ���ϰ� �ϱ� ���� toString()������
	@Override
	public String toString() {
		String s;
		s = String.format("%8s%10s%t%5d%5d%5d%6.1f", hak, name, kor, eng, mat,
				getTot(), (float) getTot() / 3);

		return s;
	}

}