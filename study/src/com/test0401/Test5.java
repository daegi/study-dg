package com.test0401;

public class Test5 {

	public static void main(String[] args) {
		
		Circle ob= new Circle();
		
		double s;
		s=ob.area();
		System.out.println(s);
		
		//ob.r=10; //private �̹Ƿ� ����
		
		ob.set(10);
		s=ob.area();
		ob.write("���� :", s);
		
		
		
		
		

	}

}

class Circle{
	private int r; //�ʵ�� �ʱ�ȭ ���� ������ 0
	
	public void set(int a){
		r=a;
	}
	
	//�޼ҵ��: ���� �Ҽ� �ִ� ���� ���� ����
	// ������ ����Ÿ�� �޼ҵ��([�μ���])
		//void�� �ƴ� ��� return ��;
		//void�� ��� return; -> void�� ��츸 return ���� ����
	public double area(){
		double result = r*r*3.14;
		return result;
	}
	
	public void write(String title, double a){
		System.out.println(title+":"+a);
	}

}
