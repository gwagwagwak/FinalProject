package com.paylog.project.model;

public class QnaCommentVO {

	
	
	private int comt_no;
	private String comt_date;
	private String comt_content;
	private String comt_flag;
	public int getComt_no() {
		return comt_no;
	}
	public void setComt_no(int comt_no) {
		this.comt_no = comt_no;
	}
	public String getComt_date() {
		return comt_date;
	}
	public void setComt_date(String comt_date) {
		this.comt_date = comt_date;
	}
	public String getComt_content() {
		return comt_content;
	}
	public void setComt_content(String comt_content) {
		this.comt_content = comt_content;
	}
	public String getComt_flag() {
		return comt_flag;
	}
	public void setComt_flag(String comt_flag) {
		this.comt_flag = comt_flag;
	}
	public QnaCommentVO(int comt_no, String comt_date, String comt_content, String comt_flag) {
		super();
		this.comt_no = comt_no;
		this.comt_date = comt_date;
		this.comt_content = comt_content;
		this.comt_flag = comt_flag;
	}
	public QnaCommentVO() {
		super();
	}
	@Override
	public String toString() {
		return "QnaCommentVO [comt_no=" + comt_no + ", comt_date=" + comt_date + ", comt_content=" + comt_content
				+ ", comt_flag=" + comt_flag + "]";
	}

	
	
	
	
	
	
}
