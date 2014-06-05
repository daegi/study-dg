package com.Product;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

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

public class ProductImpl implements Product {

	private String pathname = "c:" + File.separator + "data" + File.separator
			+ "sung.dat";
	private List<ProductVO> list = new ArrayList<>();
	private Scanner sc = new Scanner(System.in);

	public ProductImpl() {

		loadFile();
	}

	private void loadFile() {
		FileInputStream fis = null;
		ObjectInputStream ois = null;

		try {
			File f = new File(pathname);

			if (!f.exists())
				return;
			fis = new FileInputStream(f);
			ois = new ObjectInputStream(fis);

			while (true) {
				ProductVO vo = (ProductVO) ois.readObject();
				list.add(vo);

			}
		} catch (EOFException e) {

		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			if (ois != null) {
				try {
					ois.close();
				} catch (Exception e2) {
				}
			}
		}
	}

	@Override
	public void input() {
		try {
			ProductVO vo = new ProductVO();
			System.out.print("코드?");
			vo.setCode(sc.next());
			System.out.print("상품명?");
			vo.setName(sc.next());
			System.out.print("수량?");
			vo.setEa(sc.nextInt());
			System.out.print("가격?");
			vo.setPrice(sc.nextInt());

			list.add(vo);
			System.out.println("추가완료...\n");
		} catch (Exception e) {
			System.out.println("입력 오류...");
		}
	}

	@Override
	public void updata() {
		// TODO Auto-generated method stub

	}

	@Override
	public void search() {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub

	}

	@Override
	public void list() {

		Comparator<ProductVO> comp = new Comparator<ProductVO>() {
			@Override
			public int compare(ProductVO s1, ProductVO s2) {
				return s1.getName().compareTo(s2.getName());
			}
		};
		Collections.sort(list, comp);

		System.out.println("\n이름순.....");
		for (ProductVO vo : list)
			System.out.println(vo);
		System.out.println();
	}

	@Override
	public void saveFile() {

		try {

			File f = new File(pathname);
			if (!f.getParentFile().exists()) {
				f.getParentFile().mkdirs();
			}

			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			// oos.writeObject(new MyRec3("홍길동", "111-1111", 10));
			for (ProductVO vo : list) {
				oos.writeObject(vo);

			}
			oos.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}
