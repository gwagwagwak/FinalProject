package com.paylog.project.model;

public class PayListVO {

	private int p_no;
	private String p_target;
	private String p_date;
	private int p_charge;
	private String p_currc;
	private String p_type;
	private String c_number;
	public int getP_no() {
		return p_no;
	}
	public void setP_no(int p_no) {
		this.p_no = p_no;
	}
	public String getP_target() {
		return p_target;
	}
	public void setP_target(String p_target) {
		this.p_target = p_target;
	}
	public String getP_date() {
		return p_date;
	}
	public void setP_date(String p_date) {
		this.p_date = p_date;
	}
	public int getP_charge() {
		return p_charge;
	}
	public void setP_charge(int p_charge) {
		this.p_charge = p_charge;
	}
	public String getP_currc() {
		return p_currc;
	}
	public void setP_currc(String p_currc) {
		this.p_currc = p_currc;
	}
	public String getP_type() {
		return p_type;
	}
	public void setP_type(String p_type) {
		this.p_type = p_type;
	}
	public String getC_number() {
		return c_number;
	}
	public void setC_number(String c_number) {
		this.c_number = c_number;
	}
	public PayListVO(int p_no, String p_target, String p_date, int p_charge, String p_currc, String p_type,
			String c_number) {
		super();
		this.p_no = p_no;
		this.p_target = p_target;
		this.p_date = p_date;
		this.p_charge = p_charge;
		this.p_currc = p_currc;
		this.p_type = p_type;
		this.c_number = c_number;
	}
	public PayListVO() {
		super();
	}
	
	
	
	
	
}
