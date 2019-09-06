package oracle.java.nomyBatis3.dao;

import java.util.List;

import oracle.java.nomyBatis3.model.MemberVO;

public interface MemberDao {

	
	List<MemberVO> list();
	
	int total();

	MemberVO selMember(String id);

	int totalMember();
	
}
