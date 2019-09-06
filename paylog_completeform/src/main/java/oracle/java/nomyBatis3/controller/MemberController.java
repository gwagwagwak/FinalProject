package oracle.java.nomyBatis3.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import oracle.java.nomyBatis3.DTO.LoginDTO;
import oracle.java.nomyBatis3.DTO.ResponseDTO;
import oracle.java.nomyBatis3.dao.MemberDaoImpl;
import oracle.java.nomyBatis3.interceptor.SessionNames;
import oracle.java.nomyBatis3.model.MemberVO;
import oracle.java.nomyBatis3.service.AutoPayService;
import oracle.java.nomyBatis3.service.CardService;
import oracle.java.nomyBatis3.service.MemberService;
import oracle.java.nomyBatis3.service.PayListService;
import oracle.java.nomyBatis3.service.QnaCommentService;
import oracle.java.nomyBatis3.service.QnaMainService;
import oracle.java.nomyBatis3.service.QnaService;

@Controller
/* @SessionAttributes("loginMember") */
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberDaoImpl.class);
	@Inject
	MemberService mservice;

	ModelAndView mv;

	// 메인페이지 이동
	@RequestMapping(value = "main.do")
	public String main(Model model) throws Exception {
		System.out.println("11111111111111111111111");
		return "main";
	}

	
	// 회원 목록 페이지 처리
	@RequestMapping(value = "getMemberList.do")
	public String getMemberList(Model model) throws Exception {
		List<MemberVO> list = mservice.getMemberList();
		logger.info("회원목록 : " + list);
		model.addAttribute("list", list);
		return "member/memberList"; // 회원 목록 페이지로 이동
	}
	

	// 로그인 실제 처리
	@RequestMapping(value = "loginPost.do", method = RequestMethod.POST)
	public void loginPost(@ModelAttribute LoginDTO logindto, Model model) throws Exception {
		logger.info("loginPost={}", logindto);

		try {
			MemberVO member = mservice.loginMember(logindto);
			if (member != null) { // login success
				model.addAttribute("member", member);
				model.addAttribute("loginResult", member.getM_fname() + member.getM_lname());
			} else { // login fail
				/* model.addAttribute("loginResult", "Login Fail!"); */
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 로그인 성공시 이동 위치 (@CookieValue(value = "쿠키이름", defaultValue =
	// "oraclejavacommunity")
	@RequestMapping(value = "loginSuccess.do")
	public String loginSuccess(Model model, HttpSession httpsession) throws Exception {
		MemberVO loginmember = (MemberVO) httpsession.getAttribute("loginMember");

		if (loginmember.getM_type() == 1) // 관리자 ->관리자페이지로이동
			return "memberMain";
		else if (loginmember.getM_type() == 2)// 일반 회원
			return "memberMain";
		else if (loginmember.getM_type() == 3)// 비지니스 회원
			return "businessMain";

		// 기본적으로 일반회원 메인으로 ㄱㄱ
		return "memberMain";
	}

	// 로그인 실페시 이동 위치
	@RequestMapping(value = "loginFail.do")
	public String loginFail(Model model) throws Exception {
		model.addAttribute("loginResult", "Login Fail!");
		return "loginForm";
	}

	// 로그아웃 처리 -세션값 삭제, 쿠키값 삭제
	@RequestMapping(value = "logout.do")
	public ModelAndView logout(HttpSession httpsession, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("로그아웃컨트롤진입");
		logger.info("login Get...");
		httpsession.removeAttribute(SessionNames.LOGIN);// LOGIN으로 담아온 세션을 날려버림
		httpsession.invalidate(); // 세션의 로그인시간 여러 기록을 지움

		ModelAndView mv = new ModelAndView();

		// SessionNames.LOGIN_COOKIE 으로 만들어논 이름의 쿠키를 가져온다.
		/*
		 * Cookie loginCookie = WebUtils.getCookie(request, SessionNames.LOGIN);
		 */
		Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");

		if (loginCookie != null) {
			// 브라우저에서 쿠키를 지울 수 없으므로 할당된 시간을 지금까지로 한정해서 쿠키를 없애버린다.
			System.out.println("쿠케제거 완료로 이동");
			loginCookie.setPath("/");
			loginCookie.setMaxAge(0);
			response.addCookie(loginCookie);
		}
		// 로그아웃시 로그인 폼으로 이동
		/* return "main"; */

		// 리멤버 쿠키 처리
		Cookie rememberCookie = WebUtils.getCookie(request, "rememberCookie");
		if (rememberCookie != null) {
			mv.addObject("rememberCookie", rememberCookie);
			System.out.println("리멤버 쿠키 저장 완료");
		}
		mv.setViewName("loginForm");

		return mv;
	}
	

	// 회사 소개 페이지로 이동
	@RequestMapping(value = "companyIntroduce.do")
	public ModelAndView companyIntroduceHandle(Model model) throws Exception {
		mv = new ModelAndView();

		mv.setViewName("member/companyIntroduce");
		/* return "companyIntroduce"; */
		return mv;
	}

	// 비밀번호 찾기 페이지로 이동
	@RequestMapping(value = "find_psw.do")
	public String findPWHandle(Model model) throws Exception {
		return "member/find_psw";
	}

	// 로그인 페이지로 이동
	@RequestMapping(value = "loginForm.do")
	public String loginForm(Model model) throws Exception {
		return "loginForm";
	}

	// 회원가입 회원 선택 페이지로 이동
	@RequestMapping(value = "join_first.do")
	public String join_first(Model model) throws Exception {
		System.out.println("11111111111111111111111");
		/* return "member/join_first"; */
		return "member/join_first";
	}

	// 일반 회원가입 페이지로 이동
	@RequestMapping(value = "registerForm_03_p.do")
	public String registerForm_03_p(Model model) throws Exception {
		return "member/registerForm_03_p";
	}

	// 기업 회원가입 페이지로 이동
	@RequestMapping(value = "registerForm_03_b.do")
	public String registerForm_03_b(Model model) throws Exception {
		return "member/registerForm_03_b";
	}

	// 고객센터로 이동
	@RequestMapping(value = "serviceCenter.do")
	public String serviceCenter(Model model) throws Exception {
		return "serviceCenter";
	}

	// 이용방법페이지로 이동
	@RequestMapping(value = "privacy.do")
	public String Privacy(Model model) throws Exception {
		return "member/footer_privacy";
	}

	// 회원가입 조건 페이지로 이동
	@RequestMapping(value = "Form_conditions.do")
	public String form_conditions(Model model) throws Exception {
		return "member/Form_conditions";
	}


	// 비지니스 회원 리스트
	@RequestMapping(value = "getBusinessMemberList.do")
	public String getBusinessMemberList(Model model) throws Exception {
		List<MemberVO> list = mservice.getBusinessMemberList();
		logger.info("회원목록 : " + list);
		model.addAttribute("list", list);
		return "member/p_memberList"; // 회원 목록 페이지로 이동
	}

	// 일반 회원 리스트
	@RequestMapping(value = "getPersonalMemberList.do")
	public String getPersonalMemberList(Model model) throws Exception {
		List<MemberVO> list = mservice.getPersonalMemberList();
		logger.info("회원목록 : " + list);
		model.addAttribute("list", list);
		return "member/b_memberList"; // 회원 목록 페이지로 이동
	}


	// 디자인 회원 리스트
	// 회원별 리스트 구분 페이지 이동
	@RequestMapping(value = "membertypelist.do")
	public String membertypelist(Model model) throws Exception {
		return "member/membertypelist";
	}

	// personal memberlist
	@RequestMapping(value = "personalMemberList.do")
	public String personalMember(Model model) throws Exception {
		List<MemberVO> list = mservice.getPersonalMemberList();
		int count = mservice.getPersonalMemberCount();
		
		System.out.println("일반 회원 리스트 받아오기 완료 그리고 일반 회원 수 : " +count);
		logger.info("회원목록 : " + list);
		model.addAttribute("list", list);
		model.addAttribute("count", count);
		return "member/personalMemberList";
	}

	// list business memberlist (상장)
	@RequestMapping(value = "listBusinessMemberList.do")
	public String listBusinessMember(Model model) throws Exception {

		List<MemberVO> list = mservice.getlistBusinessMemberList();
		int count = mservice.getBusinessListMemberCount();
		System.out.println("상장 회원 리스트 받아오기 완료 그리고 일반 회원 수 : " +count);
		logger.info("회원목록 : " + list);
		
		model.addAttribute("list", list);
		model.addAttribute("count", count);
		
		
		return "member/listBusinessMemberList";
	}
	// unlist business memberlist (비상장)
	@RequestMapping(value = "unlistBusinessMemberList.do")
	public String unlistBusinessMember(Model model) throws Exception {
		
		List<MemberVO> list = mservice.getlistBusinessMemberList();
		int count = mservice.getBusinessUnlistMemberCount();
		System.out.println("비상장 회원 리스트 받아오기 완료 그리고 일반 회원 수 : " +count);
		logger.info("회원목록 : " + list);
		
		model.addAttribute("list", list);
		model.addAttribute("count", count);
		
		
		return "member/unlistBusinessMemberList";
	}

	// 일반 회원 가입
	@RequestMapping(value = "memberInsert.do", method = RequestMethod.POST)
	public String insertPersonalMember(@ModelAttribute MemberVO member, HttpServletRequest request) throws Exception {
		System.out.println(
				member.getM_email() + "\n" + member.getM_fname() + "\n" + member.getM_pw() + "\n" + member.getM_addr());

		// 주소 연결
		String addr1 = request.getParameter("m_addr");
		String addr2 = request.getParameter("m_addr2");
		member.setM_addr(addr1 + " " + addr2);

		mservice.insertMember(member);
		return "redirect:/loginForm.do";

	}

	// 기업 회원 가입 (일단 겟이엇음)
	@RequestMapping(value = "memberBusinessInsert.do", method = RequestMethod.POST)
	public String insertbusinessMember(@ModelAttribute MemberVO member, HttpServletRequest request) throws Exception {
		System.out.println(
				member.getM_email() + "\n" + member.getM_fname() + "\n" + member.getM_pw() + "\n" + member.getM_addr());

		// 주소 연결
		String addr1 = request.getParameter("m_addr");
		String addr2 = request.getParameter("m_addr2");
		member.setM_addr(addr1 + " " + addr2);

		mservice.insertMember(member);
		System.out.println("기업회원 가입 처리 완료 ");

		return "redirect:/loginForm.do";
	}

	// 회원가입시 아이디 중복 체크
	@ResponseBody
	@RequestMapping(value = "idCheck.do", method = RequestMethod.GET)
	public int idCheck(@RequestParam("m_email") String m_email) throws Exception {
		System.out.println("dmdkdkdkdkjfas;ldfjalsk;dfjlask;djflaksdfj");
		System.out.println(m_email);

		int result = mservice.userIdCheck(m_email);
		System.out.println("resutlt : " + result);
		/* return mservice.userIdCheck(m_email); */
		return result;
	}

	// 값 들어갔는지 확인
	@ResponseBody
	@RequestMapping(value = "emailputcheck.do", method = RequestMethod.POST)
	public int emailputcheck(String m_email) throws Exception {

		return 1;
	}

	// 로그인 - 일단 실패한 로그인 처리
	/*
	 * @RequestMapping(value="memberLogin.do") public String
	 * loginHandle(MemberVO member, Model model, HttpSession httpsession){
	 * 
	 * MemberVO result = mservice.loginMember(member);
	 * 
	 * if(result == null){ model.addAttribute("message", "ID나 PW가 일치하지 않습니다.");
	 * return "login"; }else{ httpsession.setAttribute("loginID",
	 * result.getM_email());
	 * 
	 * return "redirect:main.do"; return "main.do"; } }
	 */

	// 로그인 실제 처리2
	/*
	 * @RequestMapping(value = "loginPost.do", method = RequestMethod.POST)
	 * public String loginPost(@ModelAttribute LoginDTO logindto, Model model)
	 * throws Exception { logger.info("loginPost={}", logindto);
	 * 
	 * try { MemberVO member = mservice.loginMember(logindto); if (member !=
	 * null) { // login success model.addAttribute("member", member); //로그인 성공시
	 * 멤버 객체를 저장한뒤 인터셉터의 posthandle에서 사용한다. model.addAttribute("loginResult",
	 * member.getM_fname() + member.getM_lname()); return "memberMain"; } else {
	 * // login fail model.addAttribute("loginResult", "Login Fail!"); } } catch
	 * (Exception e) { e.printStackTrace(); } return "redirect:/loginForm.do";
	 * return "loginForm"; }
	 */

	/*
	 * @RequestMapping(value="listMember") public String listMember(MemberDao
	 * mdao,Model model,String currentPage){
	 * 
	 * 
	 * int total=ms.total(); System.out.println("controller_01");
	 * 
	 * * //model.addAttribute("list",listMember(null, null));
	 * System.out.println("controller_02"); return "listMember";
	 * 
	 * }
	 */
}
