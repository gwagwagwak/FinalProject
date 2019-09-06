package com.testing.projects.dao;

import java.util.List;

import com.testing.projects.dto.TestVO;

public interface TestDAO {
	List<TestVO> selectBoardList() throws Exception;

	
}
