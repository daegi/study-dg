package com.test0415;

public class Test6 {
	public static void main(String[] args) {
		Ex6 e= new Ex6();
		
		try{
			e.setValue(-5);
			int n=e.getValue();
			System.out.println(n);
		}catch(MyException e2){
			e2.printStackTrace();
		}

	}
}

class MyException extends Exception{
	public MyException(String msg){
		super(msg);
	}
}

class Ex6 {
	private int value;

	public void setValue(int value) throws MyException{
		if(value<0)
			throw new MyException("값은 0보다 적을수 없다.");
		this.value=value;
	}
	public int getValue(){
		return value;
	}

}
