package com.project.ings.model;

public class QnaVO {

	
	private int q_no;
	private String q_title;
	private String q_content;
	private String q_date;
	private String q_complete;
	private String q_replytype;
	private String q_private;
	
	
	
	public int getQ_no() {
		return q_no;
	}
	public void setQ_no(int q_no) {
		this.q_no = q_no;
	}
	public String getQ_title() {
		return q_title;
	}
	public void setQ_title(String q_title) {
		this.q_title = q_title;
	}
	public String getQ_content() {
		return q_content;
	}
	public void setQ_content(String q_content) {
		this.q_content = q_content;
	}
	public String getQ_date() {
		return q_date;
	}
	public void setQ_date(String q_date) {
		this.q_date = q_date;
	}
	public String getQ_complete() {
		return q_complete;
	}
	public void setQ_complete(String q_complete) {
		this.q_complete = q_complete;
	}
	public String getQ_replytype() {
		return q_replytype;
	}
	public void setQ_replytype(String q_replytype) {
		this.q_replytype = q_replytype;
	}
	public String getQ_private() {
		return q_private;
	}
	public void setQ_private(String q_private) {
		this.q_private = q_private;
	}
	public QnaVO(int q_no, String q_title, String q_content, String q_date, String q_complete, String q_replytype,
			String q_private) {
		super();
		this.q_no = q_no;
		this.q_title = q_title;
		this.q_content = q_content;
		this.q_date = q_date;
		this.q_complete = q_complete;
		this.q_replytype = q_replytype;
		this.q_private = q_private;
	}
	public QnaVO() {
		super();
	}
	@Override
	public String toString() {
		return "QnaVO [q_no=" + q_no + ", q_title=" + q_title + ", q_content=" + q_content + ", q_date=" + q_date
				+ ", q_complete=" + q_complete + ", q_replytype=" + q_replytype + ", q_private=" + q_private + "]";
	}
	
	
	
	
	
	
	
	
}
