package kr.spring.member.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.spring.member.domain.MemberCommand;
import kr.spring.member.service.MemberService;
import kr.spring.member.validator.LoginValidator;

@Controller
@RequestMapping("/login.do")
public class LoginController {
	
	//�α�ó��
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="memberService")
	private MemberService memberService;
	
	//Ŀ�ǵ尴ü(�ڹٺ�) �ʱ�ȭ
	@ModelAttribute("member")
	public MemberCommand initCommand() {
		return new MemberCommand();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String form() {
		return "loginForm";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String submit(@ModelAttribute("member") MemberCommand memberCommand, BindingResult result, HttpSession session) {
		
		if(log.isDebugEnabled()){
			log.debug("memberCommand : " + memberCommand);
		}
		
		//��ȿ�� üũ
		new LoginValidator().validate(memberCommand, result);
		if(result.hasErrors()) {
			return form();
		}
		
		//�α��� üũ
		try {
			//���������� �α��� �� ���, member->db���� ������ id
			MemberCommand member = memberService.getMember(memberCommand.getId());
			
			boolean check = false;
			
			if(member!=null) {
											//����ڰ� �Է��� passwd�� db�� passwd ��
				check = member.isCheckedPasswd(memberCommand.getPasswd());
			}
			if(check) {
				//���� ����
				//�α��� ó��(���ǿ� id �ֱ�..?)
				session.setAttribute("userId", memberCommand.getId());
				return "redirect:/list.do";
			}else {
				//���� ����
				throw new Exception();
			}
			
		}catch(Exception e) {
			//���������� �ȵǸ� loginForm.jsp�� ������
			//���� ���з� �� ȣ��
			result.reject("invalidIdOrPassword");
			return form();
		}
		
	}
	
}
