package com.test0401;

public class Test2 {

	public static void main(String[] args) {
		
		// 객체생성하기
		Rect ob = new Rect(); //Rect() "생성자" = 초기화, 메모리할당

		// 필드에 값을 할당
		ob.width = 10;
		ob.height = 50;

		// 넓이와 둘레 구하기
		System.out.println("넓이: " + ob.area());
		System.out.println("높이: " + ob.len());

	}

}

// 클래스 만들기

class Rect {
	// 필드(가로세로)
	int width, height;

	// 넓이 구하기
	public int area() {
		return width * height;
	}

	// 둘레 구하기
	public int len() {
		return (width + height) * 2;
	}
}