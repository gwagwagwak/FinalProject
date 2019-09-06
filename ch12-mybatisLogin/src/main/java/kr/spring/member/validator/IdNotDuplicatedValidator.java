package kr.spring.member.validator;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import kr.spring.member.domain.MemberCommand;
import kr.spring.member.service.MemberService;

//일반 클래스라 Component
@Component
public class IdNotDuplicatedValidator implements Validator {

	@Resource(name="memberService")
	private MemberService memberService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return MemberCommand.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		MemberCommand memberCommand = (MemberCommand)target;
		
		//아이디 중복 체크
		if(memberCommand.getId() != null && !memberCommand.getId().trim().isEmpty()) {
			MemberCommand member = memberService.getMember(memberCommand.getId());
			
			if(member != null && member.getId().equals(memberCommand.getId())){
				//아이디 중복
				errors.rejectValue("id", "duplicatedId");
			}
		}
		
	}

}
