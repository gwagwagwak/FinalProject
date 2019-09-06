package com.testing.projects.service;

import java.util.List;

import com.testing.projects.dto.TestVO;

public interface TestService {
	List<TestVO> selectBoardList() throws Exception;


}
