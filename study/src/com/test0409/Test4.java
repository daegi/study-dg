package com.test0409;

public class Test4 {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		Ex4 oo1= Ex4.getInstance();
		Ex4 oo2= Ex4.getInstance();
		
		System.out.println(oo1==oo2); //하나의 객체만 생성되므로 주소가 같음
		oo1.a=100;
		System.out.println(oo2.a);

	}

}
// singleton 패턴 하나의 객체만 생성 가능함
class Ex4{
	private static Ex4 ob;
	int a=10;
	
	private Ex4(){ //생성자가 private 이므로 외부에서는 객체 생성이 불가능함
	}
	
	public static Ex4 getInstance(){
		if(ob==null)
			ob=new Ex4();
		
		return ob;
	}
}