package com.test0418;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.Properties;

public class Test2 {

	public static void main(String[] args) {
		
		// Hashtable을 상속 받은 클래스로 환경 설정 등에서
		// 많이 사용 되어짐
		Properties prop =new Properties();
		prop.setProperty("서울", "1000");
		prop.setProperty("부산", "300");
		prop.setProperty("대구", "250");
		prop.setProperty("광주", "150");
		prop.setProperty("인천", "200");
		
		//String s=prop.getProperty("서울");
		//System.out.println(s);
		
		try{
			//프로퍼티의 내용을 파일에 저장
			FileOutputStream fos=new FileOutputStream("test.propeties");
			prop.store(fos,  "도시별인구");
			fos.close();
			System.out.println("파일저장 성공.....");
		}catch(Exception e){
		}
		
		try{
			//파일에 저장된 프로퍼티 불러오기
			FileInputStream fls=new FileInputStream("test.propeties");
			Properties pp=new Properties();
			pp.load(fls);
			
			Iterator<Object> it=pp.keySet().iterator();
			while(it.hasNext()){
				String key=(String)it.next();
				String value = pp.getProperty(key);
				System.out.println(key+":"+value);
			}
			fls.close();
			
		}catch(Exception e){
			System.out.println("파일이 없다.");
		}
	}

}
