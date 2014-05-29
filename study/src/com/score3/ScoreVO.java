package com.score3;

//1.입력 2.수정 3.삭제 4.검색 5.이름순 6.총점순 7.종료=>

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
	
	//출력을 편리하게 하기 위해 toString()재정의
	@Override
	public String toString() {
		String s;
		s = String.format("%8s%10s%t%5d%5d%5d%6.1f", hak, name, kor, eng, mat,
				getTot(), (float) getTot() / 3);

		return s;
	}

}