package com.test0418;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.Properties;

public class Test2 {

	public static void main(String[] args) {
		
		// Hashtable�� ��� ���� Ŭ������ ȯ�� ���� ���
		// ���� ��� �Ǿ���
		Properties prop =new Properties();
		prop.setProperty("����", "1000");
		prop.setProperty("�λ�", "300");
		prop.setProperty("�뱸", "250");
		prop.setProperty("����", "150");
		prop.setProperty("��õ", "200");
		
		//String s=prop.getProperty("����");
		//System.out.println(s);
		
		try{
			//������Ƽ�� ������ ���Ͽ� ����
			FileOutputStream fos=new FileOutputStream("test.propeties");
			prop.store(fos,  "���ú��α�");
			fos.close();
			System.out.println("�������� ����.....");
		}catch(Exception e){
		}
		
		try{
			//���Ͽ� ����� ������Ƽ �ҷ�����
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
			System.out.println("������ ����.");
		}
	}

}
