package com.test0415;

import java.util.Iterator;
import java.util.Vector;

public class Test8 {

	public static void main(String[] args) {
		// JDK 1.4 방식
		Vector v = new Vector();  //Object형을 저장

		v.add("서울");
		v.add("부산");
		v.add(new Integer(10));

		// 벡터에 저장된 데이터 가져오기
		Iterator it = v.iterator();
		while (it.hasNext()) {
			// 이렇게 짜면 런타임 오류가 발생함
			//String s= (String)it.next();
			//System.out.println(s);
			
			Object o= it.next();
			if(o instanceof String){
				String s=(String)o;
				System.out.println(s);
			}else if(o instanceof Integer){
				Integer ii=(Integer)o;
				System.out.println(ii);
			}
		}

	}

}
