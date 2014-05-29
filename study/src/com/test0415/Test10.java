package com.test0415;

import java.util.Scanner;
import java.util.Vector;

public class Test10 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Vector<MyRecord> vv = new Vector<MyRecord>();

		String s;
		// 잘못작성한예
/*		
		MyRecord vo=new MyRecord();
		while(true) {
			System.out.print("이름(종료:exit)?");
			s=sc.next();
			if(s.equals("exit"))
				break;
			vo.setName(s);
			System.out.print("나이?");
			vo.setAge(sc.nextInt());
			System.out.print("전화?");
			vo.setTel(sc.next());
			
			// 벡터에 저장
			vv.add(vo);
		}
*/		
		
		MyRecord vo;
		while(true) {
			System.out.print("이름(종료:exit)?");
			s=sc.next();
			if(s.equals("exit"))
				break;
			
			vo=new MyRecord(); // 반드시 이곳(while 안)에서 객체생성
			
			vo.setName(s);
			System.out.print("나이?");
			vo.setAge(sc.nextInt());
			System.out.print("전화?");
			vo.setTel(sc.next());
			
			// 벡터에 저장
			vv.add(vo);
		}		
		
		for(MyRecord v:vv) {
			//System.out.println(v.getName()+":"+v.getAge()
					//+":"+v.getTel());
			
			System.out.println(v);
		}
	}
}

class MyRecord {
	private String name, tel;
	private int age;

	public MyRecord() {

	}

	public MyRecord(String name, String tel, int age) {
		this.name = name;
		this.tel = tel;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return name+":"+age+":"+tel;
	}
}
