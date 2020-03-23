package com.example.demo.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.DBManager;
import com.example.demo.vo.StockVo;
@Repository
public class StockDao {
	public List<StockVo>listStock(){
		return DBManager.listStock();
	}
	public StockVo detail(int stockno) {
		return DBManager.detailStock(stockno);
	}
	public int insert(StockVo s) {
		return DBManager.insertStock(s);
	}
	public int delete(StockVo s) {
		return DBManager.deleteStock(s);
	}
	public int update(StockVo s) {
		return DBManager.updateStock(s);
	}
	public int updateqty(HashMap map) {
		return DBManager.updateQty(map);
	}
}
