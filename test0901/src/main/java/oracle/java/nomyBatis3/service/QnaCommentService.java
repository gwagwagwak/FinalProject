package oracle.java.nomyBatis3.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import oracle.java.nomyBatis3.model.QnaCommentVO;

public interface QnaCommentService {

	
	//댓글 작성
	void create(QnaCommentVO commentvo) throws Exception;

	int count(int q_no);

	List<QnaCommentVO> getCommentList(int q_no, int start, int end, HttpSession httpsession);

}
