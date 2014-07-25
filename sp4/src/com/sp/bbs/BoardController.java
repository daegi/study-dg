package com.sp.bbs;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sp.common.MyUtil;

@Controller("bbs.boardController")
public class BoardController {

	@Autowired
	private BoardService service;

	@Autowired
	MyUtil myUtil = new MyUtil();

	@RequestMapping(value = "bbs/list")
	public ModelAndView list(
			@RequestParam(value = "pageNum", defaultValue = "1") int current_page,
			@RequestParam(value = "numPerPage", defaultValue = "5") int numPerPage,
			@RequestParam(value = "searchKey", defaultValue = "subject") String searchKey,
			@RequestParam(value = "searchValue", defaultValue = "") String searchValue,
			HttpServletRequest req) throws Exception {

		String cp = req.getContextPath();

		int total_page;
		int dataCount;

		if (req.getMethod().equalsIgnoreCase("GET")) {
			searchValue = URLDecoder.decode(searchValue, "UTF-8");
		}

		// 전체 페이지 수
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchKey", searchKey);
		map.put("searchValue", searchValue);

		dataCount = service.dataCount(map);

		total_page = myUtil.getPageCount(numPerPage, dataCount);

		if (current_page > total_page)
			current_page = total_page;

		// 게시물 리스트
		int start = (current_page - 1) * numPerPage + 1;
		int end = (current_page * numPerPage);
		map.put("start", start);
		map.put("end", end);

		List<Object> list = service.listBoard(map);

		// 게시물 번호 만들기
		int listNum, n = 0;
		Iterator<Object> it = list.iterator();
		while (it.hasNext()) {
			Board b = (Board) it.next();
			listNum = dataCount - (start + n - 1);
			b.setListNum(listNum);
			n++;
		}

		String params = "numPerPage=" + numPerPage;
		String urlList, urlArticle;

		if (searchValue.length() != 0) {
			params += "&searchKey=" + searchKey + "&searchValue="
					+ URLEncoder.encode(searchValue, "UTF-8");
		}

		if (params.length() == 0) {
			urlList = cp + "/bbs/list.action";
			urlArticle = cp + "/bbs/article.action?pageNum=" + current_page;
		} else {
			urlList = cp + "/bbs/list.action?" + params;
			urlArticle = cp + "/bbs/article.action?pageNum=" + current_page
					+ "&" + params;

		}

		String pageIndexList = myUtil.pageIndexList(current_page, total_page,
				urlList);

		ModelAndView mav = new ModelAndView("bbs/list");

		// 포워딩할 JSP에 넘길 값
		mav.addObject("list", list);
		mav.addObject("dataCount", dataCount);
		mav.addObject("pageIndexList", pageIndexList);
		mav.addObject("urlArticle", urlArticle);
		mav.addObject("pageNum", current_page);
		mav.addObject("numPerPage", numPerPage);

		return mav;
	}

	@RequestMapping(value = "bbs/created", method = RequestMethod.GET)
	public ModelAndView createdForm() throws Exception {

		ModelAndView mav = new ModelAndView("bbs/created");

		return mav;
	}

	@RequestMapping(value = "bbs/created", method = RequestMethod.POST)
	public String createdSubmit(Board dto, HttpServletRequest req)
			throws Exception {

		dto.setIpAddr(req.getRemoteAddr());

		service.insertBoard(dto);

		return "redirect:/bbs/list.action";
	}

	@RequestMapping(value = "bbs/article")
	public ModelAndView article(
			@RequestParam(value = "num") int num,
			@RequestParam(value = "pageNum") int pageNum,
			@RequestParam(value = "numPerPage") String numPerPage,
			@RequestParam(value = "searchKey", defaultValue = "subject") String searchKey,
			@RequestParam(value = "searchValue", defaultValue = "") String searchValue,
			HttpServletRequest req) throws Exception {

		if (req.getMethod().equalsIgnoreCase("get")) {
			searchValue = URLDecoder.decode(searchValue, "utf-8");
		}

		// 조회수 증가
		service.updateHitCount(num);

		// 게시물 가져오기
		Board dto = service.readBoard(num);
		if (dto == null) {
			return new ModelAndView("Redirect:/bbs/list.action?pageNum"
					+ pageNum);
		}

		// 전체줄수
		int linesu = dto.getContent().split("\n").length;

		// \n을 br 태그로
		dto.setContent(dto.getContent().replaceAll("\n", "<br/>"));

		// 이전글과 다음글
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchKey", searchKey);
		map.put("searchValue", searchValue);
		map.put("num", num);

		Board preDTO = service.preReadBoard(map);
		Board nextDTO = service.nextReadBoard(map);

		String params = "pageNum=" + pageNum + "&numPerPage=" + numPerPage;

		if (searchValue.length() != 0) {
			params += "&searchKey=" + searchKey + "&searchValue="
					+ URLEncoder.encode(searchValue, "utf-8");
		}

		ModelAndView mav = new ModelAndView();

		mav.addObject("dto", dto);
		mav.addObject("linesu", linesu);
		mav.addObject("preDTO", preDTO);
		mav.addObject("nextDTO", nextDTO);
		mav.addObject("params", params);
		mav.addObject("pageNum", pageNum);
		mav.addObject("numPerPage", numPerPage);
		mav.addObject("searchKey", searchKey);
		mav.addObject("searchValue", searchValue);

		return mav;
	}

	@RequestMapping(value = "bbs/pwd", method = RequestMethod.GET)
	public String pwdForm(String mode, int num, String pageNum,
			String numPerPage, HttpServletRequest req) throws Exception {

		String title = "수정";

		if (mode.equals("delete")) {
			title = "삭제";
		}

		req.setAttribute("num", num);
		req.setAttribute("pageNum", pageNum);
		req.setAttribute("numPerPage", numPerPage);
		req.setAttribute("mode", mode);
		req.setAttribute("title", title);

		return "bbs/pwd";
	}

	@RequestMapping(value = "bbs/pwd", method = RequestMethod.POST)
	public String pwdSubmit(String mode, int num, String pageNum,
			String numPerPage, String pwd, HttpServletRequest req)
			throws Exception {

		Board dto = service.readBoard(num);
		if (dto == null) {
			return "redirect:/bbs/list.action?pageNum=" + pageNum
					+ "&numPerPage" + numPerPage;
		}

		// 패스워드가 일치하지 않은경우
		if (!dto.getPwd().equals(pwd)) {
			String title = "수정";
			if (mode.equals("delete"))
				title = "삭제";

			req.setAttribute("num", num);
			req.setAttribute("pageNum", pageNum);
			req.setAttribute("numPerPage", numPerPage);
			req.setAttribute("mode", mode);
			req.setAttribute("title", title);
			req.setAttribute("msg", "패스워드가 일치 하지 않습니다.");

			return "bbs/pwd";
		}
		return "bbs/list";
	}
}
