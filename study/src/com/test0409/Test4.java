package com.test0409;

public class Test4 {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		Ex4 oo1= Ex4.getInstance();
		Ex4 oo2= Ex4.getInstance();
		
		System.out.println(oo1==oo2); //�ϳ��� ��ü�� �����ǹǷ� �ּҰ� ����
		oo1.a=100;
		System.out.println(oo2.a);

	}

}
// singleton ���� �ϳ��� ��ü�� ���� ������
class Ex4{
	private static Ex4 ob;
	int a=10;
	
	private Ex4(){ //�����ڰ� private �̹Ƿ� �ܺο����� ��ü ������ �Ұ�����
	}
	
	public static Ex4 getInstance(){
		if(ob==null)
			ob=new Ex4();
		
		return ob;
	}
}