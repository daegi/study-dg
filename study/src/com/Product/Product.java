package com.Product;
/*
- PreductVO : ����ȭ �ʿ�
��ǰ�ڵ�, ��ǰ��, ����, �ܰ�

-Product : �������̽�
input(), updata(), search(), remove(), list(), saveFile()

-ProductImpl : Product ���� Ŭ����
ArrayList<ProductVO> list=new...... 

input(), update(), search(), remove(), list(), saveFile(), loadFile()

-ProductMain :
1.�߰� 2. ��� 3.�˻� 4.���� 5.����Ʈ 6.����

-��, ���� ó���� ��ü�� �����ϰ� �ҷ����� ObjectInputStream, ObjectOutputStream �̿�  
*/

public interface Product {
	public void input(); 
	public void updata();
	public void search();
	public void remove();
	public void list();
	public void saveFile();

}
