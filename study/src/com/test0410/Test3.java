package com.test0410;

public class Test3 {

	public static void main(String[] args) {
	}

}

interface Ainter{
	public void print();
}

interface Binter{
	public void write();
}

//인터페이스는 다중 상속을 지원 한다.
interface Cinter extends Ainter, Binter{
	public void fun();
}

class Ex3 implements Cinter{

	@Override
	public void print() {
		System.out.println("print");
		
	}

	@Override
	public void write() {
		System.out.println("write");
		
	}

	@Override
	public void fun() {
		System.out.println("fun");
	}
}

class Demo3 implements Ainter, Binter{

	@Override
	public void write() {
		System.out.println("demo write");
		
	}

	@Override
	public void print() {
		System.out.println("demo print");
		
	}
	
}
