package com.test0402;

public class Test1 {

	public static void main(String[] args) {
		// ��ü����(�޸� �Ҵ�)
		// Ŭ���� ��ü�� = new Ŭ����();
		
		Ex1 ob=new Ex1();
		Ex1 ob1=new Ex1();
		
		//Ŭ�����̸�@ �ؽ��ڵ尪
		System.out.println(ob);
		System.out.println(ob1);
		// �ؽ��ڵ�: jvm�� ���������ΰ˻��� ���� ���
		// ��ü�� �ٸ��� �ؽ��ڵ�� �ٸ�����
		// �ؽ��ڵ尡 �ٸ��ٰ� �ٸ� ��ü�� �ƴ�
		
		//private �ܺο��� ���ٺҰ�
		//ob.money =10; �� ���� ����
		
		ob.name ="ȫ�浿";
		//Ex1.name="�׽�Ʈ" -->����
		//�ν��Ͻ������� �ν��Ͻ� �޼ҵ�� ��ü�� �����ؾ� ���ٰ�����
		
		ob.saving(100);
		
		System.out.println(ob.getMoney());
		System.out.println(ob1.getMoney());
		
		

	}
}

class Ex1 {
	// �ʵ�(�ν��ϼ� ����) :���� ����
	// �ʵ带 �ʱ�ȭ ���� ������ �������� 0, ��ü�� null�� �ʱ�ȭ �ȴ�.
	private int money; // �ܺ����ٺҰ�
	String name; // ���� ��Ű���� ���� ����

	//����:����η� ���๮�� �ü��� ����.
	//System.out.println("�ȵǿ�....");
	
	
	public int getMoney(){
		return money;
	}
	
	
	
	// �ν��Ͻ��޼ҵ�(�޸� �Ҵ���..) : �ൿ
	public void saving(int m) {
		money += m;
		return; //void �ΰ�� return ���� ����
				//return �� ������ ������ ���߰� ȣ���Ѱ�����
				//����
	}

	public int draw(int m) {
		if (m > money)
			return 0;
			money -= m;
		return m; 	//int �޼ҵ��̹Ƿ� return ���� �Ұ���
		// m=0; //����. return �Ʒ��κ��� ����Ұ��� �ϹǷ�
	}
}


/*�߻�ȭ
������: �ο���, ����ó����(5)
��� �Է�(����,���), �˻�, ���


*/