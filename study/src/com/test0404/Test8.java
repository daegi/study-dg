package com.test0404;
//stringbuffer
public class Test8 {

	public static void main(String[] args) {
		
		StringBuffer sb1=new StringBuffer();
		
		//�ʱ� ������ ũ��
		System.out.println(sb1.capacity()); //16
		
		sb1.append("����");
		sb1.append("�λ�");
		sb1.append("���ѹα�");
		sb1.append("�ѱ�");
		sb1.append("�뱸");
		sb1.append("����");
		sb1.append("���");
		
		
		System.out.println(sb1);
		
		System.out.println(sb1.capacity());
		
		sb1.insert(0, "korea");
		System.out.println(sb1);
		
		//���� ������ ������ �߰�
		
		System.out.println(sb1.indexOf("����"));
		sb1.insert(sb1.indexOf("����")+"����".length(), "������");
		System.out.println(sb1);
		
		//���� ������ ����
		sb1.delete(sb1.indexOf("���ֱ�����"),
				sb1.indexOf("���ֱ�����")+"���ֱ�����".length());
		System.out.println(sb1);
		
		
		StringBuffer s1 =new StringBuffer("korea");
		StringBuffer s2 =new StringBuffer("korea");
		
		System.out.println(s1==s2);
		System.out.println(s1.equals(s2));
		System.out.println(s1.toString().equals(s2.toString()));
		
		System.out.println(s1);
		System.out.println(s1.toString().toUpperCase());
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
