package com.test0422;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import com.sun.org.apache.bcel.internal.generic.DADD;

public class Test11 {

	public static void main(String[] args) {
		
		try {
			FileOutputStream fos = new FileOutputStream("ex.txt");
			//자료형별로 저장 가능한 필터 스트림
			DataOutputStream dos = new DataOutputStream(fos);
			
			dos.writeUTF("대한민국");
			dos.writeByte(10);
			dos.writeChar('a');
			dos.writeInt(100);
			dos.writeUTF("서울");
			
			dos.close();
			fos.close();
			
			FileInputStream fis = new FileInputStream("ex.txt");
			//자료형별로 자료를 입력 받을수 있는 필터 스트림
			DataInputStream dis = new DataInputStream(fis);
			
			System.out.println(dis.readUTF());
			System.out.println(dis.readByte());
			System.out.println(dis.readChar());
			System.out.println(dis.readInt());
			System.out.println(dis.readUTF());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
