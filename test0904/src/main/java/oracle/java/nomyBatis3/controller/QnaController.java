package oracle.java.nomyBatis3.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import oracle.java.nomyBatis3.model.MemberVO;
import oracle.java.nomyBatis3.model.QnaVO;
import oracle.java.nomyBatis3.service.AutoPayService;
import oracle.java.nomyBatis3.service.CardService;
import oracle.java.nomyBatis3.service.MemberService;
import oracle.java.nomyBatis3.service.Pager;
import oracle.java.nomyBatis3.service.PayListService;
import oracle.java.nomyBatis3.service.QnaCommentService;
import oracle.java.nomyBatis3.service.QnaMainService;
import oracle.java.nomyBatis3.service.QnaService;

@Controller
/* @RequestMapping("/qna/*") 공통적인 매핑 */
public class QnaController {
	/*
	 * @Autowired private MemberService ms;
	 * 
	 * @Autowired private AutoPayService as;
	 * 
	 * @Autowired private CardService cs;
	 * 
	 * @Autowired private PayListService ps;
	 * 
	 * @Autowired private QnaCommentService qcs;
	 * 
	 * @Autowired private QnaMainService qms;
	 */
	
	
	// 상호파트
	@Autowired
	QnaService qservice;

	ModelAndView mv;

	// 테ㅔ스트용
	/*
	 * @RequestMapping(value = "companyIntroduce.do", method =
	 * RequestMethod.GET)
	 */

	
	//not use
	@RequestMapping(value = "qnaList.do")
	public ModelAndView qnalist1handle(Model model) throws Exception {
		mv = new ModelAndView();

		mv.setViewName("qnaList");
		/* return "companyIntroduce"; */
		return mv;
	}

	

	/*
	 * @RequestMapping(value = "companyIntroduce.do", method =
	 * RequestMethod.GET)
	 */
	
	
	//회사 소개 페이지로 이동
	@RequestMapping(value = "companyIntroduce.do")
	public ModelAndView companyIntroduceHandle(Model model) throws Exception {
		mv = new ModelAndView();

		mv.setViewName("companyIntroduce");
		/* return "companyIntroduce"; */
		return mv;
	}

	
	
	//qna  전체 리스트 출력
	/* @RequestMapping(value = "getQnaList.do", method = RequestMethod.GET) */
	@RequestMapping(value = "getQnaList.do")
	public ModelAndView getlist(@RequestParam(defaultValue = "1") int curPage) throws Exception {
	
		int count = qservice.getTotalQnaCount(); // 전체 레코드 갯수
		
		Pager pager = new Pager(count, curPage);// 페이징 클래스

		int start = pager.getPageBegin();
		int end = pager.getPageEnd();

		System.out.println("토탈 카운트 생성 완료 & curpage : " + curPage +"& start : " +start +"  end : " +end);
		
		
		List<QnaVO> qlist = qservice.getQnaList(start, end); // 목록
		System.out.println("qnalist목록 생성 완료");
		
		mv = new ModelAndView();
		mv.setViewName("qnaList2");

		// 리스트의 데이터가 많아서 해쉬맵에 담는게 효율적이다.
		Map<String, Object> map = new HashMap<>();
		map.put("list", qlist);

		// model and view 이용해서 데이터 저장 및 전송
		/* mv.setViewName("getList"); */
		map.put("count", count);
		map.put("pager", pager);
		/*
		 * map.put("search_option", search_option); map.put("keyword", keyword);
		 */
		mv.addObject("map", map); // 데이터 저장

		return mv;
	}

	/*
	 * @RequestMapping(value = "getQnaList.do", method = RequestMethod.GET)
	 * public ModelAndView getlist() throws Exception { List<QnaVO> qlist =
	 * qservice.getQnaList(0, 0); // 목록 mv = new ModelAndView();
	 * 
	 * // 리스트의 데이터가 많아서 해쉬맵에 담는게 효율적이다. Map<String, Object> map = new
	 * HashMap<>(); map.put("list", qlist);
	 * 
	 * // model and view 이용해서 데이터 저장 및 전송 mv.setViewName("getList2");
	 * mv.setViewName("getList"); mv.addObject("map", map);
	 * 
	 * return mv; }
	 */

	// 작성 페이지로 이동만 한다.
	@RequestMapping(value = "qnaWritePage.do")
	public String qnaWritePageHandle() throws Exception {
		/*mv = new ModelAndView();
		mv.setViewName("qnaWrite2");*/
		/* mv.setViewName("qnaWrite"); */
		return "qnaWrite";
	}
	
	
	//qna write 한다.
	// qna insert를 처리 -> 로그인 기능이 가능 할 때! httpsession으로 처리함!
	@RequestMapping(value = "qnaWrite.do", method = RequestMethod.POST)
	public String qnaWriteHandle(@ModelAttribute QnaVO qvo, HttpSession session) throws Exception {
		System.out.println("qnawrite진입");
		
		// 중요!!!!!!!!!!!!!!!
		// 만약 밑의 session값들이 로그인 처리가 되지 않았다면 받아올 수 없기 때문에
		// 방지하기 위해서 servlet-context.xml에서 로그인 인터셉터를 지정해줘야한다.
		
		//로그인이 되어있어야만 한다.
		MemberVO loginmember = (MemberVO)session.getAttribute("loginMember"); 
		//세션값으로 받아온 member객체의 이메일을 저장
		String qnawriter = loginmember.getM_email();
		
		/*
		 * //인터셉트 처리를 하면 if문을 안 써도 된다. if(writer == null){ return
		 * "redirect:login.do"; }
		 */
		
		qvo.setQ_writer(qnawriter); // 로그인 한 사람의 아이디를 writer에 set
		System.out.println(qvo.toString());
		
		qservice.insertQna(qvo);
		
		System.out.println("qservice 처리 완료");
		/* mv.setViewName("qnaWrite"); */
		return "getQnaList.do";

	}

	// qna insert를 처리
	/*
	 * @RequestMapping(value = "qnaWrite.do") public ModelAndView
	 * qnaWriteHandle() { mv = new ModelAndView(); mv.setViewName("qnaWrite2");
	 * mv.setViewName("qnaWrite"); return mv; }
	 */

	// 로그인 후 네비게이션바의 '카드' 항목 - > 회원의 카드 리스트와 카드 상세 내용 출력 페이지
	@RequestMapping(value = "qnaRead.do", method = RequestMethod.GET)
	public String qnaReadHandle() {

		return "qnaRead";
	}
	
	//실습용 qnaview
	@RequestMapping(value = "qnaRead2.do", method = RequestMethod.GET)
	public ModelAndView qnaview(@RequestParam int q_no, @RequestParam int curPage, HttpSession session) throws Exception{
		System.out.println("qnaread2컨트롤러 접근");
		System.out.println("q_no" + q_no);
		System.out.println("curPage" + curPage);
		
		//조회수 증가
		/*qservice.increaseViewCnt(q_no);*/
		ModelAndView mv = new ModelAndView();
		
		/*mv.setViewName("qnaview");*/
		mv.setViewName("qnaRead2");
		mv.addObject("qna", qservice.getQna(q_no));
		mv.addObject("curPage", curPage);
		System.out.println("qna 가져오기 완료");
		return mv;
	}


	
	
	
	
	
	

	// 로그인 후 네비게이션바의 '카드' 항목 - > 회원의 카드 리스트와 카드 상세 내용 출력 페이지
	@RequestMapping(value = "qnaUpdate.do", method = RequestMethod.GET)
	public String qnaUpdateHandle() {

		return "qnaUpdate";
	}
	
	@RequestMapping(value = "qnaDelete.do", method = RequestMethod.GET)
	public String qnaDeleteHandle() {

		return "qnaDelete";
	}

	
	
	// 로그인 후 네비게이션바의 '카드' 항목 - > 회원의 카드 리스트와 카드 상세 내용 출력 페이지
	@RequestMapping(value = "adminReplyRead.do", method = RequestMethod.GET)
	public String adminReplyReadHandle() {

		return "adminReplyRead";
	}

	// 로그인 후 네비게이션바의 '카드' 항목 - > 회원의 카드 리스트와 카드 상세 내용 출력 페이지
	@RequestMapping(value = "qnaReplyIncomplete.do", method = RequestMethod.GET)
	public String qnaReplyIncompleteHandle() {

		return "qnaReplyIncomplete";
	}

	// 로그인 후 네비게이션바의 '카드' 항목 - > 회원의 카드 리스트와 카드 상세 내용 출력 페이지
	@RequestMapping(value = "qnaReplyComplete.do", method = RequestMethod.GET)
	public String qnaReplyCompleteHandle() {

		return "qnaReplyComplete";
	}

}
