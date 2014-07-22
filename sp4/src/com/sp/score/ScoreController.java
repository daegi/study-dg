package com.sp.score;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sp.common.MyUtil;

@Controller("score.scoreController")
public class ScoreController {

	@Resource(name = "score.scoreDAO")
	private ScoreDAO dao;

	@Autowired
	private MyUtil myUtil;

	// Service 클래스를 작성해서 비지니스 로직을 작성해야 한다.
	// 즉, DAO 등은 서비스 클래스에서 접근한다.

	@RequestMapping(value = "/score/score")
	public ModelAndView list(
			@RequestParam(value = "pageNum", defaultValue = "1") int current_page,
			HttpServletRequest req) throws Exception {

		// 페이지 처리
		String cp = req.getContextPath();
		int numPerPage = 10;
		int total_page;
		int dataCount;

		// 전체 페이지수
		Map<String, Object> map = new HashMap<>();

		dataCount = dao.dataCount();
		total_page = myUtil.getPageCount(numPerPage, dataCount);

		if (current_page > total_page)
			current_page = total_page;

		int start = (current_page - 1) * numPerPage + 1;
		int end = current_page * numPerPage;

		map.put("start", start);
		map.put("end", end);

		List<Score> list = dao.listScore(map);

		String listUrl = cp + "/score/score.action";
		String pageIndexList = myUtil.pageIndexList(current_page, total_page,
				listUrl);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("score/list");

		// 포워딩할 list.jsp에 넘길 데이터
		mav.addObject("list", list);
		mav.addObject("dataCount", dataCount);
		mav.addObject("pageIndexList", pageIndexList);
		mav.addObject("pageNum", current_page);

		return mav;
	}

	@RequestMapping(value = "/score/write", method = RequestMethod.GET)
	public ModelAndView from() throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("score/write");

		return mav;
	}

	@RequestMapping(value = "/score/write", method = RequestMethod.POST)
	public String submit(Score score) throws Exception {
		// 테이블에 저장
		dao.insertScore(score);

		// 리다이렉트
		return "redirect:/score/score.action";
	}

	@RequestMapping(value = "/score/update", method = RequestMethod.GET)
	public ModelAndView updateForm(@RequestParam("hak") String hak,
			@RequestParam("pageNum") String pageNum) throws Exception {

		Score dto = dao.readScore(hak);
		if (dto == null) {
			return new ModelAndView("redirect:/score/score.action?pageNum="
					+ pageNum);
		}

		ModelAndView mav = new ModelAndView();
		mav.setViewName("score/update");
		mav.addObject("dto", dto);
		mav.addObject("pageNum", pageNum);

		return mav;
	}

	@RequestMapping(value = "/score/update", method = RequestMethod.POST)
	public String updateSubmit(Score dto, String pageNum) throws Exception {

		dao.updateScore(dto);

		return "redirect:/score/score.action?pageNum=" + pageNum;

	}

	@RequestMapping(value = "/score/delete", method = RequestMethod.GET)
	public String deleteSubmit(String hak, String pageNum) throws Exception {

		dao.deleteScore(hak);

		return "redirect:/score/score.action";

	}
}
