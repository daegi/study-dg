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
			//�ڷ������� ���� ������ ���� ��Ʈ��
			DataOutputStream dos = new DataOutputStream(fos);
			
			dos.writeUTF("���ѹα�");
			dos.writeByte(10);
			dos.writeChar('a');
			dos.writeInt(100);
			dos.writeUTF("����");
			
			dos.close();
			fos.close();
			
			FileInputStream fis = new FileInputStream("ex.txt");
			//�ڷ������� �ڷḦ �Է� ������ �ִ� ���� ��Ʈ��
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
