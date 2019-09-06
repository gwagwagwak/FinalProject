package oracle.java.nomyBatis3.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import oracle.java.nomyBatis3.model.QnaCommentVO;
@Repository
public class QnaCommentDaoImpl implements QnaCommentDao{
	@Autowired
	private SqlSession session;

	@Override
	public void create(QnaCommentVO commentvo) throws Exception {
		session.insert("qnacomment.insertcomment", commentvo);
		
	}

	@Override
	public List<QnaCommentVO> commentlist(Integer q_no, int start, int end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count(int q_no) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(QnaCommentVO commentvo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer comt_no) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public QnaCommentVO detail(int comt_no) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
