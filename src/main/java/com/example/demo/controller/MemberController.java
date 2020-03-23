package com.example.demo.controller;


import javax.servlet.http.HttpSession;

import org.omg.CORBA.OMGVMCID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.MemberDao;
import com.example.demo.vo.MemberVo;

@Controller
public class MemberController {
	@Autowired 
	private MemberDao dao;

	public void setDao(MemberDao dao) {
		this.dao = dao;
	}
	
	
	@RequestMapping(value = "/loginMember.do", method = RequestMethod.GET) 
	public void loginForm() {
	}
	
	@RequestMapping(value = "/loginMember.do", method = RequestMethod.POST)
	public ModelAndView loginSubmit(MemberVo vo, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		MemberVo m =dao.login(vo);
		session.setAttribute("login", dao.login(vo));
		mav.setViewName("redirect:/listStock.do");
		return mav;
	}
	@RequestMapping(value = "/insertMember.do", method = RequestMethod.GET)
	public void insertForm() {
	}
	@RequestMapping(value = "/insertMember.do", method = RequestMethod.POST)
	public ModelAndView insertSubmit(MemberVo vo) {
		int re = -1;
		ModelAndView mav = new ModelAndView();
		re = dao.insert(vo);
		if(re>0) {
			mav.setViewName("redirect:/loginMember.do");
		}
		return mav;
	}
}
