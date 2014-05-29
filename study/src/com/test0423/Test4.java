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

			System.out.println("하드:" + s);
			System.out.println("총용량:" + tot);
			System.out.println("가능용량:" + usable);
			System.out.println("여유용량:" + free);
			System.out.println("사용한용량:" + used);

		}

	}

}
