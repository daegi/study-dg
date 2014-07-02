package com.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

public class FileManager {

	/**
	 * 
	 * @param saveFilename
	 *            서버에 저장된 파일이름
	 * @param originalFileName
	 *            클라이언트가 업로드한 파일이름
	 * @param pathname
	 *            파일이 저장된 경로
	 * @param resp
	 *            HttpServletRespones 객체
	 * @return 다운로드 성공여부
	 */

	public boolean doFileDownload(String saveFilename, String originalFileName,
			String pathname, HttpServletResponse resp) {
		boolean b = false;

		String path = pathname + File.separator + saveFilename;

		File f = new File(path);
		if (!f.exists())// 존재하지 않으면
			return b;

		try {
			if (originalFileName == null || originalFileName.length() == 0) {
				originalFileName = saveFilename;
			}

			// 파일이름을 클라이언트에게 전송할때 8859-1로 전송 해야함
			originalFileName = new String(originalFileName.getBytes("utf-8"),
					"8859_1");

			byte[] bb = new byte[2048];

			// 서버에서 클라이언트로 전송되는 content type
			resp.setContentType("application/octet-stream");
			// 해더에 파일명을 실어 보냄
			resp.setHeader("Content-disposition", "attachment;filename="
					+ originalFileName);

			// 서버에 저장된파일의 내용을 읽어서 클라이언트에 전송
			BufferedInputStream bis = new BufferedInputStream(
					new FileInputStream(f));

			// 클라이언트에 전송할때 사용할 스트림
			OutputStream out = resp.getOutputStream();

			int n;

			while ((n = bis.read(bb, 0, bb.length)) != -1) {
				out.write(bb, 0, n);

			}
			out.flush();

			bis.close();

			return true;

		} catch (Exception e) {
		}

		return b;
	}

	/**
	 * 
	 * @param filename
	 * @param pathname
	 */
	public void doFileDelete(String filename, String pathname) {
		String path = pathname + File.separator + filename;
		File f = new File(path);

		try {
			if (f.exists())// 파일이 존재하면
				f.delete();// 파일 삭제
		} catch (Exception e) {
		}
	}

}
