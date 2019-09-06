package oracle.java.nomyBatis3.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import oracle.java.nomyBatis3.service.AutoPayService;
import oracle.java.nomyBatis3.service.CardService;
import oracle.java.nomyBatis3.service.MemberService;
import oracle.java.nomyBatis3.service.PayListService;
import oracle.java.nomyBatis3.service.QnaCommentService;
import oracle.java.nomyBatis3.service.QnaMainService;
import oracle.java.nomyBatis3.service.QnaService;


@Controller
public class MemberController {

	
	@Autowired
	private MemberService ms;
	@Autowired
	private AutoPayService as;
	@Autowired
	private CardService cs;
	@Autowired
	private PayListService ps;
	@Autowired
	private QnaCommentService qcs;
	@Autowired
	private QnaMainService qms;
	@Autowired
	private QnaService qs;
	
	
	
/*	@RequestMapping(value="listMember")
	public String listMember(MemberDao mdao,Model model,String currentPage){
		
		
		int total=ms.total();
		System.out.println("controller_01");
		
		
		//model.addAttribute("list",listMember(null, null));
		System.out.println("controller_02");
		return "listMember";
		
	}*/
	
	
	@RequestMapping(value="loginForm")
	public String loginForm(Model model){
		return "loginForm";
	}
	
	@RequestMapping(value="main")
	public String main(Model model){
		System.out.println("11111111111111111111111");
		return "main";
		
		
	}
	
	
}
