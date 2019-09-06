package com.project.ings.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.project.ings.dao.MemberDao;
import com.project.ings.model.MemberVO;


@Service("memberService")
public class MemberServiceImpl implements MemberService{

	/*@Resource(name="memberDAO")*/
	@AutoWired
	private MemberDao memberDAO;

//구현


	
	@Override
	public ArrayList<MemberVO> getMemberList() {
		
		return memberDAO.getMemberList();
	}

	@Override
	public ArrayList<MemberVO> getNoramlMemberList() {
		// TODO Auto-generated method stub
		return memberDAO.getNoramlMemberList();
	}

	@Override
	public ArrayList<MemberVO> getBusinessMemberList() {
		// TODO Auto-generated method stub
		return memberDAO.getBusinessMemberList();
	}

	@Override
	public int getMemberCount() {
		// TODO Auto-generated method stub
		return memberDAO.getMemberCount();
	}

	@Override
	public void insertMember(MemberVO member) {
		memberDAO.insertMember(member);
		
	}

	@Override
	public MemberVO getMember(MemberVO member) {
		// TODO Auto-generated method stub
		return memberDAO.getMember(member);
	}

	@Override
	public void updateMember(MemberVO member) {
		// TODO Auto-generated method stub
		memberDAO.updateMember(member);
	}

	@Override
	public void deleteMember(MemberVO member) {
		// TODO Auto-generated method stub
		memberDAO.deleteMember(member);
	}

}
