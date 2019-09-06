package com.project.ings.model;

public class MemberVO {

	private String m_email;		//회원 이메일 : 기본키
	private String m_pw;
	private String m_fname;
	private String m_lname;
	private String m_hp;
	private String m_addr;
	private String m_joindate;
	private String m_nation;
	private String secu;		//회원 보안 질문
	private String asw;			//회원 보안 질문 답
	private int m_type;
	private String b_type;		//비지니스 회원 유형
	private String b_number;	//비지니스 회원 사업자 등록 번호
	
	
	
	public String getM_id() {
		return m_email;
	}
	public void setM_id(String m_email) {
		this.m_email = m_email;
	}
	public String getM_pw() {
		return m_pw;
	}
	public void setM_pw(String m_pw) {
		this.m_pw = m_pw;
	}
	public String getM_fname() {
		return m_fname;
	}
	public void setM_fname(String m_fname) {
		this.m_fname = m_fname;
	}
	public String getM_lname() {
		return m_lname;
	}
	public void setM_lname(String m_lname) {
		this.m_lname = m_lname;
	}
	public String getM_hp() {
		return m_hp;
	}
	public void setM_hp(String m_hp) {
		this.m_hp = m_hp;
	}
	public String getM_addr() {
		return m_addr;
	}
	public void setM_addr(String m_addr) {
		this.m_addr = m_addr;
	}
	public String getM_date() {
		return m_joindate;
	}
	public void setM_date(String m_joindate) {
		this.m_joindate = m_joindate;
	}
	public String getM_nation() {
		return m_nation;
	}
	public void setM_nation(String m_nation) {
		this.m_nation = m_nation;
	}
	public String getSecu() {
		return secu;
	}
	public void setSecu(String secu) {
		this.secu = secu;
	}
	public String getAsw() {
		return asw;
	}
	public void setAsw(String asw) {
		this.asw = asw;
	}
	public int getM_type() {
		return m_type;
	}
	public void setM_type(int m_type) {
		this.m_type = m_type;
	}
	public String getB_type() {
		return b_type;
	}
	public void setB_type(String b_type) {
		this.b_type = b_type;
	}
	public String getB_number() {
		return b_number;
	}
	public void setB_number(String b_number) {
		this.b_number = b_number;
	}
	public MemberVO(String m_email, String m_pw, String m_fname, String m_lname, String m_hp, String m_addr, String m_joindate,
			String m_nation, String secu, String asw, int m_type, String b_type, String b_number) {
		super();
		this.m_email = m_email;
		this.m_pw = m_pw;
		this.m_fname = m_fname;
		this.m_lname = m_lname;
		this.m_hp = m_hp;
		this.m_addr = m_addr;
		this.m_joindate = m_joindate;
		this.m_nation = m_nation;
		this.secu = secu;
		this.asw = asw;
		this.m_type = m_type;
		this.b_type = b_type;
		this.b_number = b_number;
	}
	public MemberVO() {
		super();
	}
	
	
	
	
	
	
	
}
