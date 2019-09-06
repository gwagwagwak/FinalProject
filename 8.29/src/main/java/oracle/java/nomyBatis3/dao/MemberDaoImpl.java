package oracle.java.nomyBatis3.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import oracle.java.nomyBatis3.model.MemberVO;

@Repository
public class MemberDaoImpl implements MemberDao{

	@Autowired
	private SqlSession session;
	
	
	public List<MemberVO> list(){
		return session.selectList("listAll");
	}


	@Override
	public int totalMember() {
		
		return session.selectOne("totalMember");
	}


	@Override
	public MemberVO selMember(String id) {
		
		return null;
	}


	@Override
	public int total() {
		
		return session.selectOne("total");
	}
	
	
}
