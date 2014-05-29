package com.test0404;
//stringbuffer
public class Test8 {

	public static void main(String[] args) {
		
		StringBuffer sb1=new StringBuffer();
		
		//ÃÊ±â ¹öÆÛÀÇ Å©±â
		System.out.println(sb1.capacity()); //16
		
		sb1.append("¼­¿ï");
		sb1.append("ºÎ»ê");
		sb1.append("´ëÇÑ¹Î±¹");
		sb1.append("ÇÑ±¹");
		sb1.append("´ë±¸");
		sb1.append("±¤ÁÖ");
		sb1.append("°æ±â");
		
		
		System.out.println(sb1);
		
		System.out.println(sb1.capacity());
		
		sb1.insert(0, "korea");
		System.out.println(sb1);
		
		//±¤ÁÖ ´ÙÀ½¿¡ ±¤¿ª½Ã Ãß°¡
		
		System.out.println(sb1.indexOf("±¤ÁÖ"));
		sb1.insert(sb1.indexOf("±¤ÁÖ")+"±¤ÁÖ".length(), "±¤¿ª½Ã");
		System.out.println(sb1);
		
		//±¤ÁÖ ±¤¿ª½Ã »èÁ¦
		sb1.delete(sb1.indexOf("±¤ÁÖ±¤¿ª½Ã"),
				sb1.indexOf("±¤ÁÖ±¤¿ª½Ã")+"±¤ÁÖ±¤¿ª½Ã".length());
		System.out.println(sb1);
		
		
		StringBuffer s1 =new StringBuffer("korea");
		StringBuffer s2 =new StringBuffer("korea");
		
		System.out.println(s1==s2);
		System.out.println(s1.equals(s2));
		System.out.println(s1.toString().equals(s2.toString()));
		
		System.out.println(s1);
		System.out.println(s1.toString().toUpperCase());
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
