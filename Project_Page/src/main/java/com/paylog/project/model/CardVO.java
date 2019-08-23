package com.paylog.project.model;

public class CardVO {

	
	
	private int c_number;
	private String c_type;
	private String c_expr;
	private int c_csc;
	private String c_address;
	public int getC_number() {
		return c_number;
	}
	public void setC_number(int c_number) {
		this.c_number = c_number;
	}
	public String getC_type() {
		return c_type;
	}
	public void setC_type(String c_type) {
		this.c_type = c_type;
	}
	public String getC_expr() {
		return c_expr;
	}
	public void setC_expr(String c_expr) {
		this.c_expr = c_expr;
	}
	public int getC_csc() {
		return c_csc;
	}
	public void setC_csc(int c_csc) {
		this.c_csc = c_csc;
	}
	public String getC_address() {
		return c_address;
	}
	public void setC_address(String c_address) {
		this.c_address = c_address;
	}
	public CardVO(int c_number, String c_type, String c_expr, int c_csc, String c_address) {
		super();
		this.c_number = c_number;
		this.c_type = c_type;
		this.c_expr = c_expr;
		this.c_csc = c_csc;
		this.c_address = c_address;
	}
	public CardVO() {
		super();
	}
	@Override
	public String toString() {
		return "CardVO [c_number=" + c_number + ", c_type=" + c_type + ", c_expr=" + c_expr + ", c_csc=" + c_csc
				+ ", c_address=" + c_address + "]";
	}
	
	
	
	
	
	
}
