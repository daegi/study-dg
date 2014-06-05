package com.test0409;

public class Test6 {

	public static void main(String[] args) {
		SelectionSort ss = new SelectionSort();

		int[] n = { 50, 42, 62, 75, 44 };

		ss.sort(n);
		for (int nn : n)
			System.out.print(nn + "  ");
		System.out.println();

	}

}

/*
 * abstract 클래스 -미완성 클래스 
 * -미완성 클래스이므로 객체 생성 불가 (예:java.util.Calendar) 
 * -abstract 메소드가 존재(선언만 있고 정의가 없는 메소드) 
 * -메모리 낭비없이 호출계획을 세우기 위해 사용 
 * -하나 이상의 abstract 메소드가 존재하는경우 반드시 abstract 클래스로 
 * 작성해야함(abstract)메소드가 없어도 가능 
 * -반드시 하위 클래스가 존재하며 abstract 클래스를 상속 받은 하위 클래스는
 *  모든 abstract 메소드를 재정의 해야함 단, 하위 클래스가 abstract 클래스
 * 이면 재정의 하지 않아도됨
 */

abstract class SortInt {
	protected int[] num;

	public abstract void sorting();

	public void sort(int[] num) {
		this.num = num;
		sorting();
	}

	public int length() { // 배열 요소의 개수
		if (num == null)
			return 0;
		return num.length;
	}

	public void swap(int i, int j) {
		int t = num[i];
		num[i] = num[j];
		num[j] = t;

	}

	public int compare(int i, int j) {
		return num[i] - num[j];
	}
}

class SelectionSort extends SortInt {

	// @Override: 어노테이션, 부가적인 정보
	// 주석은 컴파일할때 없어지지만 어노테이션은 없어지지않음
	// @Override은 메소드 재정의된 사실을 알려주는 것으로
	// 문법에 어긋나면 에러 표시함

	@Override
	public void sorting() {
		if (length() == 0)
			return;

		for (int i = 0; i < length() - 1; i++) {
			for (int j = i + 1; j < length(); j++) {
				if (compare(i, j) > 0)
					swap(i, j);
			}
		}

	}
}

class BubbleSort extends SortInt{

	@Override
	public void sorting() {
		// TODO Auto-generated method stub
		int pass=1;
		boolean flag;
		
		do{
			flag=false;
			for(int i=0; i<length()-pass;i++){
				if(compare(i, i+1)>0){
					swap(i,i+1);
					flag=true;
				}
			}
			pass++;
		}while(flag);
		
	}
	
}
