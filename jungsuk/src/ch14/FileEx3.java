package ch14;

import java.io.File;
import java.util.ArrayList;

public class FileEx3 {
	static int totalFiles = 0;
	static int totalDirs = 0;

	public static void main(String[] args) {

		if (args.length != 1) {
			System.out.println("USAGE: java FileEx3 DIRECTORY");
			System.exit(0);
		}

		File dir = new File(args[0]);

		// exists() > 추상 경로명이 가리키는 파일 또는 디렉토리가 존재하는 경우는 true, 그렇지 않은 경우는 false
		// isDirectory() >추상 경로명이 가리키는 파일이 존재해, 한층 더 그것이 디렉토리인 경우는 true, 그렇지 않은 경우는 false 

		if (!dir.exists() || !dir.isDirectory()) {
			System.out.println("유요하지 않은 디렉토리입니다.");
			System.exit(0);
		}
		printFileList(dir);

		System.out.println();
		System.out.println("총" + totalFiles + "개의 파일");
		System.out.println("총" + totalDirs + "개의 디렉토리");
	}

	public static void printFileList(File dir) {
		
		//get.AbsolutePath() > 추상 경로명의 절대 경로명 스트링을 돌려줍니다
		System.out.println(dir.getAbsolutePath() + " 디렉토리");
		
		//listFiles() > 추상 경로명이 가리키는 디렉토리내의 파일을 나타내는 추상 경로명의 배열을 돌려줍니다
		File[] files = dir.listFiles();

		ArrayList subDir = new ArrayList();

		for (int i = 0; i < files.length; i++) {
			String filename = files[i].getName();

			if (files[i].isDirectory()) {
				filename = "[" + filename + "]";
				subDir.add(i + "");
			}
			System.out.println(filename);
		}
		int dirNum = subDir.size();
		int fileNum = files.length - dirNum;

		totalFiles += fileNum;
		totalDirs += dirNum;

		System.out.println(fileNum + "개의 파일," + dirNum + "개의 디렉토리");
		System.out.println();

		for (int i = 0; i < subDir.size(); i++) {
			int index = Integer.parseInt((String) subDir.get(i));
			printFileList(files[index]); //재귀 호출
		}

	}

}
