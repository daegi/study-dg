package com.test0404;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex1 ob= new Ex1();
		
		int s;
		s=ob.sum(1,2,3,4,5,6,7,8,9,10);
		System.out.println(s);
		
		s=ob.sum(1,3,5,7,9);
		System.out.println(s);

	}

}


//�����μ�: �μ��� ������ ���� ���� ������� ���(...n)

/*
 *  void sub(int...n){} 
 *  void sub(String s, int ...n){}
 *  void sub(String s, int ...n, float){} �Ұ�
 *  void sub(int ...n, String s){} �Ұ�
 * 
*/
class Ex1{
	public int sum(int ...n){
		int s=0;
		
		for(int a : n) //
			s+=a;
		return s;
	}
}