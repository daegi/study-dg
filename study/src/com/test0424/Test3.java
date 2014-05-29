package com.test0424;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Test3 {
	public static void main(String[] args) {
		ObjectInputStream ois = null;

		try {
			// ObjectoutputStream 은 데이터를 저장할대 먼저 헤더를 저장하며 추가로
			// FileOutputStream 객체를 생성하면 실행할때마다 헤더가 저장되므로 불러올 경우
			// 런타임 오류가 발생
			// FileOutputStream fos = new FileOutputStream("ex.txt", true);<--두번째 부터 런타임 오류
	
			FileOutputStream fos = new FileOutputStream("ex.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(new MyRec3("홍길동", "111-1111", 10));
			oos.writeObject(new MyRec3("자바", "222-2222", 15));
			oos.writeObject(new MyRec3("스프링", "333-3333", 20));
			oos.writeObject(new MyRec3("마이바티스", "444-4444", 25));
			oos.close();

			FileInputStream fis = new FileInputStream("ex.txt");
			ois = new ObjectInputStream(fis);

			// ObjectInputStream은 파일의 끝에 도달하면 EOFException 발생
			while (true) {
				MyRec3 ob = (MyRec3) ois.readObject();
				System.out.println(ob.getName() + ":" + ob.getTel() + ":"
						+ ob.getAge());
			}

		} catch (EOFException e) {
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			if (ois != null) {
				try {
					ois.close();
				} catch (Exception e2) {
				}
			}
		}

	}
}

// - Serializable 인터페이스 : 객체 직렬화
// 객체의 내용을 파일에 저장하거나 네트워크 전송이 가능하도록
// byte형으로 변환하는 작업을 한다.
// - 직렬화된 객체는 사용하기전 역직렬화과정을 거친다.
// - 직렬화 대상에서 제외
// 메소드, 클래스변수, transient 키워드를 붙인 필드
// 즉, 직렬화는 transient 키워드가 없는 인스턴스변수만 된다.
class MyRec3 implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;
	private transient String tel;
	private int age;

	public MyRec3() {
	}

	public MyRec3(String name, String tel, int age) {
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
}
