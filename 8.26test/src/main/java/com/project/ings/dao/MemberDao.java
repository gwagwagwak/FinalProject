package com.project.ings.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.project.ings.model.MemberVO;

@Repository("memberDAO")
public interface MemberDao {
	public ArrayList<MemberVO> getMemberList();

	public ArrayList<MemberVO> getNoramlMemberList();

	public ArrayList<MemberVO> getBusinessMemberList();

	public int getMemberCount();

	public void insertMember(MemberVO member);

	public MemberVO getMember(MemberVO member);

	public void updateMember(MemberVO member);

	public void deleteMember(MemberVO member);

}
