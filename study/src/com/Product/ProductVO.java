package com.Product;

import java.io.Serializable;

/*
 - ProductVO : ����ȭ �ʿ�
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

//��ü ����ȭ(Serializable �� �����ϸ� ��)
// ��ü�� ���Ͽ� �����ϰų� ��Ʈ��ũ�� ��ȯ �� �� �ֵ�����
// byte�� ��ȯ
// ����ȭ�� transient Ű���尡 ���� �ν��Ͻ� ������ �ȴ�.
public class ProductVO implements Serializable {
	private static final long serialVersionUID = 1L;

	String code, name;
	int price, ea;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getEa() {
		return ea;
	}

	public void setEa(int ea) {
		this.ea = ea;
	}

}
