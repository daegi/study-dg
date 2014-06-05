package com.test0401;

public class Test4 {

	public static void main(String[] args) {
		Ex4 oo1 = new Ex4();
		Ex4 oo2 = new Ex4();
		
		//System.out.println(oo1.a);// 에러 private는 외부 클래스에서 접근 불가
		
		oo1.b=5;
		System.out.println(oo1.b+":"+oo1.c+":"+oo1.d);
		oo1.write();
		
		oo2.b=5;
		//필드를 초기화 하지 않으면 int인 경우 0
		System.out.println(oo2.b+":"+oo2.c+":"+oo2.d);
		oo2.write();
		

		Ex4 o=oo1;
		o.b=400;
		System.out.println(oo1.b+":"+oo1.c+":"+oo1.d);
		oo2.write();

	}

}

class Ex4{
	
	//필드(인스터스 변수)
	private int a; 	//다른 클래스에서 접근 불가(캡슐화)
	int b;	  			//동일 패키지(폴더)에서 만 접근가능
	protected int c;  //동일 패키지 및 서브클래스만 접근가능
	public int d= 10; 	//어디서나 접근가능
	public void write(){
		System.out.println(a+":"+b+":"+c+":"+d);
	}
}
