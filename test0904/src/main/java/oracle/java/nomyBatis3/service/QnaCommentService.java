package oracle.java.nomyBatis3.service;

import oracle.java.nomyBatis3.model.QnaCommentVO;

public interface QnaCommentService {

	
	//댓글 작성
	void create(QnaCommentVO commentvo) throws Exception;

}
