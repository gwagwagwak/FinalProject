package oracle.java.nomyBatis3.controller;

import java.util.Date;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import oracle.java.nomyBatis3.model.MemberVO;
import oracle.java.nomyBatis3.model.QnaCommentVO;
import oracle.java.nomyBatis3.service.AutoPayService;
import oracle.java.nomyBatis3.service.CardService;
import oracle.java.nomyBatis3.service.MemberService;
import oracle.java.nomyBatis3.service.PayListService;
import oracle.java.nomyBatis3.service.QnaCommentService;
import oracle.java.nomyBatis3.service.QnaMainService;
import oracle.java.nomyBatis3.service.QnaService;

@Controller
public class QnaCommentController {

	@Inject
	private QnaCommentService qcservice;
	
	@RequestMapping("commentInsert.do")
	public void commentInsert(QnaCommentVO commentvo, HttpSession httpsession) throws Exception{
		//로그인을했을 경우 멤버 객체를 세션값으로 받아온다.
		MemberVO loginmember =(MemberVO)httpsession.getAttribute("loginMember");
		String member_email = loginmember.getM_email();
		
		//접속중인 멤버 아이디를 댓글 작성자 아이디에 등록
		commentvo.setComt_writer(member_email);		//아이디 셋팅 
		qcservice.create(commentvo);
		
	}
	
	/*
	 * 
	 * 
	 * 
	private int comt_no;			//댓글 번호  (시퀀스, 기본 키)
	private String comt_writer;		//댓글 작성자 (외래키 : member.m_email)
	private String comt_content;	//댓글 내용
	private Date comt_date;			//댓글 작성일
	private String comt_flag;		//댓글 삭제 여부
	private int comt_textid;		/
	 * 
	 * 
	 */
	
	
	
}
