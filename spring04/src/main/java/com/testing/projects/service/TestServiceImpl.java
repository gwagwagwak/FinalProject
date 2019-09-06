package com.testing.projects.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testing.projects.dao.TestDAO;
import com.testing.projects.dto.TestVO;


@Service("testService")
public class TestServiceImpl implements TestService{

	
	@Autowired
	private TestDAOImpl dao; 
	
	@Override
	@Transactional
	public List<TestVO> selectBoardList() throws Exception {
		// TODO Auto-generated method stub
		return dao.selectBoardList();
	}

}
