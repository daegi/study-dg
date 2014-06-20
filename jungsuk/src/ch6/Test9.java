package ch6;

import java.util.Iterator;
import java.util.Vector;

public class Test9 {

	public static void main(String[] args) {
		Vector<String> v= new Vector<String>();
		System.out.println("벡터의 초기 크기 :"+v.capacity());
		
		v.add("서울");
		v.add("부산");
		v.add("대구");
		v.add("광주");
		v.add("인천");
		
		System.out.println("요소의 개수 :"+v.size());
		
		System.out.println("첨:"+v.get(0));
		System.out.println("첨:"+v.firstElement());
		
		System.out.println("막:"+v.get(4));
		System.out.println("막"+v.lastElement());
		
		System.out.println("마지막:"+v.get(v.size()-1));
		System.out.println("마지막:"+v.lastElement());
		
		v.set(0, "seoul");
		v.add(1, "대한");
		v.remove(1);
		
		String s;
		System.out.println("모든 데이터 방법 1....");
		for (int i =0; i <v.size(); i++){
			s= v.get(i);
		System.out.println(s);
		}
		System.out.println();
		
		System.out.println("모든 데이터 방법2");
		for(String ss:v)
			System.out.println(ss);
		System.out.println();
		
		System.out.println("방법 3333333333333");
		
		Iterator<String> it = v.iterator();
		while(it.hasNext()){
			s=it.next();
			System.out.println(s);
		}
		System.out.println();
		
		v.clear();
		System.out.println(v.size());
		
		
		

	}

}
