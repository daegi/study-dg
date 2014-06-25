package com.util;

public class MyUtil {

	// 전체 페이지수 구하기

	/**
	 * 
	 * @param numPerPage
	 *            한화면에 표시할 데이터수
	 * @param dataCount
	 *            전체 데이터 수
	 * @return 총페이지수
	 */
	public int getPageCount(int numPerPage, int dataCount) {

		int count = 0;

		count = dataCount / numPerPage;
		if (dataCount % numPerPage != 0)
			count++;

		return count;
	}

	/**
	 * 페이징 처리 메소드
	 * @param current_page 현재 화면에 표시되는 페이지
	 * @param total_page 전체 페이지 수
	 * @param url <code>String</code> 링크를 설정할 주소
	 * @return 페이징 처리 결과
	 */

	public String pageIndexList1(int current_page, int total_page, String url) {
		StringBuffer sb = new StringBuffer();

		int currentPageSetup, n, page;
		int numPerBlock = 10;

		if (current_page == 0)
			return "";

		if (url.indexOf("?") != -1)
			url += "&";
		else
			url += "?";

		// currentPageSetup : 표시할 시작 페이지 -1
		currentPageSetup = (current_page / numPerBlock) * numPerBlock;

		if (current_page % numPerBlock == 0)
			currentPageSetup -= numPerBlock;

		// 1[이전] (currentPageSetup >= 0)
		// 다시 확인
		if (currentPageSetup >= 10) {
			n = current_page - numPerBlock;
			sb.append("<a href='" + url + "pageNum=1'>1</a>&nbsp;");
			sb.append("[<a href='" + url + "pageNum=" + n + "'>이전</a>]&nbsp;");
		}

		// 바로가기 페이지
		page = currentPageSetup + 1;
		while (page <= total_page && page <= (currentPageSetup + numPerBlock)) {
			if (page == current_page) {
				sb.append("<font color='Fuchsia'>" + page + "</font>&nbsp;");
			} else {
				sb.append("<a href='" + url + "pageNum=" +page + "'>"+page+"</a>&nbsp;");
			}
			page++;
		}
		//다음 마지막 페이지
		n=current_page+numPerBlock;
		if(total_page - currentPageSetup > numPerBlock){
			sb.append("[<a href='" + url + "pageNum=" + n + "'>다음</a>]&nbsp;");
			sb.append("[<a href='" + url + "pageNum=" + total_page + "'>"+total_page+"</a>]&nbsp;");	
		}
		return sb.toString();
	}
	
	public String pageIndexList(int current_page, int total_page, String list_url) {
		StringBuffer sb=new StringBuffer();
		
		int numPerBlock=10;
		int currentPageSetup;
		int n, page;
		
		if(current_page<1 || total_page < 1)
			return "";
		
		if(list_url.indexOf("?")!=-1)
			list_url+="&";
		else
			list_url+="?";
		
		// currentPageSetup : 표시할첫페이지-1
		currentPageSetup=(current_page/numPerBlock)*numPerBlock;
		if(current_page%numPerBlock==0)
			currentPageSetup=currentPageSetup-numPerBlock;

		sb.append("<style type='text/css'>");
		sb.append("#paginate {clear:both;font:12px 돋움,Dotum,굴림,Gulim,AppleGothic;padding:15px 0px 0px 0px;text-align:center;height:30px;white-space:nowrap;}");
		sb.append("#paginate a {border:1px solid #ccc;height:30px;color:#000000;text-decoration:none;padding:5px 8px 5px 8px;margin-left:3px;line-height:normal;vertical-align:middle;outline:none; select-dummy: expression(this.hideFocus=true);}");
		sb.append("#paginate a:hover, a:active {border:1px solid #ccc;color:#6771ff;vertical-align:middle; line-height:normal;}");
		sb.append("#paginate .curBox {border:1px solid #e28d8d; background: #fff; color:#cb3536; font-weight:bold;height:30px;padding:5px 8px 5px 8px;margin-left:3px;line-height:normal;vertical-align:middle;}");
		sb.append("#paginate .numBox {border:1px solid #ccc;height:30px;font-weight:bold;text-decoration:none;padding:5px 8px 5px 8px;margin-left:3px;line-height:normal;vertical-align:middle;}");
		sb.append("</style>");
		
		sb.append("<div id='paginate'>");
		// 처음페이지, 이전(10페이지 전)
		n=current_page-numPerBlock;
		if(total_page > numPerBlock && currentPageSetup > 0) {
			sb.append("<a href='"+list_url+"pageNum=1'>처음</a>");
			sb.append("<a href='"+list_url+"pageNum="+n+"'>이전</a>");
		}
		
		// 바로가기
		page=currentPageSetup+1;
		while(page<=total_page && page <=(currentPageSetup+numPerBlock)) {
			if(page==current_page) {
				sb.append("<span class='curBox'>"+page+"</span>");
			} else {
				sb.append("<a href='"+list_url+"pageNum="+page+"' class='numBox'>"+page+"</a>");
			}
			page++;
		}
		
		// 다음(10페이지 후), 마지막페이지
		n=current_page+numPerBlock;
		if(total_page-currentPageSetup>numPerBlock) {
			sb.append("<a href='"+list_url+"pageNum="+n+"'>다음</a>");
			sb.append("<a href='"+list_url+"pageNum="+total_page+"'>끝</a>");
		}
		sb.append("</div>");
	
		return sb.toString();
	}
}
