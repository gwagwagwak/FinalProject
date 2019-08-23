package com.paylog.project.model;

public class AutoPayVO {

	private int a_no;
	private String a_date;
	private int a_charge;
	private String a_target;
	private String a_currc;
	public int getA_no() {
		return a_no;
	}
	public void setA_no(int a_no) {
		this.a_no = a_no;
	}
	public String getA_date() {
		return a_date;
	}
	public void setA_date(String a_date) {
		this.a_date = a_date;
	}
	public int getA_charge() {
		return a_charge;
	}
	public void setA_charge(int a_charge) {
		this.a_charge = a_charge;
	}
	public String getA_target() {
		return a_target;
	}
	public void setA_target(String a_target) {
		this.a_target = a_target;
	}
	public String getA_currc() {
		return a_currc;
	}
	public void setA_currc(String a_currc) {
		this.a_currc = a_currc;
	}
	public AutoPayVO(int a_no, String a_date, int a_charge, String a_target, String a_currc) {
		super();
		this.a_no = a_no;
		this.a_date = a_date;
		this.a_charge = a_charge;
		this.a_target = a_target;
		this.a_currc = a_currc;
	}
	public AutoPayVO() {
		super();
	}
	@Override
	public String toString() {
		return "AutoPayVO [a_no=" + a_no + ", a_date=" + a_date + ", a_charge=" + a_charge + ", a_target=" + a_target
				+ ", a_currc=" + a_currc + "]";
	}
	
	
	
	
	
	
}
