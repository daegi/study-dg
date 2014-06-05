package com.Product;

import java.io.Serializable;

/*
 - ProductVO : 직렬화 필요
 상품코드, 상품명, 수량, 단가

 -Product : 인터페이스
 input(), updata(), search(), remove(), list(), saveFile()

 -ProductImpl : Product 구현 클래스
 ArrayList<ProductVO> list=new...... 

 input(), update(), search(), remove(), list(), saveFile(), loadFile()

 -ProductMain :
 1.추가 2. 출고 3.검색 4.삭제 5.리스트 6.종료

 -단, 파일 처리는 객체를 저장하고 불러오는 ObjectInputStream, ObjectOutputStream 이용  
 */

//객체 직렬화(Serializable 만 구현하면 됨)
// 객체를 파일에 저장하거나 네트워크로 전환 할 수 있도록함
// byte로 변환
// 직렬화는 transient 키워드가 없는 인스턴스 변수만 된다.
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
