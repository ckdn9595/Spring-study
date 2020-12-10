package com.increpas.cls.controller;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.increpas.cls.dao.ReBoardDao;
import com.increpas.cls.util.PageUtil;
import com.increpas.cls.vo.ReBoardVO;

@Controller
@RequestMapping("/reBoard")
public class ReBoard {
	@Autowired
	ReBoardDao reDao;
	
	@RequestMapping("/reBoardList.cls")
	public ModelAndView reBoardList(ModelAndView mv, HttpServletRequest req){
		
		// 아바타 꺼내오기
		String sid = "";
		String avatar = "noimage.jpg";
		try {

			sid = (String) req.getSession().getAttribute("SID");				
			
			avatar = reDao.selAvt(sid);
			mv.setViewName("reBoard/ReBoard");
		} catch(Exception e) {
			mv.setViewName("redirect:/main.cls");
			
		}
		
		// 파라미터 받고
		int nowPage = 1;
		try {
			nowPage = Integer.parseInt(req.getParameter("nowPage"));
		} catch(Exception e) {}
		
		
		// PageUtil 만들고
		int total = reDao.selCnt();
		
		PageUtil page = new PageUtil(nowPage, total);
		
		List<ReBoardVO> list  = reDao.selReBoard(page);
		
		// 데이터 뷰에 심고
		req.setAttribute("LIST", list);
		req.setAttribute("PAGE", page);
		req.setAttribute("AVTIMG", avatar);
		
		return mv;
	}
	
	@RequestMapping("/reBoardWriteProc.cls")
	public ModelAndView writeProc(ModelAndView mv, HttpServletRequest req) {
		//데이터 넣는거 부터하자
		ReBoardVO reVO = new ReBoardVO();
		reVO.setId(req.getParameter("id"));
		reVO.setBody(req.getParameter("body"));
		int cnt = 0;
		try {
			cnt = reDao.addContent(reVO);
		}catch(Exception e) {}
		
		if(cnt == 1) {
			mv.setViewName("redirect:/reBoard/reBoardList.cls");
		}else {
			mv.setViewName("reBoard/ReBoard");
		}
				
		return mv;
	}
	@RequestMapping("/reBoardDelProc.cls")
	public ModelAndView delProc(ModelAndView mv, HttpServletRequest req) {
		int bno = 0;
		try {
			bno = Integer.parseInt(req.getParameter("bno"));			
		}catch(Exception e) {}
		
		int cnt = reDao.delProc(bno);
		
		if(cnt == 1) {
			mv.setViewName("redirect:/reBoard/reBoardList.cls");
		}else {
			mv.setViewName("reBoard/ReBoard");
		}
		
		return mv;
	}
	@RequestMapping("/reBoardEditProc.cls")
	public ModelAndView EditBoard(ModelAndView mv, HttpServletRequest req, ReBoardVO reVO) {
		int cnt = reDao.editProc(reVO);
		if(cnt == 1) {
			mv.setViewName("redirect:/reBoard/reBoardList.cls");
		}else {
			mv.setViewName("reBoard/ReBoard");
		}
		
		return mv;
	}
	@RequestMapping("/reBoardComment.cls")
	public ModelAndView boardComment(ModelAndView mv, HttpServletRequest req) {
		
		mv.setViewName("reBoard/ReBoardComment");
		return mv;
	}
	@RequestMapping("/reBoardCommentProc.cls")
	public ModelAndView commentProc(ModelAndView mv, HttpServletRequest req, ReBoardVO reVO) {
		
		int cnt = reDao.addReBoard(reVO);
		if(cnt == 1) {
			mv.setViewName("redirect:/reBoard/reBoardList.cls");
		}else {
			mv.setViewName("reBoard/ReBoardComment");
		}
		return mv;
	}
}
