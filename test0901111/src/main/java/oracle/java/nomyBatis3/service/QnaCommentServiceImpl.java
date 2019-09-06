package oracle.java.nomyBatis3.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oracle.java.nomyBatis3.dao.AutoPayDao;
import oracle.java.nomyBatis3.dao.CardDao;
import oracle.java.nomyBatis3.dao.MemberDao;
import oracle.java.nomyBatis3.dao.QnaCommentDao;
import oracle.java.nomyBatis3.dao.QnaDao;
import oracle.java.nomyBatis3.dao.QnaMainDao;
import oracle.java.nomyBatis3.model.QnaCommentVO;
@Service
public class QnaCommentServiceImpl implements QnaCommentService{
	
	
	@Autowired
	private QnaCommentDao qcdao;
	
	
	
	//qna 작성하기
	@Override
	public void create(QnaCommentVO commentvo) throws Exception {
		System.out.println("qnaservice 진입 성공");
		qcdao.create(commentvo); 
	}

	
	
	
	//qna 갯수 구하기
	@Override
	public int count(int q_no) {
		return qcdao.count(q_no);
	}
	
	//comment 목록 가져오기
	public List<QnaCommentVO> getCommentList(int q_no, int start, int end, HttpSession httpsession) {
		return qcdao.getCommentList(q_no, start, end);
	}
	

	
	
	
}
