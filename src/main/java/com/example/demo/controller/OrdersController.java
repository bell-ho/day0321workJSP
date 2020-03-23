package com.example.demo.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.OrdersDao;
import com.example.demo.dao.StockDao;
import com.example.demo.vo.OrdersVo;
import com.example.demo.vo.StockVo;

@Controller
public class OrdersController {
	@Autowired //@Autowired는 dao당 하나씩
	private OrdersDao dao;
	
	@Autowired
	private StockDao sdao;

	public void setDao(OrdersDao dao) {
		this.dao = dao;
	}

	public void setDao(StockDao sdao) {
		this.sdao = sdao;
	}

	@RequestMapping("/listOrders.do")
	public ModelAndView listOrders(int memberno) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", dao.listOrders(memberno));
		return mav;
	}

	@RequestMapping(value = "/insertOrders.do", method = RequestMethod.GET)
	public ModelAndView insertForm(int stockno) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("svo", sdao.detail(stockno));
		return mav;
	}

	@RequestMapping(value = "/insertOrders.do", method = RequestMethod.POST)
	public ModelAndView insertSubmit(OrdersVo o) {
		int re = -1;
		ModelAndView mav = new ModelAndView();
		StockVo sv = sdao.detail(o.getStockno()); // 이렇게되면 sv에 현재qty가 담김
		if (o.getOrderqty() <= sv.getQty()) { // 만약 주문수량이 현재가지고있는 수량보다 적다면 실행된다
			re = dao.insertOrders(o); // 참이니 dao를 실행한다
			if (re > 0) {
				sv.setQty(sv.getQty() - o.getOrderqty()); // 현재수량에서 주문수량을 빼서 그값을 현재수량으로 세팅해준다
				sdao.update(sv); // 받은 sv로 update를 실행한다
				mav.setViewName("redirect:/listOrders.do?memberno=" + o.getMemberno());
				// 성공시 해당 member의 주문리스트를 보여준다
			} else {
				System.out.println("dao에러입니다");
			}
		}else {
			mav.setViewName("redirect:/listStock.do");
		}
		return mav;
	}
	@RequestMapping("/deleteOrders.do")
	public ModelAndView deleteOrders(int orderno) {
		ModelAndView mav = new ModelAndView();
		OrdersVo o = dao.selectALl(orderno); //구매한수량
		StockVo s = sdao.detail(o.getStockno()); //현재수량
		
		int sumqty = o.getOrderqty() + s.getQty();
		int re = dao.deleteOrders(orderno);
		if(re>0) {
			HashMap map = new HashMap();
			map.put("sumqty", sumqty);
			map.put("stockno", s.getStockno());
			sdao.updateqty(map);
			mav.setViewName("redirect:/listOrders.do?memberno="+ o.getMemberno());
		}
		return mav;
	}
}
