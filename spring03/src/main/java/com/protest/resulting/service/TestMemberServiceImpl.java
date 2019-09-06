package com.protest.resulting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.protest.resulting.dao.TestMemberDAO;
import com.protest.resulting.dto.TestmemberDTO;

@Service
public class TestMemberServiceImpl implements TestMemberService {

	@Autowired
	TestMemberDAO dao;
	
	@Override
	public TestmemberDTO test() {
		// TODO Auto-generated method stub
		return dao.test();
	}

}
