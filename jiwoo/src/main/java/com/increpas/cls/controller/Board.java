package com.increpas.cls.controller;

import java.io.File;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.*;

import com.increpas.cls.dao.*;
import com.increpas.cls.service.BoardService;
import com.increpas.cls.util.*;
import com.increpas.cls.vo.*;
import com.oreilly.servlet.MultipartRequest;

@Controller
@RequestMapping("/board")
public class Board {
	@Autowired
	BoardDao bDao;
	@Autowired
	BoardService bSrvc;
	
	@RequestMapping("/boardList.cls")
	public ModelAndView board(ModelAndView mv, PageUtil page) {
		int total = bDao.getTotal();
		
		page.setPage(total, 5, 5);
		
		List<BoardVO> list = bDao.getList(page);
		
		mv.addObject("PAGE", page);
		mv.addObject("LIST", list);
		
		mv.setViewName("board/BoardList");
		return mv;
	}
	@RequestMapping("/boardDetail.cls")
	public ModelAndView boardDetail(ModelAndView mv, int bno) {
		BoardVO bVO = bDao.getDetail(bno);
		List<FileVO> list = bDao.getImage(bno);
		
		mv.addObject("DATA", bVO);
		mv.addObject("LIST", list);
		
		mv.setViewName("board/BoardDetail");
		return mv;
	}
	
	@RequestMapping("/boardWrite.cls")
	public ModelAndView boardWrtie(ModelAndView mv, HttpSession session, PageUtil page) {
		if(session.getAttribute("SID") == null) {
			mv.setViewName("redirect:member/login.cls");
		}else {
			mv.addObject("PAGE", page);
			mv.setViewName("board/BoardWrite");			
		}
		return mv;
	}
	
	@RequestMapping("/boardWriteProc.cls")
	public ModelAndView boardWrtieProc(ModelAndView mv, BoardVO bVO, HttpSession session, PageUtil page ) {
		if(session.getAttribute("SID") == null) {
			mv.setViewName("redirect:member/login.cls");
		}else {
			mv.addObject("NOWPAGE", page);
			mv.addObject("VIEW", "/cls/board/boardWrite.cls");
			mv.setViewName("/board/boardRedirect");
		}
		
		return mv;
	}

}
