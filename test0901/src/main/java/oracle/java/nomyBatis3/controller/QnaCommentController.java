package oracle.java.nomyBatis3.controller;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import oracle.java.nomyBatis3.model.MemberVO;
import oracle.java.nomyBatis3.model.QnaCommentVO;
import oracle.java.nomyBatis3.service.AutoPayService;
import oracle.java.nomyBatis3.service.CardService;
import oracle.java.nomyBatis3.service.MemberService;
import oracle.java.nomyBatis3.service.Pager;
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
		
		System.out.println(commentvo.toString());
		qcservice.create(commentvo);
		System.out.println("댓글 등록 완성");
		
		/*return "redirect:/qnaRead2.do:";*/
		/*return "redirect:getQnaList.do";*/
	}
	
	
	//댓글 리스트 가져오기
	@RequestMapping("getCommentList.do")
	public ModelAndView getCommentList(int q_no, @RequestParam(defaultValue="1") int curPage,
			ModelAndView mv, HttpSession httpsession){
		
		//qnacomment 갯수 가져오기
		int comment_count = qcservice.count(q_no);
		System.out.println("댓글 개수 : " +comment_count  );
		
		Pager pager = new Pager(comment_count, curPage);
		int start = pager.getPageBegin();
		int end = pager.getPageEnd();
		
		List<QnaCommentVO> commentlist = qcservice.getCommentList(q_no, start, end, httpsession);
		System.out.println("댓글 목록가져오기 완료");
		System.out.println(commentlist.toString());
		
		mv.setViewName("qna_commentlist");
		mv.addObject("commentlist", commentlist);
		mv.addObject("pager", pager);
		return mv;
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
