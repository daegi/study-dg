package ch6;

import java.util.Iterator;
import java.util.Vector;

public class Test9 {

	public static void main(String[] args) {
		Vector<String> v= new Vector<String>();
		System.out.println("������ �ʱ� ũ�� :"+v.capacity());
		
		v.add("����");
		v.add("�λ�");
		v.add("�뱸");
		v.add("����");
		v.add("��õ");
		
		System.out.println("����� ���� :"+v.size());
		
		System.out.println("÷:"+v.get(0));
		System.out.println("÷:"+v.firstElement());
		
		System.out.println("��:"+v.get(4));
		System.out.println("��"+v.lastElement());
		
		System.out.println("������:"+v.get(v.size()-1));
		System.out.println("������:"+v.lastElement());
		
		v.set(0, "seoul");
		v.add(1, "����");
		v.remove(1);
		
		String s;
		System.out.println("��� ������ ��� 1....");
		for (int i =0; i <v.size(); i++){
			s= v.get(i);
		System.out.println(s);
		}
		System.out.println();
		
		System.out.println("��� ������ ���2");
		for(String ss:v)
			System.out.println(ss);
		System.out.println();
		
		System.out.println("��� 3333333333333");
		
		Iterator<String> it = v.iterator();
		while(it.hasNext()){
			s=it.next();
			System.out.println(s);
		}
		System.out.println();
		
		v.clear();
		System.out.println(v.size());
		
		
		

	}

}
