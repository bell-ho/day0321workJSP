package com.example.demo.dao;


import org.springframework.stereotype.Repository;

import com.example.demo.db.DBManager;
import com.example.demo.vo.MemberVo;
@Repository
public class MemberDao {
	public MemberVo login(MemberVo vo){
		return DBManager.login(vo);
	}
	public int insert(MemberVo vo) {
		return DBManager.insert(vo);
	}
}
