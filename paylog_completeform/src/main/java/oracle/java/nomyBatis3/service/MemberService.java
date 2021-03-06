package oracle.java.nomyBatis3.service;

import java.util.List;

import oracle.java.nomyBatis3.DTO.LoginDTO;
import oracle.java.nomyBatis3.model.MemberVO;

public interface MemberService {

	// 회원 리스트 가져오기
	public List<MemberVO> getMemberList();

	// 일반 회원 리스트 가져오기
	public List<MemberVO> getPersonalMemberList();

	// 비지니스 회원 리스트 가져오기
	public List<MemberVO> getBusinessMemberList();
	
	// 상장 비지니스 회원 리스트 가져오기
	public List<MemberVO> getunlistBusinessMemberList();
	
	// 상장 비지니스 회원 리스트 가져오기
	public List<MemberVO> getlistBusinessMemberList();
	
	// 일반회원 가입
	public void insertMember(MemberVO member);

	// 비지니스 회원 가입
	public void insertBusinessMember(MemberVO member);

	// 회원 정보 보기
	public MemberVO viewMember(String m_email);

	// 회원 업데이트
	public void updateMember(MemberVO member);

	// 회원 삭제
	public void deleteMember(String m_email);

	// 회원 비밀번호 체크
	public boolean checkPw(String m_email, String pw);

	// 회원 수 구하기
	public int getMemberCount();

	// personal 회원 수 구하기
	public int getPersonalMemberCount();

	// 비지니스 상장 회원 수 구하기
	public int getBusinessListMemberCount();

	// 비지니스 비상장 회원 수 구하기
	public int getBusinessUnlistMemberCount();

	// 회원 로그인 처리
	public MemberVO loginMember(LoginDTO logindto) throws Exception;

	// 회원가입시 이메일 중복 처리
	public int userIdCheck(String m_email);

}
