package com.test0416;

import java.util.Collections;
import java.util.Vector;

public class Test4 {
	public static void main(String[] args) {
		Vector<String> vv=new Vector<String>();
		
		vv.add("����");
		vv.add("�λ�");
		vv.add("�뱸");
		vv.add("����");
		vv.add("��õ");
		
		System.out.println("���ͳ���...");
		for(String s:vv)
			System.out.print(s+"   ");
		System.out.println();
		
		// �����˻�
		if(vv.contains("�λ�")) { // �����ϸ�
			int i=vv.indexOf("�λ�"); // �����ϴ°��� ��ġ
			System.out.println(i+"�ε����� ����");
		}
		
		// ����
		Collections.sort(vv);
		System.out.println("������������...");
		for(String s:vv)
			System.out.print(s+"   ");
		System.out.println();
		
		// �̺а˻�(�˻��� �ڷ�� ���ĵǾ��־����)
		int idx=Collections.binarySearch(vv, "�뱸");
		// ������ idx=-1
		if(idx!=-1)
			System.out.println("�˻����:"+vv.get(idx));
		
		Collections.sort(vv, Collections.reverseOrder());
		System.out.println("������������...");
		for(String s:vv)
			System.out.print(s+"   ");
		System.out.println();
		
	
		
		
		
		
	}
}
