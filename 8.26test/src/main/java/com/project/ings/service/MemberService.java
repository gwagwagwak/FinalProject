package com.project.ings.service;

import java.util.ArrayList;

import com.project.ings.model.MemberVO;

public interface MemberService {
	public ArrayList<MemberVO> getMemberList();
	public ArrayList<MemberVO> getNoramlMemberList();
	public ArrayList<MemberVO> getBusinessMemberList();
	
	public int getMemberCount();
	public void insertMember(MemberVO member);
	public MemberVO getMember(MemberVO member);
	public void updateMember(MemberVO member);
	public void deleteMember(MemberVO member);




}
