package com.test0404;
// string
public class Test6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s1="seoul korea";
		
		System.out.println("���ڿ� ���� :"+s1.length());
		
		//7��° ���ڸ� ���� (�ε����� 0���� ����)
		System.out.println(s1.charAt(6));
		
		//7��° ���ڿ��� 3���� ����
		System.out.println(s1.substring(6,9));
		
		//6��° ��ġ���� ������ ����
		System.out.println(s1.substring(6));
		
		//kor ���ڿ��� ��ġ��?
		System.out.println(s1.indexOf("kor"));
		
		//o���ڿ��� ��ġ��
		System.out.println(s1.indexOf("o"));
		System.out.println(s1.lastIndexOf("1: o"));
		
		//ss���ڿ��� ��ġ��?(������ -1)
		System.out.println(s1.indexOf("ss"));
		//�պκи� ��
		System.out.println(s1.startsWith("seoul"));
		//�޺κи� ��
		System.out.println(s1.endsWith("korea"));
		
		System.out.println(s1.equals("seoul korea"));
		System.out.println(s1.equals("Seoul Korea"));
		
		//��ҹ��ڸ� ������ ����
		System.out.println(s1.equalsIgnoreCase("Seoul Korea"));
		
		//���ڿ��� ���������� ��('k'-'c'=8)
		System.out.println(s1.compareTo("seoul corea"));
		//System.out.println(s1 < ("seoul corea")); ���� ���ڿ��� �ε�ȣ�� �� �Ұ�.
		
		
		String s2= s1.toUpperCase();
		System.out.println(s2);
		
		s1="���� ���ѹα� ���ѵ��� �츮 ����";
		s2=s1.replaceAll("����","����");
		System.out.println(s2);
		
		s1="   �� �� �� ��    ";
		System.out.println(":"+s1+":");
		s2=s1.trim(); // �հ� ���� ���� ����
		System.out.println(":"+s2+":");
		
		s2=s1.replace(" ", ""); // \\s ����
		s2=s1.replaceAll("\\s", "");
		System.out.println(":"+s2+":");
		
		s1="aa,bb,cc";
		String[] ss=s1.split(","); //���ڿ��� �и�
		System.out.println(ss.length);
		
		for(String s:ss)
			System.out.println(s);
		
		int n=10;
		// s1=n; ����
		s1= ""+n;// ���ڿ� + �⺻�ڷ��� =>���ڿ�
				 // �����
		
		System.out.println(s1);
		
		
		//������ ���ڿ�(Integer:������ ó���ϴ� Ŭ����)
		s1=Integer.toString(n);
		System.out.println(s1);
		
		n=1234567;
		// String.format()�� System.out.prinf()�� ������ ����
		s1=String.format("%,d", n); 
		System.out.println(s1);
		
		s1=String.format("%.1f %.2f %f", 12.5869,12.5869,12.5869);
		System.out.println(s1);
		
		
		System.out.printf("%.1f %.2f %f\n", 12.5869,12.5869,12.5869);
				
		}
}
