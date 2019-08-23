package com.paylog.project.model;

public class QnaMainVO {

	
	private int qm_no;
	private String qm_email;
	private String qm_title;
	private String qm_content;
	
	
	public int getQm_no() {
		return qm_no;
	}
	public void setQm_no(int qm_no) {
		this.qm_no = qm_no;
	}
	public String getQm_email() {
		return qm_email;
	}
	public void setQm_email(String qm_email) {
		this.qm_email = qm_email;
	}
	public String getQm_title() {
		return qm_title;
	}
	public void setQm_title(String qm_title) {
		this.qm_title = qm_title;
	}
	public String getQm_content() {
		return qm_content;
	}
	public void setQm_content(String qm_content) {
		this.qm_content = qm_content;
	}
	public QnaMainVO(int qm_no, String qm_email, String qm_title, String qm_content) {
		super();
		this.qm_no = qm_no;
		this.qm_email = qm_email;
		this.qm_title = qm_title;
		this.qm_content = qm_content;
	}
	public QnaMainVO() {
		super();
	}
	@Override
	public String toString() {
		return "QnaMainVO [qm_no=" + qm_no + ", qm_email=" + qm_email + ", qm_title=" + qm_title + ", qm_content="
				+ qm_content + "]";
	}
	
	
	
	
	
}
