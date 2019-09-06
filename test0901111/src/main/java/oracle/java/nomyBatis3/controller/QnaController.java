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
	

	// 상호파트
	@Autowired
	QnaService qservice;

	ModelAndView mv;


	// 회사 소개 페이지로 이동
	@RequestMapping(value = "companyIntroduce.do")
	public ModelAndView companyIntroduceHandle(Model model) throws Exception {
		mv = new ModelAndView();

		mv.setViewName("companyIntroduce");
		/* return "companyIntroduce"; */
		return mv;
	}

	// qna 전체 리스트 출력
	/* @RequestMapping(value = "getQnaList.do", method = RequestMethod.GET) */
	@RequestMapping(value = "getQnaList.do")
	public ModelAndView getlist(@RequestParam(defaultValue = "1") int curPage) throws Exception {

		int count = qservice.getTotalQnaCount(); // 전체 레코드 갯수

		Pager pager = new Pager(count, curPage);// 페이징 클래스

		int start = pager.getPageBegin();
		int end = pager.getPageEnd();

		System.out.println("토탈 카운트 생성 완료 & curpage : " + curPage + "& start : " + start + "  end : " + end);

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
	
	
	//관리자용 '답변미완료' qna리스트 출력
	@RequestMapping(value = "qnaReplyIncomplete.do", method = RequestMethod.GET)
	public ModelAndView qnaReplyIncompleteHandle(@RequestParam(defaultValue = "1") int curPage) throws Exception {
		int incomplete_count = qservice.getIncompleteQnaCount();
		Pager pager = new Pager(incomplete_count, curPage);// 페이징 클래스
		
		int start = pager.getPageBegin();
		int end = pager.getPageEnd();
		
		List<QnaVO> incomplete_qlist = qservice.getQnaIncompleteList(start, end);// 목록
		System.out.println("admin incomplete list목록 생성 완료");
		
		/*for(QnaVO list: incomplete_qlist) {
		    System.out.println(list.toString());
		    System.out.println("\n\n");
		}*/
		
		mv = new ModelAndView();
		mv.setViewName("qnaListIncomplete");
		
		Map<String, Object> map = new HashMap<>();
		map.put("incomplete_qlist", incomplete_qlist);
		map.put("incomplete_count", incomplete_count);
		map.put("pager", pager);
		
		mv.addObject("map", map); // 데이터 저장
		
		return mv;
	}

	
	//관리자용 '답변완료' qna리스트 출력
	@RequestMapping(value = "qnaReplyComplete.do", method = RequestMethod.GET)
	public ModelAndView qnaReplyCompleteHandle(@RequestParam(defaultValue = "1") int curPage) throws Exception {
		System.out.println("qna complete control 진입");
		int complete_count = qservice.getCompleteQnaCount();
		System.out.println("qna complete count 갯수 구하기 완료");
		Pager pager = new Pager(complete_count, curPage);// 페이징 클래스
		
		int start = pager.getPageBegin();
		int end = pager.getPageEnd();
		
		System.out.println(start+ "   " +end);
		List<QnaVO> complete_qlist = qservice.getQnaCompleteList(start, end);
		System.out.println("admin complete list목록 생성 완료");
		
		mv = new ModelAndView();
		mv.setViewName("qnaListComplete");
		
		Map<String, Object> map = new HashMap<>();
		map.put("complete_qlist", complete_qlist);
		map.put("complete_count", complete_count);
		map.put("pager", pager);
		
		mv.addObject("map", map); // 데이터 저장
		
		return mv;
	}
	

	// 작성 페이지로 이동만 한다.
	@RequestMapping(value = "qnaWritePage.do")
	public String qnaWritePageHandle() throws Exception {
		/*
		 * mv = new ModelAndView(); mv.setViewName("qnaWrite2");
		 */
		/* mv.setViewName("qnaWrite"); */
		return "qnaWrite";
	}

	// qna write 한다.
	// qna insert를 처리 -> 로그인 기능이 가능 할 때! httpsession으로 처리함!
	@RequestMapping(value = "qnaWrite.do", method = RequestMethod.POST)
	public String qnaWriteHandle(@ModelAttribute QnaVO qvo, HttpSession session) throws Exception {
		System.out.println("qnawrite진입");

		// 중요!!!!!!!!!!!!!!!
		// 만약 밑의 session값들이 로그인 처리가 되지 않았다면 받아올 수 없기 때문에
		// 방지하기 위해서 servlet-context.xml에서 로그인 인터셉터를 지정해줘야한다.

		// 로그인이 되어있어야만 한다.
		MemberVO loginmember = (MemberVO) session.getAttribute("loginMember");
		// 세션값으로 받아온 member객체의 이메일을 저장
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
		return "redirect:/getQnaList.do";
	}


	// 로그인 후 네비게이션바의 '카드' 항목 - > 회원의 카드 리스트와 카드 상세 내용 출력 페이지
	@RequestMapping(value = "qnaRead.do", method = RequestMethod.GET)
	public String qnaReadHandle() {
		return "qnaRead";
	}

	// 실습용 qnaview
	@RequestMapping(value = "qnaRead2.do", method = RequestMethod.GET)
	public ModelAndView qnaview(@RequestParam int q_no, @RequestParam int curPage, HttpSession session)
			throws Exception {
		System.out.println("qnaread2컨트롤러 접근");
		System.out.println("q_no" + q_no);
		System.out.println("curPage" + curPage);

		// 조회수 증가
		/* qservice.increaseViewCnt(q_no); */
		ModelAndView mv = new ModelAndView();

		/* mv.setViewName("qnaview"); */
		
		/*mv.setViewName("qnaRead2");*/
		
		mv.setViewName("qnaRead3");
		
		mv.addObject("qna", qservice.getQna(q_no));
		mv.addObject("curPage", curPage);
		System.out.println("qna 가져오기 완료");
		return mv;
	}

	// 업데이트 페이지 이동
	@RequestMapping(value = "qnaUpdatePage.do")
	public ModelAndView qnaUpdatePageHandle(@RequestParam int q_no, HttpSession httpsession) throws Exception {

		mv = new ModelAndView();
		mv.setViewName("qnaUpdate");
		QnaVO qna = qservice.getQna(q_no);

		System.out.println("qna이동 페이지 컨트롤 진입 성공");
		System.out.println(qna.toString());
		mv.addObject("qna", qna);

		return mv;
	}

	// 로그인 후 네비게이션바의 '카드' 항목 - > 회원의 카드 리스트와 카드 상세 내용 출력 페이지
	@RequestMapping(value = "qnaUpdate.do", method = RequestMethod.POST)
	public String qnaUpdateHandle(@ModelAttribute QnaVO qvo) throws Exception {

		System.out.println("qnaupdate 컨트롤러 진입");
		System.out.println(qvo.toString());
		qservice.updateQna(qvo);
		System.out.println("qna업데이트 완료");
		return "redirect:getQnaList.do";
	}

	@RequestMapping(value = "qnaDelete.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView qnaDeleteHandle(@RequestParam int q_no) throws Exception {

		System.out.println("qnadelete control 진입 성공 q_no : " + q_no);
		mv = new ModelAndView();
		mv.setViewName("redirect:getQnaList.do");
		qservice.deleteQna(q_no);
		System.out.println("qna삭제 완료");

		return mv;
	}

	// 로그인 후 네비게이션바의 '카드' 항목 - > 회원의 카드 리스트와 카드 상세 내용 출력 페이지
	@RequestMapping(value = "adminReplyRead.do", method = RequestMethod.GET)
	public String adminReplyReadHandle() {

		return "adminReplyRead";
	}
	

	// qna insert를 처리
	/*
	 * @RequestMapping(value = "qnaWrite.do") public ModelAndView
	 * qnaWriteHandle() { mv = new ModelAndView(); mv.setViewName("qnaWrite2");
	 * mv.setViewName("qnaWrite"); return mv; }
	 */
	

	// 테ㅔ스트용
	/*
	 * @RequestMapping(value = "companyIntroduce.do", method =
	 * RequestMethod.GET)
	 */

	// not use
	/*
	 * @RequestMapping(value = "qnaList.do") public ModelAndView
	 * qnalist1handle(Model model) throws Exception { mv = new ModelAndView();
	 * 
	 * mv.setViewName("qnaList"); return "companyIntroduce"; return mv; }
	 */

	/*
	 * @RequestMapping(value = "companyIntroduce.do", method =
	 * RequestMethod.GET)
	 */

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
}
