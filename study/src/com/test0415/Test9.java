package com.test0415;

import java.util.Iterator;
import java.util.Vector;

public class Test9 {

	public static void main(String[] args) {
		// Vector<> v = new Vector<>(); ----> JDK 1.7
		// �迭�� ����, ���簡 ����
		Vector<String> v = new Vector<String>();
		System.out.println("������ �ʱ� ũ��:" + v.capacity());

		// ���Ϳ� ������ �߰�
		v.add("����");	//���Ϳ� ������ �����ϰ��� �ƴ϶� ������ �ּҸ� ����
		v.add("�λ�");
		v.add("�뱸");
		v.add("����");
		v.add("��õ");

		System.out.println("����� ����:" + v.size());

		// ù��° ��� ��������
		System.out.println("ó��: " + v.get(0));
		System.out.println("ó��: " + v.firstElement());

		// ������ ��� ��������
		System.out.println("������: " + v.get(v.size() - 1));
		System.out.println("������: " + v.lastElement());
		
		// ó����� ����
		v.set(0,"seoul");
		
		//1�ε����� �߰� 
		v.add(1, "����");
		
		// ���� v.remove("����")
		v.remove(1);

		String s;
		// ó������ ������ ��� ������ ��������
		System.out.println("��� ������ ��� 1....");
		for (int i = 0; i < v.size(); i++) {
			s = v.get(i);
			System.out.println(s);
		}
		System.out.println();

		System.out.println("��� ������ ��� 2....");
		for (String ss : v)
			System.out.println(ss);
		System.out.println();

		System.out.println("��� ������ ��� 3....");
		Iterator<String> it = v.iterator(); // �ݺ���
		while (it.hasNext()) { // �����Ͱ� �����ϸ�
			s = it.next();
			System.out.println(s);
		}
		System.out.println();
		
		
		//�������
		v.clear();
		System.out.println(v.size());

	}

}
