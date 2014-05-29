package com.test0423;

import java.io.File;

public class Test4 {

	public static void main(String[] args) {
		String s;
		double tot, used, free, usable;

		File[] roots = File.listRoots();
		for (File f : roots) {
			s = f.getAbsolutePath();

			tot = f.getTotalSpace() / Math.pow(1024, 3);
			usable = f.getUsableSpace() / Math.pow(1024, 3);
			free = f.getFreeSpace() / Math.pow(1024, 3);
			used = (tot -usable);

			System.out.println("�ϵ�:" + s);
			System.out.println("�ѿ뷮:" + tot);
			System.out.println("���ɿ뷮:" + usable);
			System.out.println("�����뷮:" + free);
			System.out.println("����ѿ뷮:" + used);

		}

	}

}
