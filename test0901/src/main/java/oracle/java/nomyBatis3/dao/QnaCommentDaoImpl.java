package oracle.java.nomyBatis3.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

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
		System.out.println("qnacomment dao 진입 성공");
		session.insert("qnacomment.insertcomment", commentvo);
		
	}
	//qnalist가져오기
	@Override
	public List<QnaCommentVO> getCommentList(int q_no, int start, int end) {
		
		Map<String, Object> map = new HashMap<>();
		map.put("start", start);
		map.put("end", end);
		map.put("q_no", q_no);
		
		return session.selectList("qnacomment.getCommentList", map);
	}
/*
	@Override
	public List<QnaCommentVO> commentlist(Integer q_no, int start, int end) {
		// TODO Auto-generated method stub
		return null;
	}
*/
	@Override
	public int count(int q_no) {
		// TODO Auto-generated method stub
		return session.selectOne("qnacomment.count", q_no);
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
