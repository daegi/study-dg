package com.test0404;

public class Test4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s1="����";
		String s2="����";
		
		String s3=new String("����");
		
		
		//String ���� == ���� ������ �ʰ� �ּҸ� ��
		System.out.println(s1==s2); //true(�����ּ�)
		System.out.println(s1==s3); //false
		
		//���ڿ��� ���Ҷ� ���� equals ���
		//String �� equals()�� ���� ��
		System.out.println(s1.equals(s3));
		
		//���ڿ�+�⺻�ڷ���=>���ڿ�
		//���ڿ�+���ڿ�=>���ڿ�����
		//string�� �Һ��� ��Ģ
		
		s1+="�λ�";
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s1==s2);
		
		//���ڿ� ó�� �ι�° Ŭ����
		//�������� ���ڿ��� ó���Ҷ� StringBuffer�� String
		//���� �ٸ��� ���ڿ��� �߰� �ϹǷ�
		//�ӵ��� �� ������.
		StringBuffer sb1=new StringBuffer();
		StringBuffer sb2=new StringBuffer();
		
		sb1.append("����");
		sb2.append("����");
		
		System.out.println(sb1);
		System.out.println(sb2);
		System.out.println(sb1==sb2);  //false
		//StringBuffer�� equals�� Object�� equals�̸� �ּҸ� ����
		System.out.println(sb1.equals(sb2));  //false
		System.out.println(sb1.toString().equals(sb2.toString()));
		
		
		
		
		
		

	}

}
