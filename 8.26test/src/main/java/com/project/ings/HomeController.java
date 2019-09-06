package com.project.ings;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */

	/*
	 * @RequestMapping(value = "/", method = RequestMethod.GET) public String
	 * home(Locale locale, Model model) {
	 * logger.info("Welcome home! The client locale is {}.", locale);
	 * 
	 * Date date = new Date(); DateFormat dateFormat =
	 * DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
	 * 
	 * String formattedDate = dateFormat.format(date);
	 * 
	 * model.addAttribute("serverTime", formattedDate );
	 * 
	 * return "home"; }
	 * 
	 */

	// 김민정 파트 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//페이지의 메인 (로그인 전 페이지)
	@RequestMapping(value = "/main.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "index";
	}
	
	
	//로그인 후  '활동내역'란의 카드 내역 리스트
	@RequestMapping(value = "paylist.do", method = RequestMethod.GET)
	public String paylistHandle() {

		return "paylist";
	}

	//로그인 후  '활동내역'란의 내가 쓴 qna 리스트
	@RequestMapping(value = "payWorking.do", method = RequestMethod.GET)
	public String payWorkingHandle() {

		return "payWorking";
	}
	
	//로그인 후  '활동내역'란의 내가 쓴 qna 리스트
	@RequestMapping(value = "myQnAlist.do", method = RequestMethod.GET)
	public String myQnaListHandle() {

		return "myQnAlist";
	}

		
	// 장희수 파트///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// 관리자 메인 페이지
	@RequestMapping(value = "adminMain.do", method = RequestMethod.GET)
	public String adminMainHandle() {

		return "adminMain";
	}

	// 고객센터
	@RequestMapping(value = "serviceCenter.do", method = RequestMethod.GET)
	public String serviceCenterHandle() {

		return "serviceCenter";
	}

	// 회원 메인 페이지
	@RequestMapping(value = "memberMain.do", method = RequestMethod.GET)
	public String memberMainHandle() {

		return "memberMain";
	}

	// 비지니스 회원 메인 페이지
	@RequestMapping(value = "businessMain.do", method = RequestMethod.GET)
	public String businessMainHandle() {

		return "businessMain";
	}

	// 로그인 후 네비게이션바의 '카드' 항목 - > 회원의 카드 리스트와 카드 상세 내용 출력 페이지
	@RequestMapping(value = "myCard.do", method = RequestMethod.GET)
	public String myCardHandle() {

		return "myCard";
	}

	
	// 황상호 파트/////////////////////////////////////////////////////////////////////////////////////////////////////
	// 비지니스 회원 메인 페이지
	@RequestMapping(value = "companyIntroduce.do", method = RequestMethod.GET)
	public String companyIntroduceHandle() {

		return "companyIntroduce";
	}

	// 로그인 후 네비게이션바의 '카드' 항목 - > 회원의 카드 리스트와 카드 상세 내용 출력 페이지
	@RequestMapping(value = "qnaRead.do", method = RequestMethod.GET)
	public String qnaReadHandle() {

		return "qnaRead";
	}

	// 로그인 후 네비게이션바의 '카드' 항목 - > 회원의 카드 리스트와 카드 상세 내용 출력 페이지
	@RequestMapping(value = "qnaWrite.do", method = RequestMethod.GET)
	public String qnaWriteHandle() {

		return "qnaWrite";
	}

	// 로그인 후 네비게이션바의 '카드' 항목 - > 회원의 카드 리스트와 카드 상세 내용 출력 페이지
	@RequestMapping(value = "qnaUpdate.do", method = RequestMethod.GET)
	public String qnaUpdateHandle() {

		return "qnaUpdate";
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

	
	
	
	
	//이경희 파트 ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	@RequestMapping(value = "admin_headBar.do", method = RequestMethod.GET)
	public String admin_headBarHandle() {

		return "admin_headBar";
	}
	
	
	@RequestMapping(value = "user_headBar.do", method = RequestMethod.GET)
	public String user_headBarHandle() {

		return "user_headBar";
	}


	
	@RequestMapping(value = "admin_userList_01.do", method = RequestMethod.GET)
	public String admin_userList_01Handle() {

		return "admin_userList_01";
	}

	
	@RequestMapping(value = "admin_userList_02.do", method = RequestMethod.GET)
	public String admin_userList_02Handle() {

		return "admin_userList_02";
	}

	
	@RequestMapping(value = "admin_userList_03.do", method = RequestMethod.GET)
	public String admin_userList_03Handle() {

		return "admin_userList_03";
	}

	
	@RequestMapping(value = "admin_userList_index.do", method = RequestMethod.GET)
	public String admin_userList_indexHandle() {

		return "admin_userList_index";
	}

	
	@RequestMapping(value = "police.do", method = RequestMethod.GET)
	public String policeHandle() {

		return "police";
	}

	
	@RequestMapping(value = "registerForm_03_b.do", method = RequestMethod.GET)
	public String registerForm_03_bHandle() {

		return "registerForm_03_b";
	}

	
	@RequestMapping(value = "registerForm_03_p.do", method = RequestMethod.GET)
	public String registerForm_03_pHandle() {

		return "registerForm_03_p";
	}

	



	/////////

	@RequestMapping(value = "join_first.do", method = RequestMethod.GET)
	public String join_firstHandle() {

		return "join_first";
	}

	@RequestMapping(value = "log_v19.do", method = RequestMethod.GET)
	public String log_v19Handle() {

		return "log_v19";
	}

	
}
