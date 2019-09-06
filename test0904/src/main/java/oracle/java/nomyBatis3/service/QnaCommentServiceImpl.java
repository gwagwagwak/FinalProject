package oracle.java.nomyBatis3.service;

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

	@Override
	public void create(QnaCommentVO commentvo) throws Exception {
		qcdao.create(commentvo); 
		
	}
	
	
	
}
