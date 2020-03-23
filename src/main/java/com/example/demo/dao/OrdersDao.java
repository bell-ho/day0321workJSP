package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.DBManager;
import com.example.demo.vo.OrdersVo;

@Repository
public class OrdersDao {
	public List<OrdersVo>listOrders(int memberno){
		return DBManager.listOrders(memberno);
	}
	public int insertOrders(OrdersVo vo) {
		return DBManager.insert(vo);
	}
	public OrdersVo selectALl(int stockno) {
		return DBManager.selectAll(stockno);
	}
	public int deleteOrders(int orderno) {
		return DBManager.deleteOrders(orderno);
	}
}
