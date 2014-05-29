package com.test0409;

public class Test2 {
	public static void main(String[] args) {
		Ex2 ob1=new Ex2();
		Ex2 ob2=new Ex2();
		
		ob1.name="ȫ�浿";
		ob1.age=10;
		
		ob2.name="ȫ�浿";
		ob2.age=10;
		
		System.out.println(ob1);
		//
		System.out.println(ob1.toString());
		System.out.println(ob1==ob2);  // �ּҺ�:false
		// 
		System.out.println(ob1.equals(ob2)); // 
	}
}

class Ex2 {
	String name;
	int age;
	public void print() {
		System.out.println(name+":"+age);
	}
	
	//Object Ŭ������ equals()�޼ҵ带 ������ 
	//Object Ŭ������ equals()�� �ּҸ� ����
	@Override
	public boolean equals(Object o) {
		// �̸��� ������ true �����ϵ��� ������
		Ex2 s=(Ex2)o; //Objet ��ü�� Ex2��ü�� �ٿ� ĳ����
		if(name == null || s.name==null)
			return false;
		
		return name.equals(s.name);
	}
	//Object�� toString() �޼ҵ带 ������
	//Object�� toString()�� Ŭ������@�ؽ��ڵ�� ������
	@Override
	public String toString() {
		//�̸��� ���̸� ����ϵ��� ������ ��
		String s;
		if(name==null)
			return null;
		
		s=name+"���� ����"+age+"���Դϴ�.";
		
		return s;
	}
	
}
