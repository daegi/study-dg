package com.test0417;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class Test1 {

	public static void main(String[] args) {
		// Set: �ߺ��� ������� ����, ������ ����.
		HashSet<String> hs = new HashSet<String>();

		hs.add("����");
		hs.add("�λ�");
		hs.add("�뱸");
		hs.add("��õ");
		hs.add("����");
		hs.add("����");
		hs.add("���");
		hs.add("����");
		hs.add("����");
		System.out.println(hs);

		Iterator<String> it = hs.iterator();
		while (it.hasNext()) {
			String s = it.next();
			System.out.println(s);
		}
		System.out.println();

		// �ߺ�������� ����. �����ؼ� ����
		TreeSet<String> ts = new TreeSet<String>();

		ts.add("����");
		ts.add("�λ�");
		ts.add("�뱸");
		ts.add("��õ");
		ts.add("����");
		ts.add("����");
		ts.add("���");
		ts.add("����");
		System.out.println(ts);

	}

}
