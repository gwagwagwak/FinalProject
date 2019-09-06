package com.protest.resulting.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.protest.resulting.dto.TestmemberDTO;

@Repository
public class TestMemberDAOImpl implements TestMemberDAO{
	
	@Autowired
	SqlSession session;
	
	@Override
	public TestmemberDTO test() {
		// TODO Auto-generated method stub
		return null;
	}

}
