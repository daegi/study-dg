package com.test0415;

import java.util.Iterator;
import java.util.Vector;

public class Test8 {

	public static void main(String[] args) {
		// JDK 1.4 ���
		Vector v = new Vector();  //Object���� ����

		v.add("����");
		v.add("�λ�");
		v.add(new Integer(10));

		// ���Ϳ� ����� ������ ��������
		Iterator it = v.iterator();
		while (it.hasNext()) {
			// �̷��� ¥�� ��Ÿ�� ������ �߻���
			//String s= (String)it.next();
			//System.out.println(s);
			
			Object o= it.next();
			if(o instanceof String){
				String s=(String)o;
				System.out.println(s);
			}else if(o instanceof Integer){
				Integer ii=(Integer)o;
				System.out.println(ii);
			}
		}

	}

}
