package ch6;

import java.util.Scanner;
import java.util.Vector;

public class Test10 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Vector<MyRecord> vv = new Vector<MyRecord>();

	}

}

class MyRecord{
	private String name, tel;
	private int age;
	
	public MyRecord(){
		
	}
	public MyRecord(String name, String tel, int age){
		this.name = name;
		this.tel = tel;
		this.age = age;
	}
	public String getName(){
		return name;
	}
	public String getTel(){
		return tel;
	}
	public void setTel(String tel){
		this.tel = tel;
	}
	public int getAge(){
		return age;
	}
	public void setAge(int age){
		this.age = age;
	}
	@Override
	public String toString() {
		return name+":"+age+":"+tel;
	}
	
}
