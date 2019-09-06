package oracle.java.nomyBatis3.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import oracle.java.nomyBatis3.DTO.LoginDTO;
import oracle.java.nomyBatis3.model.MemberVO;

@Repository
public class MemberDaoImpl implements MemberDao{

	private static final Logger logger = 
			LoggerFactory.getLogger(MemberDaoImpl.class);
	
	@Autowired
	private SqlSession session;
	
	
	//LoginDTO를 받아서 MemberVO를 리턴한다.
	@Override
	public MemberVO loginMember(LoginDTO logindto) throws Exception{
		System.out.println("dao진입");
		System.out.println(logindto.getM_email());
		System.out.println(logindto.getM_pw());
		
		
		return session.selectOne("member.loginMember", logindto);
	}
	

	//이메일 중복 확인
	@Override
	public int userIdCheck(String m_email) {
		// TODO Auto-generated method stub
		System.out.println("dao 세션 접근");
		return session.selectOne("member.userIdCheck", m_email);
	}

	//회원별 리스트 가져오기
	@Override
	public List<MemberVO> getMemberList() {
		
		return session.selectList("member.getMemberList");
	}
	@Override
	public List<MemberVO> getPersonalMemberList() {
		// TODO Auto-generated method stub
		return session.selectList("member.getPersonalMemberList");
	}
	@Override
	public List<MemberVO> getBusinessMemberList() {
		// TODO Auto-generated method stub
		return session.selectList("member.getBusinessMemberList");
	}
	
	@Override
	public List<MemberVO> getlistBusinessMemberList() {
		// TODO Auto-generated method stub
		return session.selectList("member.getlistBusinessMemberList");
	}

	@Override
	public List<MemberVO> getunlistBusinessMemberList() {
		// TODO Auto-generated method stub
		return session.selectList("member.getunlistBusinessMemberList");
	}


	

	
	
	
	
	
	@Override
	public void insertMember(MemberVO member) {
		//member안에 레코드 정보가 들어있다.
		session.insert("member.insertPersonalMember", member);
	}
	@Override
	public void insertBusinessMember(MemberVO member) {
		session.insert("member.insertBusinessMember", member);
		
	}

	
	

	@Override
	public MemberVO viewMember(String m_email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateMember(MemberVO member) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMember(String m_email) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean checkPw(String m_email, String pw) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
	
	
	
	@Override
	public int getMemberCount() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int getPersonalMemberCount() {
		// TODO Auto-generated method stub
		return session.selectOne("member.personalCount");
	}


	@Override
	public int getBusinessListMemberCount() {
		// TODO Auto-generated method stub
		return session.selectOne("member.listBusinessCount");
	}


	@Override
	public int getBusinessUnlistMemberCount() {
		// TODO Auto-generated method stub
		return session.selectOne("member.unlistBusinessCount");
	}



	
	

	
/*	
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
	*/
	
}
