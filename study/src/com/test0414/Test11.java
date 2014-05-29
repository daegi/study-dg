package com.test0414;


public class Test11 {

	public static void main(String[] args) {

		Ex11 ob = new Ex11();
		
		try{
			ob.fun(-10);
			System.out.println(ob.get());
			
		}catch(Exception e){
			System.out.println(e.toString());
		}
		System.out.println("끝,,,");

	}

}

class Ex11 {
	private int a = 10;
	
	
	// 예외를 던질경우(throw)경우 메소드에서 반드시
	// 해당 예외를 throws 해야한다.
	// 이런경우 checked exception 을 만든 경우이다.
	public void fun(int a) throws Exception {
		if (a < 0) // 예외를 던짐(강제로 예외를 발생시킴)
			throw new Exception("수가 0보다 적을수 없다.");

		this.a += a;
	}

	public int get() {
		return a;

	}

}
