package com.example.demo.db;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;

import javax.websocket.Session;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.MemberVo;
import com.example.demo.vo.OrdersVo;
import com.example.demo.vo.StockVo;

public class DBManager {

	private static SqlSessionFactory factory;
	static {
		try {
			Reader reader = Resources.getResourceAsReader("com/example/demo/db/sqlMapConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
//	=====================여기부터 member=====================여기부터 member=====================
	public static MemberVo login(MemberVo vo){
		SqlSession session = factory.openSession();
		MemberVo m= session.selectOne("member.select",vo);
		session.close();
		return m;
	}
	public static int insert(MemberVo vo) {
		int re= -1;
		SqlSession session = factory.openSession(true);
		re = session.insert("member.insert",vo);
		session.close();
		return re;
	}
	
	
//	=====================여기부터 stock======================여기부터 stock======================
	public static List<StockVo>listStock(){
		SqlSession session = factory.openSession();
		List<StockVo>list = session.selectList("stock.select");
		session.close();
		return list;
	}
	public static StockVo detailStock(int stockno) {
		SqlSession session = factory.openSession();
		StockVo s = session.selectOne("stock.detail",stockno);
		session.close();
		System.out.println(s);
		return s;
	}
	public static int insertStock(StockVo s) {
		int re= -1;
		SqlSession session = factory.openSession(true);
		re = session.insert("stock.insert",s);
		session.close();
		return re;
	}
	public static int deleteStock(StockVo s) {
		int re= -1;
		SqlSession session = factory.openSession(true);
		re = session.insert("stock.delete",s);
		session.close();
		return re;
	}
	public static int updateStock(StockVo s) {
		int re= -1;
		SqlSession session = factory.openSession(true);
		re = session.update("stock.update",s);
		session.close();
		return re;
	}
	public static int updateQty(HashMap map) {
		int re = -1;
		SqlSession session = factory.openSession(true);
		re = session.update("stock.updateqty",map);
		session.close();
		return re;
	}
//	=====================여기부터 orders======================여기부터 orders======================
	public static List<OrdersVo>listOrders(int memberno){
		SqlSession session =factory.openSession();
		List<OrdersVo>list= session.selectList("orders.list",memberno);
		return list;
	}
	public static int insert(OrdersVo vo) {
		int re= -1;
		SqlSession session =factory.openSession(true);
		re = session.insert("orders.insert",vo);
		return re;
	}
	public static  OrdersVo selectAll(int stockno) {
		int re= -1;
		SqlSession session = factory.openSession(true);
		OrdersVo o = session.selectOne("orders.selectAll",stockno);
		return o;
	}
	public static int deleteOrders(int orderno) {
		int re = -1;
		SqlSession session = factory.openSession(true);
		re = session.delete("orders.delete",orderno);
		return re;
	}
}
