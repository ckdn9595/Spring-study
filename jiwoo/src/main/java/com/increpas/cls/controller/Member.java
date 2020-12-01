package com.increpas.cls.controller;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;
import org.springframework.web.servlet.view.*;

import com.increpas.cls.dao.MemberDao;
import com.increpas.cls.vo.MemberVO;

@Controller
@RequestMapping("/member")
public class Member {
	
	@Autowired
	MemberDao mDao;
	
	@RequestMapping("/login.cls") // ==> 클래스의 /member 와 함수의 /login.cls 를 합쳐서 /member/login.cls 로 처리한다.
	public String loginPage() {
		return "member/login";
	}

	@RequestMapping(path="/loginProc.cls", params={"id", "pw"}, method=RequestMethod.POST)
	public ModelAndView loginProc(ModelAndView mv, RedirectView rd,
												HttpSession session, MemberVO mVO) {
		int cnt = mDao.loginCnt(mVO);
		System.out.println("### cont login cnt : " + cnt);
		if(cnt == 0) {
			rd.setUrl("/cls/member/login.cls");
		} else {
			session.setAttribute("SID", mVO.getId());
			rd.setUrl("/cls/main.cls");
		}
		
		mv.setView(rd);
		return mv;
	}
	
	@RequestMapping("/join.cls")
	public ModelAndView joinPage(ModelAndView mv, RedirectView rd, HttpSession session) {
		String sid;
		try {
			sid = (String) session.getAttribute("SID");
			rd.setUrl("/cls/main.cls");
			mv.setView(rd);
		}catch(Exception e){
			mv.setViewName("member/join");	//  forward로 뷰 를 부르는 경우 
			
		}
		
//		if(sid != null || sid.length() != 0) {
//			rd.setUrl("/cls/main.cls");
//			mv.setView(rd);	// redirect 로 뷰를 호출하는 경우
//		} else {
//			mv.setViewName("member/join");	//  forward로 뷰 를 부르는 경우 
//		}
		return mv;
	}
}
