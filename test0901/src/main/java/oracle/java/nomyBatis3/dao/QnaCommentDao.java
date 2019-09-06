package oracle.java.nomyBatis3.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import oracle.java.nomyBatis3.model.QnaCommentVO;

public interface QnaCommentDao {

	//qna comment 목록 가져오기
	/*public List<QnaCommentVO> commentlist(Integer q_no, int start, int end);*/ 
	
	//해당 글에 대한 댓글 개수
	public int count(int q_no);
	public void create(QnaCommentVO commentvo) throws Exception;
	public void update(QnaCommentVO commentvo) throws Exception;
	public void delete(Integer comt_no) throws Exception;

	//댓글 상세 보기
	public QnaCommentVO detail(int comt_no)throws Exception;
	
	//댓글 리스트 출력
	public List<QnaCommentVO> getCommentList(int q_no, int start, int end);
}
