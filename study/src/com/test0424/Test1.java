package com.test0424;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Hashtable;
import java.util.Iterator;

public class Test1 {

	public static void main(String[] args) {
		Hashtable<String, String> ht = new Hashtable<>();

		ht.put("1", "자바");
		ht.put("2", "JSP/Servlet");
		ht.put("3", "HTML5/CSS3");
		ht.put("4", "Framework");

		try {
			FileOutputStream fos = new FileOutputStream("tx.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos); // ObjectOutputStream으로
																	// 객체를 저장
			oos.writeObject(ht); // 해쉬테이블에 있던 정보를 저장
			oos.close();

			FileInputStream fis = new FileInputStream("ex.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);

			Hashtable ht2 = (Hashtable) ois.readObject();
			ois.close();

			Iterator<Object> it = ht2.keySet().iterator();
			while (it.hasNext()) {
				String key = (String) it.next();
				String value = (String) ht2.get(key);
				System.out.println(key + ":" + value);
			}

		} catch (Exception e) {

		}

	}

}
