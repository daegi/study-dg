package com.util;

public class My {

	public int getPageCount(int numPerPage, int dataCount) {
		int count = 0;

		count = dataCount / numPerPage;
		if (dataCount % numPerPage != 0)
			count++;
		return count;
	}

	public String pageIndexList1(int current_page, int totall_page, String url) {
		StringBuffer sb = new StringBuffer();
		int currentPageSetup, n, page;
		int numPerBlock = 10;

		if (current_page == 0)
			return "";
		if (url.indexOf("?") != -1)
			url += "&";
		else
			url += "?";

		currentPageSetup = (current_page / numPerBlock) * numPerBlock;

		return sb.toString();

	}
}
