package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.StockDao;
import com.example.demo.vo.StockVo;
import com.google.gson.Gson;

@Controller
public class StockContoller {
	@Autowired
	private StockDao dao;

	public void setDao(StockDao dao) {
		this.dao = dao;
	}

	@RequestMapping("/listStock.do")
	public ModelAndView listStock() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", dao.listStock());
		return mav;
	}

	@RequestMapping("/detailStock.do")
	public ModelAndView detailStock(int stockno) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("s", dao.detail(stockno));
		return mav;
	}

	@RequestMapping(value = "/insertStock.do", method = RequestMethod.GET)
	public void insertForm() {
	}

	@RequestMapping(value = "/insertStock.do", method = RequestMethod.POST)
	public ModelAndView insertSubmit(StockVo s) {
		int re = -1;
		ModelAndView mav = new ModelAndView();
		re = dao.insert(s);
		if (re > 0) {
			mav.setViewName("redirect:/listStock.do");
			System.out.println("성공");
		}
		return mav;
	}
	@RequestMapping("/deleteStock.do")
	public ModelAndView delete(StockVo s) {
		int re = -1;
		ModelAndView mav = new ModelAndView();
		re = dao.delete(s);
		if (re > 0) {
			mav.setViewName("redirect:/listStock.do");
			System.out.println("성공");
		}
		return mav;
	}
	@RequestMapping(value = "/updateStock.do", method = RequestMethod.GET)
	public ModelAndView updateForm(int stockno) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("s",dao.detail(stockno));
		return mav;
	}

	@RequestMapping(value = "/updateStock.do", method = RequestMethod.POST)
	public ModelAndView updateSubmit(StockVo s) {
		int re = -1;
		ModelAndView mav = new ModelAndView();
		re = dao.update(s);
		if (re > 0) {
			mav.setViewName("redirect:/listStock.do");
			System.out.println("성공");
		}
		return mav;
	}
}
