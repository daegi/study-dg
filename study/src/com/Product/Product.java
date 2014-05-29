package com.Product;
/*
- PreductVO : 직렬화 필요
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

public interface Product {
	public void input(); 
	public void updata();
	public void search();
	public void remove();
	public void list();
	public void saveFile();

}
