package ch6;

import java.util.Iterator;
import java.util.Vector;

public class Test8 {

	public static void main(String[] args) {
		
		Vector v =new Vector();
		
		v.add("서울");
		v.add("부산");
		v.add(new Integer(10));
		
		// 벡터에 저장된 데이터 가져오기
		Iterator it = v.iterator();
		
		while(it.hasNext()){
			
			Object o = it.next();
			if(o instanceof String){
				String s=(String)o;  
				System.out.println(s);
			}else if (o instanceof Integer){
				Integer ii=(Integer)o;
				System.out.println(ii);
			}
		}
		
		
			
		
	}

}
