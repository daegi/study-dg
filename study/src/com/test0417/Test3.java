package com.test0417;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class Test3 {

	public static void main(String[] args) {
		// Map : <��, Ű>�� ���·� ����
		// ����Ŭ����: Hashtable, HashMap, TreeMap��
		// Iterator �� ����. �� ���� forans ��� �Ұ�
		// Ű�� �ߺ��� ������� �ʴ´�(Set)
		// ������ ����.
		Hashtable<Integer, String> ht = new Hashtable<Integer, String>();

		// Map �� ����
		ht.put(new Integer(100), "����");
		ht.put(new Integer(200), "�λ�");
		ht.put(new Integer(30), "�뱸");
		ht.put(new Integer(400), "��õ");
		ht.put(new Integer(50), "����");
		ht.put(new Integer(100), "seoul");
		System.out.println(ht);

		// Map ��������
		String s;
		s = ht.get(100);
		System.out.println(s);
		s = ht.get(500);
		System.out.println(s);

		// ó������ ������ ��� �ڷ� ����
		// Ű�� Set�̰� Ű�� �̿��Ѵ�.
		Set<Integer> set = ht.keySet();
		Iterator<Integer> it = set.iterator();
		while (it.hasNext()) {
			Integer key = it.next();
			String value = ht.get(key);
			System.out.println(key + ":" + value);
		}
		// Ű�� �����ϴ��� Ȯ��
		if (ht.containsKey(new Integer(100)))
			System.out.println("100Ű�� ����");

		// Ű ����
		ht.remove(new Integer(400));
		System.out.println(ht);

	}
}
